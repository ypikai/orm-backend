/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orm.backend.services;

import com.orm.backend.services.orders.OrderServices;
import com.orm.backend.services.securities.SecurityServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static spark.Spark.port;

/**
 *
 * @author maxime
 */
public class ORMServices {

    public static void main(String[] args) {
        port(8080);
        Logger logger = LoggerFactory.getLogger(ORMServices.class);
        logger.info("Initialize order services");
        OrderServices.getInstance().initServices();
        logger.info("Initialize securities services");
        SecurityServices.getInstance().initServices();
    }
}
