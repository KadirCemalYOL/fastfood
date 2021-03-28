package com.kcy.cashier.dto;

import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {
    private List<Integer> itemIdList;

    public List<Integer> getItemIdList() {
        return itemIdList;
    }

    public void setItemIdList(List<Integer> itemIdList) {
        this.itemIdList = itemIdList;
    }
}
