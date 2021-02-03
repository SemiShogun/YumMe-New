package ch.zli.yumme.models;

public class User {
    private String username;
    private String image;
    private int followers;
    private int following;
    private int recipes;

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getRecipes() {
        return recipes;
    }

    public void setRecipes(int recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", image='" + image + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", recipes=" + recipes +
                '}';
    }
}
