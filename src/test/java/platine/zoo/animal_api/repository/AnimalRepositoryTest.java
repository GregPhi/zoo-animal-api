package platine.zoo.animal_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import platine.zoo.animal_api.bo.Animal;
import platine.zoo.animal_api.bo.Description;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AnimalRepositoryTest {
    @Autowired
    private AnimalRepository repository;

    @Test
    void testSave(){
        var tiger = new Animal();
        tiger.setName("Tiger");

        repository.save(tiger);

        var saved = repository.findById(tiger.getName()).orElse(null);

        assertEquals("Tiger", saved.getName());
    }

    @Test
    void testSaveWithDescription(){
        var tiger = new Animal();
        tiger.setName("Tiger");

        var description_tiger = new Description();
        description_tiger.setDescription("Tiger of bengal");

        repository.save(tiger);

        var saved = repository.findById(tiger.getName()).orElse(null);

        assertEquals("Tiger", saved.getName());
        assertNotNull(saved.getDescription());
    }

    @Test
    void testDelete(){
        var tiger = new Animal();
        tiger.setName("Tiger");

        repository.save(tiger);
        repository.delete(tiger);

        var saved = repository.findById(tiger.getName()).orElse(null);

        assertNull(saved);
    }
}
