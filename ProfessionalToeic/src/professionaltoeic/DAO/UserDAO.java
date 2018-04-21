/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import professionaltoeic.Model.User;



/**
 *
 * @author curly
 */
public class UserDAO {
    private DataProvider dp;
    private static User user ;
    public UserDAO() throws ClassNotFoundException,SQLException{
        dp = new DataProvider();
    }
    public List<User> getAllUser() throws ClassNotFoundException,SQLException{
        List<User> userlist= new ArrayList<>();
        String sql = "SELECT * from user";
        ResultSet rs = dp.executeReader(sql);
        while(rs.next()){
            int id = rs.getInt("user_id");
            String name = rs.getString("user_name");
            String fullname = rs.getString("user_fullname");
            String password = rs.getString("password");
            int type =rs.getInt("type");
            String email =rs.getString("email");
            int flag = rs.getInt("flag");
            int point =rs.getInt("point");
            String status ="";
            if(flag==1)
                status= "In use";
            else 
                status = "Deleted";
            User u = new User(id,name,fullname,password,type,email,status,point);
            userlist.add(u);
        }
        rs.close();
        dp.closeDB();
       return userlist ; 
    }
    
    public User getUserByUserName(String uName) throws ClassNotFoundException,SQLException{
        User user= null;
        String sql ="SELECT * FROM user WHERE user_name = '" + uName+"'";
        ResultSet rs = dp.executeReader(sql);
        while(rs.next()){
            int id = rs.getInt("user_id");
            String name = rs.getString("user_name");
            String fullname = rs.getString("user_fullname");
            String password = rs.getString("password");
            int type =rs.getInt("type");
            String email =rs.getString("email");
            int flag = rs.getInt("flag");
            int point =rs.getInt("point");
            String status ="";
            if(flag==1)
                status= "In use";
            else 
                status = "Deleted";
            user = new User(id,name,fullname,password,type,email,status,point);
        }
        rs.close();
        dp.closeDB();
        return user;
    }
    public void insertUser(String id,String password,String fullname,String email) throws ClassNotFoundException,SQLException{
        String sql ="INSERT INTO user(user_name,user_fullname,password,type,email,flag) VALUES('"+id+"','"+fullname+"','"+password+"',2,'"+email+"',1)";
        PreparedStatement rs = dp.getConnection().prepareStatement(sql);
        rs.executeUpdate();
        rs.close();
        dp.closeDB();
    }
    
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET user_fullname = ?, password = ?, type = ?, "
                + "email = ?, flag = ? WHERE user_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getType());
            ps.setString(4, user.getEmail());
            ps.setInt(5, 1);
            ps.setInt(6, user.getId());
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET flag = 9 "
                + "WHERE user_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    public boolean reverseUser(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET flag = 1 "
                + "WHERE user_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }
    
    public static User getLoginUser(){
        return user;
    }
     public static void setLoginUser(User user) {
        UserDAO.user = user;
    }
}
