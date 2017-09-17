/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.factories;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import mbo.orm.backend.business.orders.caracteristics.Side;
import mbo.orm.backend.business.orders.caracteristics.TimeInForce;
import mbo.orm.backend.business.orders.containers.IOrderContainer;
import mbo.orm.backend.business.orders.containers.impl.MultilegOrder;
import mbo.orm.backend.business.orders.containers.impl.ProgramTrade;
import mbo.orm.backend.business.orders.simple.IOrder;
import mbo.orm.backend.business.orders.simple.impl.BasicOrder;
import mbo.orm.backend.business.orders.simple.impl.GroupOrder;
import mbo.orm.backend.business.orders.utils.MergingResult;
import mbo.orm.backend.business.orders.utils.OrderUtils;

/**
 *
 * @author maxime
 */
public class OrderFactory {

    public static final IOrder buildBasicOrder(BigInteger _id, String _ticker, BigDecimal _requestedQuantity, Side _side, TimeInForce _tif) {
        Collection<BasicOrder> orders = new ArrayList<>();
        orders.add(new BasicOrder(_id, _ticker, _requestedQuantity, _side, _tif));
        IOrder groupOrder = new GroupOrder(orders);
        return groupOrder;
    }

    public static final MergingResult mergeOrders(Collection<IOrder> _orders) {
        GroupOrder merged = new GroupOrder();
        IOrder previousOrder = null;
        for (IOrder order : _orders) {
            if (previousOrder == null) {
                previousOrder = order;
            }
            if (OrderUtils.areOkForMerge(previousOrder, order)) {
                for (BasicOrder basicOrder : order.getOrders()) {
                    merged.addOrder(basicOrder);
                };
            } else {
                return new MergingResult(null, Boolean.FALSE, "One caracteristic or more is inconsistant");
            }
            previousOrder = order;
        }
        return new MergingResult(merged, Boolean.TRUE, null);
    }

    public static final IOrderContainer programOrders(IOrder ... _orders) {
        ProgramTrade program = new ProgramTrade();
        for (IOrder order : _orders) {
            program.addOrder(order);
        }
        return program;
    }

    public static final IOrderContainer linkOrders(Collection<IOrder> _orders) {
        MultilegOrder multileg = new MultilegOrder();
        for (IOrder order : _orders) {
            multileg.addOrder(order);
        }
        return multileg;
    }
}
