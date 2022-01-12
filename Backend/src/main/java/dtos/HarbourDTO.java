package dtos;

import entities.Harbour;

import java.util.ArrayList;
import java.util.List;

public class HarbourDTO {

    private Long id;
    private String address;
    private int capacity;
    private String name;
    private List<BoatDTO> boat = new ArrayList<>();

    public HarbourDTO(Harbour H) {
        this.id = Long.valueOf(H.getId());
        this.address = H.getAddress();
        this.capacity = H.getCapacity();
        this.name = H.getName();
        H.getBoatList().forEach(h -> boat.add(new BoatDTO(h)));
    }

    public HarbourDTO(Long id, String address, int capacity, String name) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
