package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double subjects = 0;
        double scoreSum = 0;
        for (Pupil index : pupils) {
            for (Subject subj : index.subjects()) {
                scoreSum = scoreSum + subj.score();
                subjects++;
            }
        }
        return scoreSum / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        for (Pupil index : pupils) {
            int scoreSum = 0;
            for (Subject subj : index.subjects()) {
                scoreSum = scoreSum + subj.score();
            }
            score.add(new Label(index.name(), (double) scoreSum / index.subjects().size()));
        }
        return score;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil index : pupils) {
            for (Subject subj : index.subjects()) {
                    temp.put(subj.name(), temp.getOrDefault(subj.name(), 0) + subj.score());
            }
        }
        for (String tmp : temp.keySet()) {
            subjects.add(new Label(tmp, (double) (temp.get(tmp)) / pupils.size()));
        }
        return subjects;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        for (Pupil index : pupils) {
            int scoreSum = 0;
            for (Subject subj : index.subjects()) {
                scoreSum = scoreSum + subj.score();
            }
            score.add(new Label(index.name(), scoreSum));
        }
        score.sort(Comparator.naturalOrder());
        return score.get(score.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil index : pupils) {
            for (Subject subj : index.subjects()) {
                if (temp.containsKey(subj.name())) {
                    int rsl = temp.get(subj.name()) + subj.score();
                    temp.put(subj.name(), rsl);
                } else {
                    temp.put(subj.name(), subj.score());
                }
            }
        }
        for (String tmp : temp.keySet()) {
            subjects.add(new Label(tmp, (temp.get(tmp))));
        }
        subjects.sort(Comparator.naturalOrder());
        return subjects.get(subjects.size() - 1);
    }
}