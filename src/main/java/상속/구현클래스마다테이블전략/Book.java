package 상속.구현클래스마다테이블전략;

import jakarta.persistence.Entity;

//@Entity
public class Book extends Item {
    private String author;
    private String isbn;
}
