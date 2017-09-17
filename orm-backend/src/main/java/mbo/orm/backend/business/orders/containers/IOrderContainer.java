/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.containers;

import java.util.Collection;
import mbo.orm.backend.business.orders.simple.IOrder;

/**
 *
 * @author maxime
 */
public interface IOrderContainer {
    public Collection<IOrder> getOrders();
}
