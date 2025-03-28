package 값타입.값타입과불변객체;


import jakarta.persistence.Embeddable;

@Embeddable
public class Period {
    private String startDate;
    private String endDate;

    public Period(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Period() {

    }


    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
