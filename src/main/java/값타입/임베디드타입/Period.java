package 값타입.임베디드타입;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

//@Embeddable
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
