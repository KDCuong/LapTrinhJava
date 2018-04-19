/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Model;

/**
 *
 * @author cuong1312
 */
public class Question {
    private int id;
    private int type;
    private String content;
    private String audio;
    private String image;
    private String flag;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer;

    public Question(int id, int type, String content, String audio, String image, String flag, String answer1, String answer2, String answer3, String answer4, String answer) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.audio = audio;
        this.image = image;
        this.flag = flag;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question(int type, String audio, String image, String answer1, String answer2, String answer3, String answer4, String answer) {
        this.type = type;
        this.audio = audio;
        this.image = image;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer = answer;
    }

    
    public Question() {
    }

    public Question(int id, int type, String content, String flag) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.flag = flag;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", type=" + type + ", content=" + content + ", audio=" + audio + ", image=" + image + ", flag=" + flag + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", answer=" + answer + '}';
    }

}
