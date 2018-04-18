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

/**
 *
 * @author cuong1312
 */
public class QuestionDAO {

    private DataProvider dp;

    public QuestionDAO() throws ClassNotFoundException, SQLException {
        dp = new DataProvider();
    }

    public List<Question> getAllQuestions() throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM question";
        ResultSet rs = dp.executeReader(sql);
        while (rs.next()) {
            String id = rs.getString("question_id");
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
            String id = rs.getString("question_id");
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

    public boolean insertListeningQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO question (question_type, question_img, question_audio, "
                + "anwser_1, anwser_2, anwser_3, anwser_4, question_flag, question_anwser) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);

        ps.setInt(1, question.getType());
        ps.setString(2, question.getImage());
        ps.setString(3, question.getAudio());
        ps.setString(4, question.getAnwser1());
        ps.setString(5, question.getAnwser2());
        ps.setString(6, question.getAnwser3());
        ps.setString(7, question.getAnwser4());
        ps.setInt(8, 1);
        ps.setString(9, question.getAnwser());
        int i = 0;
        i = ps.executeUpdate();
        ps.close();
        dp.closeDB();
        return i != 0;
    }
}
