package messageobject;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
    private List<Menu> menus = new ArrayList<>();

    public MenuList() {
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }
}
