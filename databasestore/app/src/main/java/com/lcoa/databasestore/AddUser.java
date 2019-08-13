package com.lcoa.databasestore;

public class AddUser {
    private String id;
    private  String username;
    private  String useremail;
    private String userpassword;
    private String phnno;
    private  String city;
    private String dob;
    private  String gender;

    public AddUser(String id, String username, String useremail, String userpassword, String phnno, String city, String dob,String gender) {
        this.id = id;
        this.username = username;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.phnno = phnno;
        this.city = city;
        this.dob = dob;
       this.gender=gender;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUseremail() {
        return useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getPhnno() {
        return phnno;
    }

    public String getCity() {
        return city;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }
}
