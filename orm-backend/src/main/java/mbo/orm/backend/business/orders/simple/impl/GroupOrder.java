/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.simple.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author maxime
 */
public class GroupOrder extends AbstractBasicOrder {

    public GroupOrder() {
        this.requestedQuantity = BigDecimal.ZERO;
        this.orders = new ArrayList<>();
    }

    public GroupOrder(Collection<BasicOrder> _orders) {
        this.requestedQuantity = BigDecimal.ZERO;
        this.orders = new ArrayList<>();
        _orders.forEach((order) -> {
            addOrder(order);
        });
    }

    private void setOrders(Collection<BasicOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(BasicOrder order) {
        this.side = order.side;
        this.requestedQuantity = this.requestedQuantity.add(order.getRequestedQuantity());
        this.ticker = order.ticker;
        this.tif = order.tif;
        this.orders.add(order);
    }
}
