package module_two.polymorphism;

public class SimpleNotepad implements INotepad {
    private Page[] pages;

    public SimpleNotepad(int numberOfPages) {
        if (numberOfPages > 0) {
            this.pages = new Page[numberOfPages];
            this.appendPages();
        } else {
            System.out.println("You can not create notepad without any pages!");
        }
    }

    @Override
    public void addTextToGivenPage(String text, int page) {
        if (pageExists(page)) {
            pages[page - 1].addText(text);
        }
    }

    @Override
    public void overrideTextToGivenPage(String text, int page) {
        if (pageExists(page)) {
            deleteTextFromGivenPage(page);
            this.pages[page - 1].addText(text);
        }
    }

    @Override
    public void deleteTextFromGivenPage(int page) {
        if (pageExists(page)) {
            this.pages[page - 1].deleteText();
        }
    }

    @Override
    public void viewNotepad() {
        for (Page page : this.pages) {
            if (page != null) {
                System.out.println(page.viewPage());
            }
        }
    }

    private void appendPages() {
        for (int i = 0; i < this.pages.length; i++) {
            pages[i] = new Page("", "");
        }
    }

    private boolean pageExists(int page) {
        return 1 <= page && page <= this.pages.length;
    }

    @Override
    public boolean searchWord(String word) {
        for (Page page : this.pages) {
            if (page.searchWord(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printAllPagesWithDigits() {
        for (Page page : this.pages) {
            if (page.containsDigits()){
                System.out.println(page.viewPage());
            }
        }
    }
}
