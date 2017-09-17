/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.simple.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import mbo.orm.backend.business.orders.caracteristics.Side;
import mbo.orm.backend.business.orders.caracteristics.TimeInForce;

/**
 *
 * @author maxime
 */
public class BasicOrder extends AbstractBasicOrder {
    
    
    public BasicOrder(BigInteger _id, String _ticker, BigDecimal _requestedQuantity, Side _side, TimeInForce _tif) {
        setId(_id);
        setTicker(_ticker);
        setRequestedQuantity(_requestedQuantity);
        setSide(_side);
        setTif(_tif);
    }

    private void setId(BigInteger id) {
        this.id = id;
    }

    private void setTif(TimeInForce tif) {
        this.tif = tif;
    }

    private void setSide(Side side) {
        this.side = side;
    }

    private void setRequestedQuantity(BigDecimal requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    private void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
