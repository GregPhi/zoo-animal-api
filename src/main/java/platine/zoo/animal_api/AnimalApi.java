package platine.zoo.animal_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import platine.zoo.animal_api.bo.Animal;
import platine.zoo.animal_api.bo.Description;
import platine.zoo.animal_api.bo.ZooPosition;
import platine.zoo.animal_api.repository.AnimalRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AnimalApi {

    public static void main(String... args){
        SpringApplication.run(AnimalApi.class,args);
        System.out.println("=================================================");
        System.out.println("        -> http://localhost:8081/animals/");
        System.out.println("=================================================");
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(AnimalRepository repository) {
        return (args) -> {
            var tiger = new Animal("Tiger");
            var description_tiger = new Description();
            var zooPosition_tiger = new ZooPosition();
            tiger.setDescription(description_tiger);
            tiger.setZooPosition(zooPosition_tiger);

            // save a couple of trainers
            repository.save(tiger);
        };
    }
}
