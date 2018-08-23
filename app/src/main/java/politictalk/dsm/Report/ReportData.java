package politictalk.dsm.Report;

public class ReportData {

    private int scenery;
    private String name;
    private String title;
    private String day;
    private String peoplenum;

    public ReportData(int scenery, String name, String title, String day, String peoplenum){
        this.day = day;
        this.scenery = scenery;
        this.name = name;
        this.title = title;
        this.peoplenum = peoplenum;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getName() { return name; }

    public void setPeoplenum(String peoplenum) { this.peoplenum = peoplenum; }

    public int getScenery() { return scenery; }

    public void setName(String name) { this.name = name; }

    public String getPeoplenum() { return peoplenum; }

    public void setScenery(int scenery) { this.scenery = scenery; }

    public String getDay() { return day; }

    public void setDay(String day) { this.day = day; }
}
