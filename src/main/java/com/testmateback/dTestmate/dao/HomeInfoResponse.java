package com.testmateback.dTestmate.dao;

import java.util.List;

public class HomeInfoResponse {
    private List<EditSubjectData> editSubjectList;
    private List<TestInfoData> testInfoList;
    private List<WrongNoteData> wrongNoteList;
    private List<HomeData> homeList;

    public List<EditSubjectData> getEditSubjectList() {
        return editSubjectList;
    }

    public void setEditSubjectList(List<EditSubjectData> editSubjectList) {
        this.editSubjectList = editSubjectList;
    }

    public List<TestInfoData> getTestInfoList() {
        return testInfoList;
    }

    public void setTestInfoList(List<TestInfoData> testInfoList) {
        this.testInfoList = testInfoList;
    }

    public List<WrongNoteData> getWrongNoteList() {
        return wrongNoteList;
    }

    public void setWrongNoteList(List<WrongNoteData> wrongNoteList) {
        this.wrongNoteList = wrongNoteList;
    }

    public List<HomeData> getHomeList() {
        return homeList;
    }

    public void setHomeList(List<HomeData> homeList) {
        this.homeList = homeList;
    }
}
