/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.services.securities;

import mbo.orm.backend.services.common.ORMRoutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static spark.Spark.get;

/**
 *
 * @author maxime
 */
public class SecurityServices implements ORMRoutes {
    private final static SecurityServices INSTANCE = new SecurityServices();
    private final static Logger LOGGER = LoggerFactory.getLogger(SecurityServices.class);
    
    private SecurityServices () {
        
    }
    
    public static SecurityServices getInstance() {
        return INSTANCE;
    }
    
    public void initServices() {
        get(SECURITIES, (req, res) -> {
            LOGGER.info("Received request for " + req.requestMethod() + " on route " + SECURITIES);
            return "securities";
        });
    }
    
}
