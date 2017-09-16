/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo.orm.backend.services.orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import mbo.orm.backend.services.common.ORMRoutes;
import java.io.IOException;
import java.io.StringWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.put;

/**
 *
 * @author maxime
 */
public class OrderServices implements ORMRoutes {

    private final static OrderServices INSTANCE = new OrderServices();
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderServices.class);

    private OrderServices() {

    }

    public static OrderServices getInstance() {
        return INSTANCE;
    }

    public void initServices() {
        get(ORDERS, (req, res) -> returnAllOrders(req, res));
        put(ORDERS, (req, res) -> addOrder(req, res));
    }

    public String returnAllOrders(Request request, Response response) {
        long start = System.nanoTime();
        response.status(200);
        response.type("application/json");
        String JSONString = dataToJson("Ratatouille");
        LOGGER.info("Data returned " + (System.nanoTime() - start) / 1000000l + " ms");
        return JSONString;
    }

    private String addOrder(Request req, Response res) {
        return "ok";
    }

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            return sw.toString();
        } catch (IOException e) {
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }
}
