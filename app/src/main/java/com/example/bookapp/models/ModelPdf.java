package com.example.bookapp.models;

public class ModelPdf {
    String uid, id, title, description, categoryId, url;
    String timestamp;
    Integer viewsCount, downLoadsCount;

    public ModelPdf() {

    }

    public ModelPdf(String uid, String id, String title, String description, String categoryId, String url, String timestamp, Integer viewsCount, Integer downLoadsCount) {
        this.uid = uid;
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.url = url;
        this.timestamp = timestamp;
        this.viewsCount = viewsCount;
        this.downLoadsCount = downLoadsCount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Integer getDownLoadsCount() {
        return downLoadsCount;
    }

    public void setDownLoadsCount(Integer downLoadsCount) {
        this.downLoadsCount = downLoadsCount;
    }
}

