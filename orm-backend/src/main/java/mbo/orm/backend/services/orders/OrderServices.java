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
import java.math.BigDecimal;
import java.math.BigInteger;
import mbo.orm.backend.business.orders.caracteristics.Side;
import mbo.orm.backend.business.orders.caracteristics.TimeInForce;
import mbo.orm.backend.business.orders.containers.IOrderContainer;
import mbo.orm.backend.business.orders.factories.OrderFactory;
import mbo.orm.backend.business.orders.simple.IOrder;
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
    private IOrder order2;
    private IOrder order1;
    private IOrder merged1;
    private IOrder order3;
    private IOrder order4;
    private IOrder merged2;
    private IOrderContainer program;

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
        String JSONString = dataToJson(this.program);
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
    
    public void initFakeData() {
        this.order1 = OrderFactory.buildBasicOrder(BigInteger.ZERO, "ORA FP", BigDecimal.TEN, Side.SELL, TimeInForce.DAY);
        this.order2 = OrderFactory.buildBasicOrder(BigInteger.ONE, "ORA FP", BigDecimal.valueOf(2500l), Side.SELL, TimeInForce.DAY);
        this.merged1 = OrderFactory.mergeOrders(order1, order2);
        this.order3 = OrderFactory.buildBasicOrder(BigInteger.ZERO, "ACA FP", BigDecimal.TEN, Side.BUY, TimeInForce.GTC);
        this.order4 = OrderFactory.buildBasicOrder(BigInteger.ONE, "ACA FP", BigDecimal.valueOf(2500l), Side.BUY, TimeInForce.GTC);
        this.merged2 = OrderFactory.mergeOrders(order3, order4);
        this.program = OrderFactory.programOrders(merged1, merged2);
    }
}
