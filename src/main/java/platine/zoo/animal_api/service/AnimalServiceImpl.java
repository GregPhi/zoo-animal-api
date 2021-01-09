package platine.zoo.animal_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platine.zoo.animal_api.bo.Animal;
import platine.zoo.animal_api.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService{

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Iterable<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findAnimalByName(String name) {
        return animalRepository.findAnimalByName(name);
    }

    @Override
    public Animal findAnimalById(int id) {
        return animalRepository.findAnimalById(id);
    }

    @Override
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void delete(Animal animal) {
        animalRepository.delete(animal);
    }
}
