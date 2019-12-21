package module_three.files;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFDemo {
    public static void main(String[] args) {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(new File("C:\\Users\\Lori\\Desktop\\pdfdemo.pdf")));
            document.open();
            Font titleFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 20, BaseColor.BLACK);
            document.add(new Paragraph("Transaction Information\n", titleFont));
            Font contentFont = FontFactory.getFont(FontFactory.TIMES_ITALIC, 15, BaseColor.LIGHT_GRAY);
            document.add(new Chunk("Type: expense" +  System.lineSeparator(), contentFont)); // income or expense
            document.add(new Chunk("Category: groceries" +  System.lineSeparator(), contentFont));
            document.add(new Chunk("Amount: 45.98 $" +  System.lineSeparator(), contentFont));
            document.add(new Chunk("Date: 20.12.2019 21:11" +  System.lineSeparator(), contentFont));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
