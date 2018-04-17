/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cuong1312
 */
public class DataProvider {
    private Connection cn = null;
    private Statement stm = null;
    
    public Connection getConnection() {
        return cn;
    }
    
     public void initializeDB() throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx", "root", "");
        this.stm = cn.createStatement();
    }
     
     public ResultSet executeReader(String sql) throws SQLException, ClassNotFoundException {
        initializeDB();
        return stm.executeQuery(sql);
    }
     
     public void closeDB() throws SQLException {
        if(stm != null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(cn != null){
            try {
                cn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
