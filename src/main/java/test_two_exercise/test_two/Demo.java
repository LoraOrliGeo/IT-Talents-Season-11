package test_two_exercise.test_two;

import test_two_exercise.test_two.candidates.*;
import test_two_exercise.test_two.voters.Voter;
import test_two_exercise.test_two.voters.VoterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Random r = new Random();

        // 1 - create 10 candidates
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Candidate candidate;
            String name = "Candidate" + (i + 1);
            CandidateType candidateType = CandidateType.values()[r.nextInt(CandidateType.values().length)];
            double money = 50000 + (300000 - 50000) * r.nextDouble();
            switch (candidateType) {
                case MAFIAMAN:
                    candidate = new MafiaMan(name, money);
                    break;
                case SHOWMAN:
                    candidate = new ShowMan(name, money);
                    break;
                default:
                    candidate = new Politician(name, money);
                    break;
            }
            candidates.add(candidate);
        }

        CEC cec = new CEC();
        Voter.cec = cec;

        List<Voter> allVoters = new ArrayList<>();
        for (Candidate candidate : candidates) {
            List<Voter> voters = candidate.getCampaign().generateVoters();
            allVoters.addAll(voters);
        }

        cec.addVoters(allVoters);

        int chanceVoteCampaignCandidate = r.nextInt(100);
        for (Voter voter : allVoters) {
            if ((voter.getType().equals(VoterType.MIDDLE_CLASS) && chanceVoteCampaignCandidate < 30)
                    || voter.getType().equals(VoterType.RICH) && chanceVoteCampaignCandidate < 50) {
                voter.setCandidate(candidates.get(r.nextInt(candidates.size())));
            }
            voter.vote();
        }

        cec.showStatistics();

    }
}
