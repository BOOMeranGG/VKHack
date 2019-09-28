package com.orange_infinity.vkhack.model.entity.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bdate")
    @Expose
    private String bdate;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("key_abilities")
    @Expose
    private String keyAbilities;
    @SerializedName("events_admin")
    @Expose
    private List<Object> eventsAdmin = null;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;
    @SerializedName("_links")
    @Expose
    private Links_ links;
    @SerializedName("organizations")
    @Expose
    private List<Organization> organizations = null;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("organizations_admin")
    @Expose
    private List<Object> organizationsAdmin = null;
    @SerializedName("about_me")
    @Expose
    private String aboutMe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getKeyAbilities() {
        return keyAbilities;
    }

    public void setKeyAbilities(String keyAbilities) {
        this.keyAbilities = keyAbilities;
    }

    public List<Object> getEventsAdmin() {
        return eventsAdmin;
    }

    public void setEventsAdmin(List<Object> eventsAdmin) {
        this.eventsAdmin = eventsAdmin;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Object> getOrganizationsAdmin() {
        return organizationsAdmin;
    }

    public void setOrganizationsAdmin(List<Object> organizationsAdmin) {
        this.organizationsAdmin = organizationsAdmin;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

}
