/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.impl;

import java.util.Collection;
import mbo.orm.backend.business.orders.IOrderContainer;

/**
 *
 * @author maxime
 */
public class GroupOrder implements IOrderContainer {

    @Override
    public boolean hasSubContainer() {
        return Boolean.FALSE;
    }

    @Override
    public Collection<IOrderContainer> getSubContainer() {
        return null;
    }
    
}
