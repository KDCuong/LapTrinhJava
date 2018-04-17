/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import professionaltoeic.Model.Question;

/**
 *
 * @author cuong1312
 */
public class QuestionDAO {
    private DataProvider dp;
    public QuestionDAO()throws ClassNotFoundException,SQLException{
         dp = new DataProvider() ;
    }
    
    
    public List<Question> getAllQuestions() throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql ="SELECT * From question";
            ResultSet rs = dp.executeReader(sql);
            while (rs.next()){
                String id = rs.getString("question_id");
                int type = rs.getInt("question_type");
                String content = rs.getString("question_content");
                int flag = rs.getInt("question_flag");
                String status = "";
                if (flag == 1) {
                    status = "In use";
                }
                else
                    status = "Deleted";
                Question qt = new Question(id, type, content, status);
                questionList.add(qt);
            }
            rs.close();
            dp.closeDB();
        return questionList;
    }
}
