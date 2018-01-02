package org.afdemp.bootcamp2.lesson5.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.afdemp.bootcamp2.lesson5.project.connection.DB;
import org.afdemp.bootcamp2.lesson5.project.domain.User;

public class UserDAO {

    public UserDAO() {
        // TODO Auto-generated constructor stub
    }

    public User authenticateUser(String username, String password) throws Exception {

        Connection con = null;
        DB db = new DB();
        User user = null;

        try {

            db.open();
            con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user_table WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"));
            } else {
                throw new Exception("Invalid username or password");
            }

            rs.close();
            pstmt.close();
            db.close();

            return user;
        } catch (Exception e) {
            throw new Exception("An error occured while getting user from database: " + e.getMessage());
        } finally {

            try {
                db.close();
            } catch (Exception e) {

            }

        }

    } //End of authenticateUser

} //End of class
