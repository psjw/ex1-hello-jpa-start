package 값타입.값타입컬렉션해결방안;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity  {
    @Id
    @GeneratedValue
    private Long id;

    private Address address;

    public AddressEntity(String homeCity, String street, String number) {
        this.address = new Address(homeCity, street, number);
    }

    public AddressEntity(Long id, Address address) {
        this.id = id;
        this.address = address;
    }

    public AddressEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
