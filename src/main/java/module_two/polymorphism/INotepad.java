package module_two.polymorphism;

public interface INotepad {
    void addTextToPage(String text, int pageNumber);

    void overridePageText(String text, int pageNumber);

    void deletePageText(int pageNumber);
  
    void addTextToGivenPage(String text, int page);

    void overrideTextToGivenPage(String text, int page);

    void deleteTextFromGivenPage(int page);

    void viewNotepad();

    //second part of description

    boolean searchWord(String word);

    void printAllPagesWithDigits();
}
