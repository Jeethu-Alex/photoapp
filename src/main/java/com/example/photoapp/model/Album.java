package com.example.photoapp.model;

public class Album {
    private String id;
    private String name;
    private String createdBy;
    private String coverPicUrl;
    private String dateCreated;

    public Album( String id, String name, String createdBy, String coverPicUrl, String dateCreated) {
        this.name = name;
        this.createdBy = createdBy;
        this.coverPicUrl = coverPicUrl;
        this.dateCreated = dateCreated;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(FirebaseUser firebaseUser){
        this.createdBy = firebaseUser.getEmail();
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

}
