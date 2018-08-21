package politictalk.dsm.Report;

import android.graphics.drawable.Drawable;

public class ReportData {

    private int image;
    private String name;
    private String title;
    private int peoplenum;
    private String date;

    public ReportData(int image, String name, String title, int peoplenum, String date){
        this.image = image;
        this.name = name;
        this.title = title;
        this.peoplenum = peoplenum;
        this.date = date;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(int peoplenum) {
        this.peoplenum = peoplenum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
