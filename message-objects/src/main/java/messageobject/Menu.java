package messageobject;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, MenuItem> menu = new HashMap<>();

    public Menu() {
    }

    public void addItem(MenuItem item) {
        this.menu.put(item.getId(), item);
    }

    public Map<Integer, MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(Map<Integer, MenuItem> menu) {
        this.menu = menu;
    }

    public MenuItem getItem(Integer itemId) {
        return this.menu.get(itemId);
    }
}
