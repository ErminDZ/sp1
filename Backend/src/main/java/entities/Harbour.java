package entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "harbour")
public class Harbour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "Id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "harbour", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Boat> boats;

    public Harbour() { }

    public Harbour(Long id, String name, String address, int capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.boats = new ArrayList<>();
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

    public void setAddress(String adress) {
        adress = adress;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Boat> getBoatList() {
        return boats;
    }

    public void addBoatList(Boat boat) {
        boats.add(boat);
    }
}