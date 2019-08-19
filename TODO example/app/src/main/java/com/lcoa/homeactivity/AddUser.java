package com.lcoa.homeactivity;

public class AddUser {
    private  String id;
    private  String title;
    private String des;
    public AddUser()
    {

    }

    public AddUser(String id, String title, String des) {
        this.id=id;
        this.title=title;
        this.des=des;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }
}
