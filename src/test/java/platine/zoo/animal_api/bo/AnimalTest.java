package platine.zoo.animal_api.bo;

import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnimalTest {
    @Test
    void animal_shouldBeAnEntity(){
        assertNotNull(Animal.class.getAnnotation(Entity.class));
    }
}
