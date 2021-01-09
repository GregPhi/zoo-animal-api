package platine.zoo.animal_api.bo;

import org.junit.jupiter.api.Test;

import javax.persistence.Embeddable;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DescriptionTest {
    @Test
    void description_shouldBeAnEmbeddable(){
        assertNotNull(Description.class.getAnnotation(Embeddable.class));
    }
}
