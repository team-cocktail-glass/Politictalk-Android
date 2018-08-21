package politictalk.dsm.Report;

import android.graphics.drawable.Drawable;

public class Data {

    private int image;
    private String name;
    private String adress;
    private int peoplenum;
    private int firenum;
    private String date;

    public Data(int image, String name, String adress, int peoplenum, int firenum, String date){
        this.image = image;
        this.name = name;
        this.adress = adress;
        this.firenum = firenum;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(int peoplenum) {
        this.peoplenum = peoplenum;
    }

    public int getFirenum() {
        return firenum;
    }

    public void setFirenum(int firenum) {
        this.firenum = firenum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
