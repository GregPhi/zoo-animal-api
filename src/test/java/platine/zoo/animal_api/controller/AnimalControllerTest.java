package platine.zoo.animal_api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.*;
import platine.zoo.animal_api.bo.Animal;
import platine.zoo.animal_api.exception.AnimalNotFoundException;
import platine.zoo.animal_api.service.AnimalService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class AnimalControllerTest {
    @Mock
    private AnimalService animalService;

    @InjectMocks
    private AnimalController animalController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllAnimals_shouldCallTheService() {
        animalController.getAllAnimals();

        verify(animalService).findAll();
    }

    @Test
    void getAnimal_shouldCallTheService() {
        animalController.getAnimalByName("Tiger");

        verify(animalService).findAnimalByName("Tiger");
    }

    @Test
    void newAnimal_shouldCallTheService(){
        Animal test = new Animal();
        test.setName("Tiger");
        animalController.newAnimal(test);

        verify(animalService).save(test);
    }

    @Test
    void updateAnimal_ThrowAnimalNotFoundException() {
        Animal test = new Animal();
        test.setName("Tiger");
        try {
            animalController.updateAnimal("Tiger",test);
            fail();
        } catch (AnimalNotFoundException e) {
            assertEquals("The animal : Tiger is not found !",e.getMessage());
        }
    }

    @Test
    void deleteAnimal_shouldCallTheService(){
        animalController.deleteAnimal("Tiger");

        verify(animalService).findAnimalByName("Tiger");
    }

    @Test
    void animalController_shouldBeAnnotated(){
        var controllerAnnotation =
                AnimalController.class.getAnnotation(RestController.class);
        assertNotNull(controllerAnnotation);

        var requestMappingAnnotation =
                AnimalController.class.getAnnotation(RequestMapping.class);
        assertArrayEquals(new String[]{"/animals"}, requestMappingAnnotation.value());
    }

    @Test
    void getAllAnimals_shouldBeAnnotated() throws NoSuchMethodException {
        var getAllAnimals =
                AnimalController.class.getDeclaredMethod("getAllAnimals");
        var getMapping = getAllAnimals.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value());
    }

    @Test
    void getAnimalByName_shouldBeAnnotated() throws NoSuchMethodException {
        var getAnimalByName =
                AnimalController.class.getDeclaredMethod("getAnimalByName", String.class);
        var getMapping = getAnimalByName.getAnnotation(GetMapping.class);

        var pathVariableAnnotation = getAnimalByName.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{name}"}, getMapping.value());

        assertNotNull(pathVariableAnnotation);
    }

    @Test
    void getAnimalById_shouldBeAnnotated() throws NoSuchMethodException {
        var getAnimalById =
                AnimalController.class.getDeclaredMethod("getAnimalById", int.class);
        var getMapping = getAnimalById.getAnnotation(GetMapping.class);

        var pathVariableAnnotation = getAnimalById.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{id}"}, getMapping.value());

        assertNotNull(pathVariableAnnotation);
    }

    @Test
    void newAnimal_shouldBeAnnotated() throws NoSuchMethodException {
        var newAnimal =
                AnimalController.class.getDeclaredMethod("newAnimal", Animal.class);
        var postMapping = newAnimal.getAnnotation(PostMapping.class);

        var requestBodyAnnotation = newAnimal.getParameters()[0].getAnnotation(RequestBody.class);

        assertNotNull(postMapping);
        assertArrayEquals(new String[]{"/"}, postMapping.value());

        assertNotNull(requestBodyAnnotation);
    }

    @Test
    void updateAnimal_shouldBeAnnotated() throws NoSuchMethodException {
        var updateAnimal =
                AnimalController.class.getDeclaredMethod("updateAnimal", String.class, Animal.class);
        var putMapping = updateAnimal.getAnnotation(PutMapping.class);

        var requestBodyAnnotation = updateAnimal.getParameters()[0].getAnnotation(PathVariable.class);
        var pathVariableAnnotation = updateAnimal.getParameters()[1].getAnnotation(RequestBody.class);

        assertNotNull(putMapping);
        assertArrayEquals(new String[]{"/{name}"}, putMapping.value());

        assertNotNull(requestBodyAnnotation);
        assertNotNull(pathVariableAnnotation);
    }

    @Test
    void deleteAnimal_shouldBeAnnotated() throws NoSuchMethodException {
        var deleteAnimal =
                AnimalController.class.getDeclaredMethod("deleteAnimal", String.class);
        var deleteMapping = deleteAnimal.getAnnotation(DeleteMapping.class);

        var pathVariableAnnotation = deleteAnimal.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(deleteMapping);
        assertArrayEquals(new String[]{"/{name}"}, deleteMapping.value());

        assertNotNull(pathVariableAnnotation);
    }
}
