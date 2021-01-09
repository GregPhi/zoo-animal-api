package platine.zoo.animal_api.bo;

import org.junit.jupiter.api.Test;

import javax.persistence.Embeddable;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ZooPositionTest {
    @Test
    void zooPosition_shouldBeAnEmbeddable(){
        assertNotNull(ZooPosition.class.getAnnotation(Embeddable.class));
    }
}
