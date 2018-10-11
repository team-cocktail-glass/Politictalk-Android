package politictalk.dsm.Report;

public class FactionData {

    private String pId;
    private String image;
    private String name;
    private String adress;
    private int peoplenum;
    private int firenum;
    private String date;

    public FactionData(String image, String name, String adress, int peoplenum, int firenum, String date, String pId){
        this.image = image;
        this.name = name;
        this.adress = adress;
        this.firenum = firenum;
        this.peoplenum = peoplenum;
        this.date = date;
        this.pId = pId;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
