package ch.zli.yumme.models;

import java.util.List;

public class Recipe {
    private String name;
    private String description;
    private int time;
    private int calories;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private String publisher;

    public Recipe() {

    }

    public Recipe(String name, String description, int time, int calories, List<Ingredient> ingredients, List<Step> steps, String publisher) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.calories = calories;
        this.ingredients = ingredients;
        this.steps = steps;
        this.publisher = publisher;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
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
}
