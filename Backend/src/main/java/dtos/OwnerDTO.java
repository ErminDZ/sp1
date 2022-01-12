package dtos;

import entities.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerDTO {

    private Long id;
    private String name;
    private String address;
    private int phone;
    private List<BoatDTO> boat = new ArrayList<>();

    public OwnerDTO(Owner O) {
        this.id = O.getId();
        this.name = O.getName();
        this.address = O.getAddress();
        this.phone = O.getPhone();
        O.getBoats().forEach(o -> boat.add(new BoatDTO(o)));
    }

    public OwnerDTO(Long id, String name, String address, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
