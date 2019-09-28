package com.orange_infinity.vkhack.model.entity.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("admins")
    @Expose
    private List<Object> admins = null;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("date")
    @Expose
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
