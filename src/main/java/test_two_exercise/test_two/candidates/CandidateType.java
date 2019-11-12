package test_two_exercise.test_two.candidates;

import java.util.Arrays;
import java.util.List;

public enum CandidateType {
    MAFIAMAN(Arrays.asList(EducationType.NONE, EducationType.BASIC)),
    POLITICIAN(Arrays.asList(EducationType.MIDDLE, EducationType.UNIVERSITY)),
    SHOWMAN(Arrays.asList(EducationType.NONE, EducationType.BASIC, EducationType.UNIVERSITY));

    List<EducationType> educations;

    CandidateType(List<EducationType> educations) {
        this.educations = educations;
    }

    public List<EducationType> getEducations() {
        return educations;
    }
}
