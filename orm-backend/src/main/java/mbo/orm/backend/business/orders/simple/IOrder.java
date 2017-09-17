/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.simple;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import mbo.orm.backend.business.orders.caracteristics.Side;
import mbo.orm.backend.business.orders.caracteristics.TimeInForce;
import mbo.orm.backend.business.orders.simple.impl.BasicOrder;

/**
 *
 * @author maxime
 */
public interface IOrder {
    public Collection<BasicOrder> getOrders();
    public String getTicker();
    public BigDecimal getRequestedQuantity();
    public Side getSide();
    public TimeInForce getTif();
    public BigInteger getId();
}
