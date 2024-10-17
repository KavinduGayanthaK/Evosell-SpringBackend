package lk.ijse.gdse67.evosellspringbackend.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatterns {
    public static Matcher customerIdValidate(String customerId){
        return Pattern.compile("^C\\d{2}-\\d{3,}$").matcher(customerId);
    }

    public static Matcher itemCodeValidate(String itemCode){
        return Pattern.compile("^I\\d{2}-\\d{3,}$").matcher(itemCode);
    }

    public static Matcher orderIdValidate(String orderId) {
        return Pattern.compile("/^\\d+$/").matcher(orderId);
    }

}
