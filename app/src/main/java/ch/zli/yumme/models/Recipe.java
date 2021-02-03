package ch.zli.yumme.models;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
    private String id;
    private String name;
    private String description;
    private String image;
    private Integer time;
    private Integer calories;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private String publisher;

    public Recipe() {

    }

    public Recipe(String id, String name, String description, String image, Integer time, Integer calories, List<Ingredient> ingredients, List<Step> steps, String publisher) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.time = time;
        this.calories = calories;
        this.ingredients = ingredients;
        this.steps = steps;
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return name + "\n" + description;
    }
}
