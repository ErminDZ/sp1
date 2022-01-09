package entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "boat")
public class Boat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "boat_id")
    private int boat_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "make")
    private String make;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @ManyToOne
    private Harbour harbour;

    @ManyToMany (mappedBy = "boats", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Owner> ownerList;

    public Boat() {}

    public Boat(int id, String brand, String make, String name, String image) {
        this.boat_id = id;
        this.brand = brand;
        this.make = make;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return boat_id;
    }

    public void setId(int boat_id) {
        this.boat_id = boat_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Harbour getHarbour() {
        return harbour;
    }

    public void setHarbour(Harbour harbour) {
        this.harbour = harbour;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> OwnerList) {
        this.ownerList = ownerList;
    }
}
