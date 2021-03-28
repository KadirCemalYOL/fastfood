package messageobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order implements Serializable {
    private UUID orderId = UUID.randomUUID();
    private List<MenuItem> requestedMenuItems = new ArrayList<>();

    public Order() {
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public List<MenuItem> getRequestedMenuItems() {
        return requestedMenuItems;
    }

    public void setRequestedMenuItems(List<MenuItem> requestedMenuItems) {
        this.requestedMenuItems = requestedMenuItems;
    }

    public void addRequestedMenuItem(MenuItem menuItem) {
        this.requestedMenuItems.add(menuItem);
    }
}
