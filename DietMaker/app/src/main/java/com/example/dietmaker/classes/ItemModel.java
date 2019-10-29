package com.example.dietmaker.classes;

public class ItemModel {
    private String title;
    private String body;
    private boolean isOpen;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ItemModel(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
