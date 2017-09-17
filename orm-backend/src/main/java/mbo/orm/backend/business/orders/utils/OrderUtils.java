/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.utils;

import mbo.orm.backend.business.orders.simple.IOrder;

/**
 *
 * @author maxime
 */
public class OrderUtils {

    public static boolean areOkForMerge(IOrder previousOrder, IOrder basicOrder) {
        return previousOrder.getSide().equals(basicOrder.getSide()) && previousOrder.getTicker().equals(basicOrder.getTicker()) && previousOrder.getTif().equals(basicOrder.getTif());
    }
    public boolean canMergeOrders() {
        return Boolean.FALSE;
    }
}
