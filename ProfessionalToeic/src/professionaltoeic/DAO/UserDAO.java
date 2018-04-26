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
import professionaltoeic.Model.History;
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
    
    //Get all user in database
    public List<User> getAllUser() throws ClassNotFoundException,SQLException{
        List<User> userlist= new ArrayList<>();
        String sql = "SELECT * from user";
        try (ResultSet rs = dp.executeReader(sql)) {
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
        }
        dp.closeDB();
       return userlist ; 
    }
    
    //Get User by username
    public User getUserByUserName(String uName) throws ClassNotFoundException,SQLException{
        user = null;
        String sql ="SELECT * FROM user WHERE user_name = ?";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setString(1, uName);
        try (ResultSet rs = ps.executeQuery()) {
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
        }
        dp.closeDB();
        return user;
    }
    
    //Insert User
    public void insertUser(String name,String password,String fullname,String email) throws ClassNotFoundException,SQLException{
        String sql ="INSERT INTO user(user_name,user_fullname,password,email,type,flag) " +
                "VALUES(?,?,?,?,2,1)";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, fullname);
        ps.setString(3, password);
        ps.setString(4, email);
        ps.executeUpdate();
        dp.closeDB();
    }
    
    //Insert History
    public void insertHistory(String name,int point,String date) throws ClassNotFoundException,SQLException{
        String sql ="INSERT INTO history(user_name,point,date) " +
                "VALUES(?,?,?)";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, point);
        ps.setString(3, date);
        ps.executeUpdate();
        dp.closeDB();
    }
    
    //Get Historu
     public List<History> getHistory(String uName) throws ClassNotFoundException,SQLException{
         List<History> historyList= new ArrayList<>();
        String sql ="SELECT * FROM history WHERE user_name = ?";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setString(1, uName);
        try (ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                int point = rs.getInt("point");
                String name = rs.getString("user_name");
                String date = rs.getString("date");
                History history = new History(name,point,date);
                historyList.add(history);
            }
        }
        dp.closeDB();
        return historyList;
    }
     
    //Update Highest Point
     public boolean updatePoint(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET point = ? WHERE user_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, user.getPoint());
            ps.setInt(2, user.getId());
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    
    //Update User
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

    //Delete User
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

    //Make User up-to-date
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
    
    //Save User
    public static User getLoginUser(){
        return user;
    }
     public static void setLoginUser(User user) {
        UserDAO.user = user;
    }
}
