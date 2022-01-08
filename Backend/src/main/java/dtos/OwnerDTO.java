package dtos;

import entities.Owner;

public class OwnerDTO {

    private int id;
    private String name;
    private String address;
    private int phone;

    public OwnerDTO(Owner O) {
        this.id = O.getId();
        this.name = O.getName();
        this.address = O.getAddress();
        this.phone = O.getPhone();
    }

    public OwnerDTO(int id, String name, String address, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
