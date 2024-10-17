package lk.ijse.gdse67.evosellspringbackend.util;

import java.util.UUID;

public class AppUtil {
    public static String generateUserid() {
        return "USER-"+UUID.randomUUID();
    }
    public static String generateCustomerId() { return "CUSTOMER-"+UUID.randomUUID();}
    public static String generateOrderDetailId(){
        return "ORDER_DETAIL-" + UUID.randomUUID();
    }
}
