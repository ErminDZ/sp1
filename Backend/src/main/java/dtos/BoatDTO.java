package dtos;

import entities.Boat;

public class BoatDTO {

    private Long id;
    private String brand;
    private String image;
    private String make;
    private String name;
    private Long harbour;



    public BoatDTO(Boat b) {
        this.id = Long.valueOf(b.getId());
        this.brand = b.getBrand();
        this.image = b.getImage();
        this.make = b.getMake();
        this.name = b.getName();
        this.harbour = b.getHarbour().getId();
    }

    public BoatDTO(Long id, String brand, String image, String make, String name) {
        this.id = id;
        this.brand = brand;
        this.image = image;
        this.make = make;
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}
