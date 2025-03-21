package 상속.단일테이블전략;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//@Entity
@DiscriminatorValue("M") //DTYPE 값 변경
public class Movie extends Item {
    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
