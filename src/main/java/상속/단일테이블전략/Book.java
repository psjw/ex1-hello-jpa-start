package 상속.단일테이블전략;

import jakarta.persistence.Entity;

//@Entity
public class Book extends Item {
    private String author;
    private String isbn;
}
