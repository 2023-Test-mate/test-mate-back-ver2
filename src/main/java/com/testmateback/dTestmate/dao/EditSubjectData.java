package com.testmateback.dTestmate.dao;

public class EditSubjectData {
    private String subject;
    private byte[] photo;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getSubject() {
        return subject;
    }

    public byte[] getPhoto() {
        return photo;
    }
}
