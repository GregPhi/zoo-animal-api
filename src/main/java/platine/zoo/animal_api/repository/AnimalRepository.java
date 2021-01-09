package platine.zoo.animal_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platine.zoo.animal_api.bo.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal,String> {
    List<Animal> findAll();

    Animal findAnimalByName(String name);
    Animal findAnimalById(int id);

    Animal save(Animal animal);

    void delete(Animal animal);
}
