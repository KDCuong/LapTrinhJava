/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Model;

/**
 *
 * @author curly
 */
public class QuestionAnswer {
    private int qNumber;
    private String uAnswer;
    private int correct;

    public QuestionAnswer(int qNumber, String uAnswer, int correct) {
        this.qNumber = qNumber;
        this.uAnswer = uAnswer;
        this.correct = correct;
    }

    public int getqNumber() {
        return qNumber;
    }

    public void setqNumber(int qNumber) {
        this.qNumber = qNumber;
    }

    public String getuAnswer() {
        return uAnswer;
    }

    public void setuAnswer(String uAnswer) {
        this.uAnswer = uAnswer;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    
}
