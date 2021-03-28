package messageobject;

import java.io.Serializable;

public class MenuItem implements Serializable {
    // Price, Name, Description, Id
    private int id;
    private String name;
    private String description;
    private double price;
    private ItemType type;
    long preparationTimeMillis;

    public MenuItem() {
    }

    public MenuItem(int id, String name, String description, double price, ItemType type, long preparationTimeMillis) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.preparationTimeMillis = preparationTimeMillis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public long getPreparationTimeMillis() {
        return preparationTimeMillis;
    }

    public void setPreparationTimeMillis(long preparationTimeMillis) {
        this.preparationTimeMillis = preparationTimeMillis;
    }
}
