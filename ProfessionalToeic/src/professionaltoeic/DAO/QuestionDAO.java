/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.User;

/**
 *
 * @author cuong1312
 */
public class QuestionDAO {

    private DataProvider dp;
    private static Question question;
    public QuestionDAO() throws ClassNotFoundException, SQLException {
        dp = new DataProvider();
    }

    public List<Question> getAllQuestions() throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM question";
        ResultSet rs = dp.executeReader(sql);
        while (rs.next()) {
            int id = rs.getInt("question_id");
            int type = rs.getInt("question_type");
            String content = rs.getString("question_content");
            int flag = rs.getInt("question_flag");
            String status = "";
            if (flag == 1) {
                status = "In use";
            } else {
                status = "Deleted";
            }
            Question qt = new Question(id, type, content, status);
            questionList.add(qt);
        }
        rs.close();
        dp.closeDB();
        return questionList;
    }

    public List<Question> getAllQuestionsByComboBox(int Type) throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM question where question_type = ?";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setInt(1, Type);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("question_id");
            int type = rs.getInt("question_type");
            String content = rs.getString("question_content");
            int flag = rs.getInt("question_flag");
            String status = "";
            if (flag == 1) {
                status = "In use";
            } else {
                status = "Deleted";
            }
            Question qt = new Question(id, type, content, status);
            questionList.add(qt);
        }
        rs.close();
        dp.closeDB();
        return questionList;
    }
    
    public Question getQuestionsByID(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM question WHERE question_id = ?";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Question qt = new Question();
        if (rs.next()) {
            int type = rs.getInt("question_type");
            String content = rs.getString("question_content");
            int flag = rs.getInt("question_flag");
            String audio = rs.getString("question_audio");
            String image = rs.getString("question_img");
            String answer1 = rs.getString("answer_1");
            String answer2 = rs.getString("answer_2");
            String answer3 = rs.getString("answer_3");
            String answer4 = rs.getString("answer_4");
            String answer = rs.getString("question_answer");
            String status = "";
            if (flag == 1) {
                status = "In use";
            } else {
                status = "Deleted";
            }
            qt = new Question(id, type, content, audio, image, status, 
                                       answer1, answer2, answer3, answer4, answer);
        }
        rs.close();
        dp.closeDB();
        return qt;
    }
    public boolean insertListeningQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO question (question_type, question_img, question_audio, "
                + "answer_1, answer_2, answer_3, answer_4, question_flag, question_answer) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);

        ps.setInt(1, question.getType());
        ps.setString(2, question.getImage());
        ps.setString(3, question.getAudio());
        ps.setString(4, question.getAnswer1());
        ps.setString(5, question.getAnswer2());
        ps.setString(6, question.getAnswer3());
        ps.setString(7, question.getAnswer4());
        ps.setInt(8, 1);
        ps.setString(9, question.getAnswer());
        int i = 0;
        i = ps.executeUpdate();
        ps.close();
        dp.closeDB();
        return i != 0;
    }
    
    public static Question getQuestion(){
        return question;
    }
     public static void setQuestion(Question question) {
        QuestionDAO.question = question;
    }
}
