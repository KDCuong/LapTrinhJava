/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.DAO;

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
            String status ="";
            if(flag==1)
                status= "In use";
            else 
                status = "Delete";
            User u = new User(id,name,fullname,password,type,email,status);
            userlist.add(u);
        }
        rs.close();
        dp.closeDB();
       return userlist ; 
    }
    public boolean getUser(String name, String password) throws ClassNotFoundException,SQLException{
        String sql ="SELECT * FROM user WHERE user_name = '" + name+"'"+ " AND password = '"+password+"'";
        ResultSet rs = dp.executeReader(sql);
        while (rs.next()){
        String namer =rs.getString("user_name");
        if(namer.equals(name)){
            return true;
        }}
        return false;
    }
}
