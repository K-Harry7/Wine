package wineproject;

public class Wine {
    private String name;
    private String flavorProfile;
    private int rating;
    private String type; // "Red" or "White"

    public Wine(String name, String flavorProfile, int rating, String type) {
        this.name = name;
        this.flavorProfile = flavorProfile;
        this.rating = rating;
        this.type = type;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFlavorProfile() { return flavorProfile; }
    public void setFlavorProfile(String flavorProfile) { this.flavorProfile = flavorProfile; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return name + "," + flavorProfile + "," + rating + "," + type;
    }
}
