/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author admin
 */
public class TourDiscount {
    private int id, tour_id, discount_id;

    public TourDiscount() {
    }

    public TourDiscount(int id, int tour_id, int discount_id) {
        this.id = id;
        this.tour_id = tour_id;
        this.discount_id = discount_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    @Override
    public String toString() {
        return "TourDiscount{" + "id=" + id + ", tour_id=" + tour_id + ", discount_id=" + discount_id + '}';
    }
}
