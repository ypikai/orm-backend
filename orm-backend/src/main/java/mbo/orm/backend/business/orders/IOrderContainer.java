/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders;

import java.util.Collection;

/**
 *
 * @author maxime
 */
public interface IOrderContainer {
    public boolean hasSubContainer();
    public Collection<IOrderContainer> getSubContainer();
}
