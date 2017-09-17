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
public enum TimeInForce {
    DAY(0), GTD(1), GTC(2);
    private Integer id;
    
    private TimeInForce(Integer _id) {
        this.id = _id;
    }

    public Integer getId() {
        return id;
    }
}
