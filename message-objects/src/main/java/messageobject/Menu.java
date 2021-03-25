package messageobject;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int id;
    private String menuName;
    private List<MenuItem> items = new ArrayList<>();

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void addItem(MenuItem item){
        this.items.add(item);
    }
}
