package module_three.test_three_exercise.post_office_1.models;

import java.util.ArrayList;
import java.util.List;

public class PostBox {
    private List<Letter> letters;

    public PostBox() {
        this.letters = new ArrayList<>();
    }

    public void addLetter(Letter letter) {
        this.letters.add(letter);
    }

    public List<Letter> emptyBox(){
        List<Letter> taken = new ArrayList<>(this.letters);
        this.letters.clear();
        return taken;
    }
}
