package politictalk.dsm.Meeting;

public class MeetingMainData {
    private String image;
    private String name;
    private String adress;
    private String pId;

    public MeetingMainData(String image, String name, String adress, String date, String pId){
        this.image = image;
        this.name = name;
        this.adress = adress;
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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
