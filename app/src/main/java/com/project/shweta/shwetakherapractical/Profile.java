package com.project.shweta.shwetakherapractical;

public class Profile {

    private String first_name;
    private String last_name;
    private String dob;

    public Profile(){}

    public Profile(String first_name, String last_name, String dob) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }
}
