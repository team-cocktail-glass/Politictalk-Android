package politictalk.dsm.Meeting;

public class ChoiceData {
    private int image;
    private String title;
    private String name;
    private String d_day;
    private int peopleNumber;

    public ChoiceData(int image, String title, String name, String d_day, int peoplenum) {
        this.image = image;
        this.title = title;
        this.name = name;
        this.peopleNumber = peoplenum;
        this.d_day = d_day;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getD_day() {
        return d_day;
    }

    public void setD_day(String d_day) {
        this.d_day = d_day;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeoplenum(int peopleNumber) {
        this.peopleNumber= peopleNumber;
    }
}
