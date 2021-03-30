package constants;

import java.io.Serializable;

public enum OrderStatus implements Serializable {
    IN_THE_QUEUE, BEING_PREPARED, READY, DELIVERED
}
