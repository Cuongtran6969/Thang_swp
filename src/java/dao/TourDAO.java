/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import models.Tour;

/**
 *
 * @author admin
 */
public class TourDAO extends DBContext{
    
    //get tour by discount
    public Vector<Tour> getAllToursPaging( int pageIndex, int pageSize) {
        Vector<Tour> tours = new Vector<>();
        String sql = "SELECT t.* FROM Tour t "
                + "ORDER BY t.id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, (pageIndex - 1) * pageSize); // OFFSET
            st.setInt(2, pageSize);                  // FETCH NEXT

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tour t = new Tour();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setLocation(rs.getString("location"));
                t.setPrice(rs.getDouble("price"));
                t.setTransport(rs.getString("transport"));
                t.setDescription(rs.getString("description"));
                t.setStartDate(rs.getDate("startDate"));
                t.setEndDate(rs.getDate("endDate"));
                t.setImage_url(rs.getString("image_url"));
                t.setType(rs.getString("type"));
                tours.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }
    
public Vector<Tour> getAllTours() {
        Vector<Tour> tours = new Vector<>();
        String sql = "SELECT t.* FROM Tour t "
                + "JOIN TourDiscount td ON td.tour_id = t.id "
                + "ORDER BY t.id ";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tour t = new Tour();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setLocation(rs.getString("location"));
                t.setPrice(rs.getDouble("price"));
                t.setTransport(rs.getString("transport"));
                t.setDescription(rs.getString("description"));
                t.setStartDate(rs.getDate("startDate"));
                t.setEndDate(rs.getDate("endDate"));
                t.setImage_url(rs.getString("image_url"));
                t.setType(rs.getString("type"));
                tours.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }
    
}
