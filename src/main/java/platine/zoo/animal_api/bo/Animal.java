package platine.zoo.animal_api.bo;

import javax.persistence.Entity;

@Entity
public class Animal extends Visible{
    private Description description;
    private boolean favorite;
    private int quizId;
    private String picture;

    public Animal() {
        super();
        this.favorite = false;
    }

    public Animal(int id, String name, Description description, ZooPosition zooPosition, boolean favorite, int quizId, String picture) {
        super(id,name,zooPosition);
        this.description = description;
        this.favorite = favorite;
        this.quizId = quizId;
        this.picture = picture;
    }

    public Animal(String name) {
        super(name);
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
