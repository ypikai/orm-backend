/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orm.backend.caches;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 *
 * @author maxime
 */
public class HazelcastCacheManager {
    
    private final static HazelcastCacheManager MANAGER = new HazelcastCacheManager();
    private final static HazelcastInstance HZ_INSTANCE = Hazelcast.newHazelcastInstance(null);
    
    private HazelcastCacheManager() {
    }
    
    public HazelcastCacheManager getManager() {
        return MANAGER;
    }
    
    public void addOrderToCache(String order) {
        HZ_INSTANCE.getMap("orders").put(order, order);
    }
    
}
