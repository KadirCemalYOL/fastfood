package commonobject;

import messageobject.MenuItem;
import messageobject.Order;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Product implements Serializable {
    Order order;

    public Product(Order order) {
        this.order = order;
    }

    public void prepare() {
        // Wait as much as preparation time.

        long totalTimeToPrepare = order.getRequestedMenuItems()
                .stream()
                .collect(
                        Collectors.summingLong(
                                MenuItem::getPreparationTimeMillis
                        )
                );

        System.out.println(LocalDateTime.now().toString() + ": Preparation started (required min. time: " + totalTimeToPrepare + " ), order id: " + order.getOrderId().toString());

        try {
            Thread.sleep(totalTimeToPrepare);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalDateTime.now().toString() + ": Order ready, order id: " + order.getOrderId().toString());
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
