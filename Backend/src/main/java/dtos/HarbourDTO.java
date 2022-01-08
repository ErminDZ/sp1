package dtos;

import entities.Harbour;

public class HarbourDTO {

    private int id;
    private String address;
    private int capacity;
    private String name;

    public HarbourDTO(Harbour h) {
        this.id = h.getId();
        this.address = h.getAddress();
        this.capacity = h.getCapacity();
        this.name = h.getName();
    }

    public HarbourDTO(int id, String address, int capacity, String name) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
