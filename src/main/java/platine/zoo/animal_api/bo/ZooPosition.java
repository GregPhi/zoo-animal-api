package platine.zoo.animal_api.bo;

import javax.persistence.Embeddable;

@Embeddable
public class ZooPosition {
    private int longitude;
    private int latitude;

    public ZooPosition() {
    }

    public ZooPosition(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}
