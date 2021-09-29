package com.example.assigmentandroid.modal;

import java.util.Date;

public class Expenses {
    private int id;
    private String name;
    private double mount;
    private String categoryId;
    private String description;
    private String details;
    private Date dateSpend;

    public Expenses() {
    }

    public Expenses(int id, String name, double mount, String categoryId, String description, String details, Date dateSpend) {
        this.id = id;
        this.name = name;
        this.mount = mount;
        this.categoryId = categoryId;
        this.description = description;
        this.details = details;
        this.dateSpend = dateSpend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDateSpend() {
        return dateSpend;
    }

    public void setDateSpend(Date dateSpend) {
        this.dateSpend = dateSpend;
    }
}
