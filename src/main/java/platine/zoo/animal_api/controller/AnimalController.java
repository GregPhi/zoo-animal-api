package platine.zoo.animal_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platine.zoo.animal_api.bo.Animal;
import platine.zoo.animal_api.exception.AnimalNotFoundException;
import platine.zoo.animal_api.service.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/")
    Iterable<Animal> getAllAnimals(){
        return this.animalService.findAll();
    }

    @GetMapping("/{name}")
    Animal getAnimalByName(@PathVariable String name){
        return this.animalService.findAnimalByName(name);
    }

    @GetMapping("/{id}")
    Animal getAnimalById(@PathVariable int id){
        return this.animalService.findAnimalById(id);
    }

    @PostMapping("/")
    Animal newAnimal(@RequestBody Animal animal){
        return this.animalService.save(animal);
    }

    @PutMapping("/{name}")
    Animal updateAnimal(@PathVariable String name, @RequestBody Animal newAnimal) throws AnimalNotFoundException {
        Animal oldAnimal = this.animalService.findAnimalByName(name);
        if(oldAnimal == null){
            throw new AnimalNotFoundException(name);
        }
        this.animalService.delete(oldAnimal);
        return this.animalService.save(newAnimal);
    }

    @DeleteMapping("/{name}")
    void deleteAnimal(@PathVariable String name){
        Animal animal = this.animalService.findAnimalByName(name);
        if(animal != null){
            this.animalService.delete(animal);
        }
    }
}
