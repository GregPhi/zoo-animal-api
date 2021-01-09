package platine.zoo.animal_api.service;

import org.junit.jupiter.api.Test;
import platine.zoo.animal_api.bo.Animal;
import platine.zoo.animal_api.repository.AnimalRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AnimalServiceImplTest {
    @Test
    void findAll_shouldCallTheRepository() {
        var animalRepo = mock(AnimalRepository.class);
        var animalService = new AnimalServiceImpl(animalRepo);

        animalService.findAll();

        verify(animalRepo).findAll();
    }

    @Test
    void findAnimalByName_shouldCallTheRepository() {
        var animalRepo = mock(AnimalRepository.class);
        var animalService = new AnimalServiceImpl(animalRepo);

        animalService.findAnimalByName("Tiger");

        verify(animalRepo).findAnimalByName("Tiger");
    }

    @Test
    void findAnimalById_shouldCallTheRepository() {
        var animalRepo = mock(AnimalRepository.class);
        var animalService = new AnimalServiceImpl(animalRepo);

        animalService.findAnimalById(1);

        verify(animalRepo).findAnimalById(1);
    }


    @Test
    void newAnimal_shouldCallTheRepository() {
        var animalRepo = mock(AnimalRepository.class);
        var animalService = new AnimalServiceImpl(animalRepo);

        var tigre = new Animal();
        animalService.save(tigre);

        verify(animalRepo).save(tigre);
    }

    @Test
    void updateAnimal_shouldCallTheRepository() {
        var animalRepo = mock(AnimalRepository.class);
        var animalService = new AnimalServiceImpl(animalRepo);

        var tigre = new Animal();
        animalService.save(tigre);

        var test = new Animal();
        animalService.updateAnimal(test);

        verify(animalRepo).save(test);
    }

    @Test
    void deleteAnimal_shouldCallTheRepository() {
        var animalRepo = mock(AnimalRepository.class);
        var animalService = new AnimalServiceImpl(animalRepo);

        var tigre = new Animal();
        animalService.save(tigre);

        animalService.delete(tigre);

        verify(animalRepo).delete(tigre);
    }
}
