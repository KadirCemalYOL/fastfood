package com.kcy.cashier.config;

import messageobject.ItemType;
import messageobject.Menu;
import messageobject.MenuItem;
import messageobject.MenuList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MenuConfig {
    @Bean
    MenuItem coke() {
        return new MenuItem(1, "Pepsi", "Cold fizzy drink.", 2.0d, ItemType.DRINK);
    }

    @Bean
    MenuItem iceTea() {
        return new MenuItem(2, "FuseTea", "Cold sweet drink.", 1.5d, ItemType.DRINK);
    }

    @Bean
    MenuItem meatBurger() {
        return new MenuItem(3, "Meat Burger", "A burger made from cattle meat", 5.5d, ItemType.MEAL);
    }

    @Bean
    MenuItem chickenBurger() {
        return new MenuItem(4, "Chicken Burger", "A burger made from chicken meat", 4.5d, ItemType.MEAL);
    }

    @Bean
    MenuItem chips() {
        return new MenuItem(5, "Chips", "Fried potato chips", 2.0d, ItemType.MEAL);
    }

    @Bean
    MenuItem supangle() {
        return new MenuItem(6, "Supangle", "A desert made with milk and cocoa", 3.0d, ItemType.DESERT);
    }

    @Bean
    Menu chickenBurgerMenu() {
        Menu chickenBurgerMenu = new Menu();
        chickenBurgerMenu.setId(100);
        chickenBurgerMenu.setMenuName("Chicken Burger Menu");
        chickenBurgerMenu.addItem(chickenBurger());
        chickenBurgerMenu.addItem(chips());
        chickenBurgerMenu.addItem(coke());

        return chickenBurgerMenu;
    }

    @Bean
    Menu burgerMenu() {
        Menu burgerMenu = new Menu();
        burgerMenu.setId(101);
        burgerMenu.setMenuName("Burger Menu");
        burgerMenu.addItem(meatBurger());
        burgerMenu.addItem(chips());
        burgerMenu.addItem(iceTea());
        burgerMenu.addItem(supangle());

        return burgerMenu;
    }

    @Bean
    MenuList menuList() {
        MenuList menuList = new MenuList();
        menuList.addMenu(chickenBurgerMenu());
        menuList.addMenu(burgerMenu());

        return menuList;
    }
}
