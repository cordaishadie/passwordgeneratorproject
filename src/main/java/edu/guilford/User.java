package edu.guilford;

public class User {

    // attributes
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String favoriteColor;
    private String firstPet;
    private int birthYear;



    // constructors
    public User() {
    }

    public User(String firstName, String lastName, String email, String username, String password, String favoriteColor, 
    String firstPet, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.favoriteColor = favoriteColor;
        this.firstPet = firstPet;
        this.birthYear = birthYear;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getFirstPet() {
        return firstPet;
    }

    public void setFirstPet(String firstPet) {
        this.firstPet = firstPet;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    // methods
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username=" + username
                + ", password=" + password + "favoriteColor=" + favoriteColor + "]";
    }

    // method that generates a unique password based on the user's information 
    public String generatePassword() {
        String password = "";
        // the password is the first two numbers of the birth year
        password += birthYear / 100;
        // the first two letters of the first pet's name (capitalized)
        password += firstPet.substring(0, 2).toUpperCase();
        // the first two letters of the first name (capitalized)
        password += firstName.substring(0, 2).toUpperCase();
        // the last name in all lowercase
        password += lastName.toLowerCase();
        // the first letter of the favorite color (capitalized)
        password += favoriteColor.substring(0, 1).toUpperCase();
        // and the last two numbers of the birth year
        int lastTwoDigits = birthYear % 100;
        if (lastTwoDigits < 10) {
            password += "0";
        }
        password += lastTwoDigits;
        return password;
    }

    }

