package platine.zoo.animal_api.service;

import platine.zoo.animal_api.bo.Animal;

public interface AnimalService {
    Iterable<Animal> findAll();

    Animal findAnimalByName(String name);
    Animal findAnimalById(int id);

    Animal save(Animal animal);

    Animal updateAnimal(Animal animal);

    void delete(Animal animal);
}
