/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.containers.impl;

import java.util.ArrayList;
import java.util.Collection;
import mbo.orm.backend.business.orders.containers.IOrderContainer;
import mbo.orm.backend.business.orders.simple.IOrder;

/**
 *
 * @author maxime
 */
public class ProgramTrade implements IOrderContainer {
    private Collection<IOrder> orders;

    public ProgramTrade() {
        this.orders = new ArrayList<>();
    }

    public ProgramTrade(Collection<IOrder> _orders) {
        this.orders = _orders;
    }
    
    @Override
    public Collection<IOrder> getOrders() {
        return this.orders;
    }
    
    public void addOrder(IOrder _order) {
        this.orders.add(_order);
    }
}
