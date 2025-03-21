package 상속.구현클래스마다테이블전략;

import jakarta.persistence.*;

//@Entity //기본전략은 Single Table 하나의 테이블에 때려박음
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn //DTYPE 컬럼 생김 name으로 이름 변경 가능
public abstract class Item { //abstract클래스로 안 만들면 ITEM테이블도 생성 -> 따로 사용할수 있다고 판단.

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
