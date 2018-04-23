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
public class History {
    private String user;
    private int point;
    private String date;

    @Override
    public String toString() {
        return "History{" + "user=" + user + ", point=" + point + ", date=" + date + '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public History(String user, int point, String date) {
        this.user = user;
        this.point = point;
        this.date = date;
    }
}
