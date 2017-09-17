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
public class MergingResult {
    private final IOrder merged;
    private final Boolean wasMerged;
    private final String mergeError;

    public MergingResult(IOrder _merged, Boolean _wasMerged, String _mergeError) {
        this.merged = _merged;
        this.wasMerged = _wasMerged;
        this.mergeError = _mergeError;
    }

    public IOrder getMerged() {
        return merged;
    }

    public Boolean getWasMerged() {
        return wasMerged;
    }
    
    public String getMergeError() {
        return this.mergeError;
    }
}
