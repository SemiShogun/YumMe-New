package ch.zli.yumme.models;

public class Ingredient {

    private String amount;
    private String ingredient;

    public Ingredient(String amount, String ingredient) {
        this.amount = amount;
        this.ingredient = ingredient;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
