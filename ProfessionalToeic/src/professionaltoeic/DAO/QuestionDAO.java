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
import professionaltoeic.Model.Question;
import professionaltoeic.Model.QuestionAnswer;

/**
 *
 * @author cuong1312
 */
public class QuestionDAO {

    private final DataProvider dp;
    private static Question question;
    private static int typeFlag;
    private static String pageFlag;
    private static List<QuestionAnswer> questionAnswer = new ArrayList<>();
    private static List<Question> questionUse = new ArrayList<>();

    //Connect to database
    public QuestionDAO() throws ClassNotFoundException, SQLException {
        dp = new DataProvider();
    }

    //Get all Question in database
    public List<Question> getAllQuestions() throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM question";
        try (ResultSet rs = dp.executeReader(sql)) {
            while (rs.next()) {
                int id = rs.getInt("question_id");
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
                String explain = rs.getString("question_explain");
                int pid = rs.getInt("paragraph_id");
                if (flag == 1) {
                    status = "In use";
                } else {
                    status = "Deleted";
                }
                Question qt = new Question(id, type, content, audio, image, status,
                        answer1, answer2, answer3, answer4, answer, explain, pid);
                questionList.add(qt);
            }
        }
        dp.closeDB();
        return questionList;
    }

    //Get all Question in database by type
    public List<Question> getAllQuestionsByComboBox(int Type) throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM question WHERE question_type = ?";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setInt(1, Type);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("question_id");
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
                String explain = rs.getString("question_explain");
                int pid = rs.getInt("paragraph_id");
                if (flag == 1) {
                    status = "In use";
                } else {
                    status = "Deleted";
                }
                Question qt = new Question(id, type, content, audio, image, status,
                        answer1, answer2, answer3, answer4, answer, explain, pid);
                questionList.add(qt);
            }
        }
        dp.closeDB();
        return questionList;
    }

     //Get all Question in database by type && flag
        public List<Question> getAllQuestionsByComboBoxTest(int Type) throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM question where question_type = ? AND question_flag = 1";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setInt(1, Type);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("question_id");
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
                String explain = rs.getString("question_explain");
                int pid = rs.getInt("paragraph_id");
                if (flag == 1) {
                    status = "In use";
                } else {
                    status = "Deleted";
                }
                Question qt = new Question(id, type, content, audio, image, status,
                        answer1, answer2, answer3, answer4, answer, explain, pid);
                questionList.add(qt);
            }
        }
        dp.closeDB();
        return questionList;
    }
        
    //Get Question in database by id
    public Question getQuestionsByID(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM question WHERE question_id = ?";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        Question qt;
        try (ResultSet rs = ps.executeQuery()) {
            qt = new Question();
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
                String explain = rs.getString("question_explain");
                int pid = rs.getInt("paragraph_id");
                if (flag == 1) {
                    status = "In use";
                } else {
                    status = "Deleted";
                }
                qt = new Question(id, type, content, audio, image, status,
                        answer1, answer2, answer3, answer4, answer, explain, pid);
            }
        }
        dp.closeDB();
        return qt;
    }

    //Get all ReadingQuestion in same paragraph
    public List<Question> getAllReadingQuestionsByIdParagraph(int Type, int paragraphId) throws SQLException, ClassNotFoundException {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM question WHERE question_type = ? AND paragraph_id = ? AND question_flag = 1";
        PreparedStatement ps = dp.getConnection().prepareStatement(sql);
        ps.setInt(1, Type);
        ps.setInt(2, paragraphId);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("question_id");
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
                String explain = rs.getString("question_explain");
                int pid = rs.getInt("paragraph_id");
                if (flag == 1) {
                    status = "In use";
                } else {
                    status = "Deleted";
                }
                Question qt = new Question(id, type, content, audio, image, status,
                        answer1, answer2, answer3, answer4, answer, explain, pid);
                questionList.add(qt);
            }
        }
        dp.closeDB();
        return questionList;
    }

    //Insert ListeningQuestion
    public boolean insertListeningQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO question (question_type, question_img, question_audio, "
                + "answer_1, answer_2, answer_3, answer_4, question_flag, question_answer, question_explain) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, question.getType());
            ps.setString(2, question.getImage());
            ps.setString(3, question.getAudio());
            ps.setString(4, question.getAnswer1());
            ps.setString(5, question.getAnswer2());
            ps.setString(6, question.getAnswer3());
            ps.setString(7, question.getAnswer4());
            ps.setInt(8, 1);
            ps.setString(9, question.getAnswer());
            ps.setString(10, question.getExplain());
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    //Insert ReadingQuestion and GrammarQuestion
    public boolean insertQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO question (question_type, question_content, paragraph_id, "
                + "answer_1, answer_2, answer_3, answer_4, question_flag, question_answer, question_explain) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, question.getType());
            ps.setString(2, question.getContent());
            ps.setInt(3, question.getParagraph_id());
            ps.setString(4, question.getAnswer1());
            ps.setString(5, question.getAnswer2());
            ps.setString(6, question.getAnswer3());
            ps.setString(7, question.getAnswer4());
            ps.setInt(8, 1);
            ps.setString(9, question.getAnswer());
            ps.setString(10, question.getExplain());
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    //Update ListeningQuestion
    public boolean updateListeningQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE question SET question_type = ?, question_img = ?, question_audio = ?, "
                + "answer_1 = ?, answer_2 = ?, answer_3 = ?, answer_4 = ?, "
                + "question_flag = ?, question_answer = ?, question_explain = ? "
                + "WHERE question_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, question.getType());
            ps.setString(2, question.getImage());
            ps.setString(3, question.getAudio());
            ps.setString(4, question.getAnswer1());
            ps.setString(5, question.getAnswer2());
            ps.setString(6, question.getAnswer3());
            ps.setString(7, question.getAnswer4());
            ps.setInt(8, 1);
            ps.setString(9, question.getAnswer());
            ps.setString(10, question.getExplain());
            ps.setInt(11, question.getId());
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    //Update ReadingQuestion and GrammarQuestion
    public boolean updateQuestion(Question question) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE question SET question_type = ?, question_content = ?, paragraph_id = ?, "
                + "answer_1 = ?, answer_2 = ?, answer_3 = ?, answer_4 = ?, "
                + "question_flag = ?, question_answer = ?, question_explain = ? "
                + "WHERE question_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, question.getType());
            ps.setString(2, question.getContent());
            ps.setInt(3, question.getParagraph_id());
            ps.setString(4, question.getAnswer1());
            ps.setString(5, question.getAnswer2());
            ps.setString(6, question.getAnswer3());
            ps.setString(7, question.getAnswer4());
            ps.setInt(8, 1);
            ps.setString(9, question.getAnswer());
            ps.setString(10, question.getExplain());
            ps.setInt(11, question.getId());
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    //Dalete All Type Question
    public boolean deleteQuestion(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE question SET question_flag = 9 "
                + "WHERE question_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    //Make deleted Question Up-to-date
    public boolean reverseQuestion(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE question SET question_flag = 1 "
                + "WHERE question_id = ?";
        int i;
        try (PreparedStatement ps = dp.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            i = 0;
            i = ps.executeUpdate();
        }
        dp.closeDB();
        return i != 0;
    }

    //Saving a question to new scene
    public static Question getQuestion() {
        return question;
    }
    public static void setQuestion(Question question) {
        QuestionDAO.question = question;
    }

    //Control ReadingQuestion and GrammarQuestion by Flag
    public static int getTypeQuestionFlag() {
        return typeFlag;
    }
    public static void setTypeQuestionFlag(int typeFlag) {
        QuestionDAO.typeFlag = typeFlag;
    }

    //Control Button Cancel by Flag
    public static String getTypePageFlag() {
        return pageFlag;
    }

    public static void setTypePageFlag(String pageFlag) {
        QuestionDAO.pageFlag = pageFlag;
    }

    public static List getQuestionAnswer() {
        return questionAnswer;
    }

    public static void setQuestionAnswer(QuestionAnswer questionanswer) {
        QuestionDAO.questionAnswer.add(questionanswer);
    }

    public static List getQuestionUse() {
        return questionUse;
    }

    public static void setQuestionUse(Question question) {
        QuestionDAO.questionUse.add(question);
    }

    public static void setQuestionUseNull() {
        questionUse = new ArrayList<>();
        questionAnswer = new ArrayList<>();
    }
}
