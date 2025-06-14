/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Tour {

    private int id;
    private String name, location, image_url, description, transport, type;
    private double price;
    private Date startDate;
    private Date endDate;

    public Tour() {
    }

    public Tour(int id, String name, String location, String image_url, String description, String transport, String type, double price, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.image_url = image_url;
        this.description = description;
        this.transport = transport;
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Tour{" + "id=" + id + ", name=" + name + ", location=" + location + ", image_url=" + image_url + ", description=" + description + ", transport=" + transport + ", type=" + type + ", price=" + price + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    
}
