/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.simple.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import mbo.orm.backend.business.orders.caracteristics.Side;
import mbo.orm.backend.business.orders.caracteristics.TimeInForce;
import mbo.orm.backend.business.orders.simple.IOrder;

/**
 *
 * @author maxime
 */
public class AbstractBasicOrder implements IOrder {
    protected Collection<BasicOrder> orders = null;

    protected BigInteger id;
    protected String ticker;
    protected BigDecimal requestedQuantity;
    protected Side side;
    protected TimeInForce tif;

    @Override
    public Collection<BasicOrder> getOrders() {
        return this.orders;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public BigDecimal getRequestedQuantity() {
        return requestedQuantity;
    }

    @Override
    public Side getSide() {
        return side;
    }

    @Override
    public TimeInForce getTif() {
        return tif;
    }

    @Override
    public BigInteger getId() {
        return id;
    }    
}
