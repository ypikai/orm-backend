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
public class ProgramTrade implements IOrderContainer {
    private Collection<IOrderContainer> containers;
    
    @Override
    public boolean hasSubContainer() {
        return Boolean.TRUE;
    }

    @Override
    public Collection<IOrderContainer> getSubContainer() {
        return this.containers;
    }
}
