package com.company.internshipProject.Entity.JSONParser.TV;

public class CreatedBy {
    public int id;
    public String credit_id;
    public String name;
    public int gender;
    public Object profile_path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Object getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(Object profile_path) {
        this.profile_path = profile_path;
    }
}
