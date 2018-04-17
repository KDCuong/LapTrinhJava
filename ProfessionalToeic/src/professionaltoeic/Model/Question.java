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
    private String id;
    private int type;
    private String content;
    private String audio;
    private String image;
    private String flag;
    private String anwser1;
    private String anwser2;
    private String anwser3;
    private String anwser4;

    public Question() {
    }

    public Question(String id, int type, String content, String flag) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.flag = flag;
    }

    
    public Question(String id, int type, String content, String audio, String image, String flag, String anwser1, String anwser2, String anwser3, String anwser4) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.audio = audio;
        this.image = image;
        this.flag = flag;
        this.anwser1 = anwser1;
        this.anwser2 = anwser2;
        this.anwser3 = anwser3;
        this.anwser4 = anwser4;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAnwser1() {
        return anwser1;
    }

    public void setAnwser1(String anwser1) {
        this.anwser1 = anwser1;
    }

    public String getAnwser2() {
        return anwser2;
    }

    public void setAnwser2(String anwser2) {
        this.anwser2 = anwser2;
    }

    public String getAnwser3() {
        return anwser3;
    }

    public void setAnwser3(String anwser3) {
        this.anwser3 = anwser3;
    }

    public String getAnwser4() {
        return anwser4;
    }

    public void setAnwser4(String anwser4) {
        this.anwser4 = anwser4;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", type=" + type + ", content=" + content + ", audio=" + audio + ", image=" + image + ", flag=" + flag + ", anwser1=" + anwser1 + ", anwser2=" + anwser2 + ", anwser3=" + anwser3 + ", anwser4=" + anwser4 + '}';
    }
    
}
