package platine.zoo.animal_api.exception;

public class AnimalNotFoundException extends Exception{
    public AnimalNotFoundException(){
        super("The animal is not found !");
    }

    public AnimalNotFoundException(String name){
        super("The animal : "+name+" is not found !");
    }
}
