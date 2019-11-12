package module_two.polymorphism;

public class NotepadDemo {
    public static void main(String[] args) {

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        String txt = "\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem " +
                "accusantium doloremque laudantium, totam rem aperiam.";

        INotepad simpleNotepad = new SimpleNotepad(5);
        INotepad securedNotepad = new SecuredNotepad(5, "pAs5w0rD!");

        simpleNotepad.addTextToPage(text, 1);
        simpleNotepad.addTextToPage("aksdjasdja;osidj", 2);
        simpleNotepad.overridePageText("It was nonsense...", 2);

        System.out.println();
        securedNotepad.addTextToPage(txt, 2);
        simpleNotepad.addTextToGivenPage(text, 1);
        simpleNotepad.addTextToGivenPage("aksdjasdja;osidj", 2);
        simpleNotepad.overrideTextToGivenPage("It was nonsense...", 2);

        System.out.println();
        securedNotepad.addTextToGivenPage(txt, 2);

        simpleNotepad.viewNotepad();
        securedNotepad.viewNotepad();
    }
}
