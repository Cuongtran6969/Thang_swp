/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import models.Review;

/**
 *
 * @author admin
 */
public class ReviewDAO extends DBContext {

    public Vector<Review> getReviewsByTour(
            int tourId,
            String commentKeyword,
            String userKeyword,
            String sortType,
            int pageIndex,
            int pageSize
    ) {
        Vector<Review> list = new Vector<>();
        StringBuilder sql = new StringBuilder(
                "SELECT r.*, u.username FROM Review r "
                + "JOIN [User] u ON r.userId = u.id "
                + "WHERE r.tourId = ? AND r.comment LIKE '%" + commentKeyword + "%' AND u.username LIKE '%" + userKeyword + "%' "
        );

        switch (sortType) {
            case "rating_asc":
                sql.append("ORDER BY r.rating ASC ");
                break;
            case "rating_desc":
                sql.append("ORDER BY r.rating DESC ");
                break;
            case "date_asc":
                sql.append("ORDER BY r.reviewDate ASC ");
                break;
            case "date_desc":
            default:
                sql.append("ORDER BY r.reviewDate DESC ");
                break;
        }

        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        try {
            PreparedStatement st = connection.prepareStatement(sql.toString());
            st.setInt(1, tourId);
            st.setInt(2, (pageIndex - 1) * pageSize); // OFFSET
            st.setInt(3, pageSize); // FETCH NEXT

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Review r = new Review();
                r.setId(rs.getInt("id"));
                r.setStatus(rs.getString("status"));
                r.setUserId(rs.getInt("userId"));
                r.setTourId(rs.getInt("tourId"));
                r.setRating(rs.getInt("rating"));
                r.setComment(rs.getString("comment"));
                r.setReviewDate(rs.getDate("reviewDate"));
                r.setUsername(rs.getString("username")); // giả sử bạn thêm thuộc tính này trong model

                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countReviewsByTour(int tourId, String commentKeyword, String userKeyword) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Review r "
                + "JOIN [User] u ON r.userId = u.id "
                + "WHERE r.tourId = ? "
                + "AND r.comment LIKE ? "
                + "AND u.username LIKE ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, tourId);
            st.setString(2, "%" + commentKeyword + "%");
            st.setString(3, "%" + userKeyword + "%");

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public void hideReview(int reviewId, String status) {
        String sql = "UPDATE Review SET status = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, reviewId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
