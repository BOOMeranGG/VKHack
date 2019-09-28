package com.orange_infinity.vkhack.model.entity.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Organization {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("events")
    @Expose
    private List<Object> events = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("_links")
    @Expose
    private Links__ links;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("admins")
    @Expose
    private List<Object> admins = null;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getEvents() {
        return events;
    }

    public void setEvents(List<Object> events) {
        this.events = events;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Links__ getLinks() {
        return links;
    }

    public void setLinks(Links__ links) {
        this.links = links;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Object> admins) {
        this.admins = admins;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
