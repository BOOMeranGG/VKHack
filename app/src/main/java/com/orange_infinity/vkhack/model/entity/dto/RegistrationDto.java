package com.orange_infinity.vkhack.model.entity.dto;

public class RegistrationDto {

    private String name;
    private String surname;
    private String password;
    private String email;
    private String bdate;
    private String about_me;
    private String phone_number;
    private String key_abilities;

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getKey_abilities() {
        return key_abilities;
    }

    public void setKey_abilities(String key_abilities) {
        this.key_abilities = key_abilities;
    }

    /*
    * regDto.setAbout_me("");
        regDto.setPhone_number("");
        regDto.setKey_abilities("");
    *
    * */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
