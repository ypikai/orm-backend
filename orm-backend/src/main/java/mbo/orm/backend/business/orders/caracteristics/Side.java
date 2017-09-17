/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.business.orders.caracteristics;

/**
 *
 * @author maxime
 */
public enum Side {
    BUY (0), SELL(1);
    
    private final Integer id;
    
    private Side(Integer _id) {
        this.id = _id;
    }
    
    public final Integer getId() {
        return this.id;
    }
}
