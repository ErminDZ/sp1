package dtos;

import entities.Boat;

public class BoatDTO {

    private int id;
    private String brand;
    private String image;
    private String make;
    private String name;
    private int harbour_id;


    public BoatDTO(BoatDTO b) {
        this.id = b.getId();
        this.brand = b.getBrand();
        this.image = b.getImage();
        this.make = b.getMake();
        this.name = b.getName();
        this.harbour_id = b.harbour_id;
    }

    public BoatDTO(int id, String brand, String image, String make, String name, int harbour_id) {
        this.id = id;
        this.brand = brand;
        this.image = image;
        this.make = make;
        this.name = name;
        this.harbour_id = harbour_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHarbour_id() {
        return harbour_id;
    }

    public void setHarbour_id(int harbour_id) {
        this.harbour_id = harbour_id;
    }
}
