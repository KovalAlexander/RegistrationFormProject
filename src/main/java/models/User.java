package models;

public class User {

    private String validEmail;

    private String name;

    private String gender;

    public User(String validEmail, String name, String gender) {

        this.validEmail = validEmail;
        this.name = name;
        this.gender = gender;
    }

    public String getValidEmail() {
        return validEmail;
    }

    public void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
