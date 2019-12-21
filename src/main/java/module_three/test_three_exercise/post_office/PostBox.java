package module_three.test_three_exercise.post_office;

import java.util.ArrayList;
import java.util.List;

public class PostBox {
    private List<Letter> letters;

    public PostBox() {
        this.letters = new ArrayList<>();
    }

    public void addLetter(Letter letter) {
        // invoke by citizens
        this.letters.add(letter);
    }

    public List<Package> empty() {
        // invoke by gatherer
        List<Package> gatherLetters = new ArrayList<>(this.letters);
        this.letters.clear();
        return gatherLetters;
    }
}
