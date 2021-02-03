package ch.zli.yumme.models;

import java.io.Serializable;

public class Ingredient implements Serializable {

    private String ingredient;

    public Ingredient() {

    }

    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient='" + ingredient + '\'' +
                '}';
    }
}
