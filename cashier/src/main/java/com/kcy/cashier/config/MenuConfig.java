package com.kcy.cashier.config;

import messageobject.ItemType;
import messageobject.Menu;
import messageobject.MenuItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MenuConfig {
    @Bean
    MenuItem coke() {
        return new MenuItem(1, "Pepsi", "Cold fizzy drink.", 2.0d, ItemType.DRINK, 1000L);
    }

    @Bean
    MenuItem iceTea() {
        return new MenuItem(2, "FuseTea", "Cold sweet drink.", 1.5d, ItemType.DRINK, 1000L);
    }

    @Bean
    MenuItem meatBurger() {
        return new MenuItem(3, "Meat Burger", "A burger made from cattle meat", 5.5d, ItemType.MEAL, 5000L);
    }

    @Bean
    MenuItem chickenBurger() {
        return new MenuItem(4, "Chicken Burger", "A burger made from chicken meat", 4.5d, ItemType.MEAL, 5500L);
    }

    @Bean
    MenuItem chips() {
        return new MenuItem(5, "Chips", "Fried potato chips", 2.0d, ItemType.MEAL, 4000L);
    }

    @Bean
    MenuItem supangle() {
        return new MenuItem(6, "Supangle", "A desert made with milk and cocoa", 3.0d, ItemType.DESERT, 500L);
    }

    @Bean
    Menu menu() {
        Menu menu = new Menu();
        menu.addItem(coke());
        menu.addItem(iceTea());
        menu.addItem(meatBurger());
        menu.addItem(chickenBurger());
        menu.addItem(chips());
        menu.addItem(supangle());

        return menu;
    }
}
