package com.testmateback.dTestmate.dao;

import java.util.List;

public class GoalCheckResponse {
    private List<String> checkedGoals;
    private List<String> noGoals;

    public List<String> getCheckedGoals() {
        return checkedGoals;
    }

    public void setCheckedGoals(List<String> checkedGoals) {
        this.checkedGoals = checkedGoals;
    }

    public List<String> getNoGoals() {
        return noGoals;
    }

    public void setNoGoals(List<String> noGoals) {
        this.noGoals = noGoals;
    }
}

