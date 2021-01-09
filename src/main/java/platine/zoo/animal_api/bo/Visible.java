package platine.zoo.animal_api.bo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Visible {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private ZooPosition zooPosition;

    public Visible() {
    }

    public Visible(String name) {
        this.name = name;
    }

    public Visible(int id, String name, ZooPosition zooPosition) {
        this.id = id;
        this.name = name;
        this.zooPosition = zooPosition;
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

    public ZooPosition getZooPosition() {
        return zooPosition;
    }

    public void setZooPosition(ZooPosition zooPosition) {
        this.zooPosition = zooPosition;
    }
}
