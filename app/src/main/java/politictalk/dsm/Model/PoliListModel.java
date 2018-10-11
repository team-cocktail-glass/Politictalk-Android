package politictalk.dsm.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PoliListModel {
    @SerializedName("address")
    private String address;

    public String getAddress() {
        return address;
    }

    @SerializedName("birthDay")
    private String birthDay;

    public String getBirthDay() {
        return birthDay;
    }

    @SerializedName("carrer")
    ArrayList<String> carrer = new ArrayList<>();

    public ArrayList<String> getCarrer() {
        return carrer;
    }

    @SerializedName("education")
    private String education;

    public String getEducation() {
        return education;
    }

    @SerializedName("job")
    private String jop;

    public String getJop() {
        return jop;
    }

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    @SerializedName("party")
    private String party;

    public String getParty() {
        return party;
    }

    @SerializedName("photo")
    private String photo;

    public String getPhoto() {
        return photo;
    }

    @SerializedName("politicationID")
    private String politicationID;

    public String getPoliticationID() {
        return politicationID;
    }

    @SerializedName("position")
    private String position;

    public String getPosition() {
        return position;
    }

    @SerializedName("recommend")
    private String recommend;

    public String getRecommend() {
        return recommend;
    }

    @SerializedName("region")
    private String region;

    public String getRegion() {
        return region;
    }

    @SerializedName("sex")
    private String sex;

    public String getSex() {
        return sex;
    }

    @SerializedName("votes")
    private String votes;

    public String getVotes() {
        return votes;
    }
}
