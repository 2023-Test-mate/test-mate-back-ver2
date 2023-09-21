package com.testmateback.dTestmate.dao;

public class TestInfoData {
    private String subject;
    private String grade;
    private int score;
    private String dates;
    private String levels;
    private int target;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    public String getDates() {
        return dates;
    }

    public String getLevels() {
        return levels;
    }

    public int getTarget() {
        return target;
    }


}
