package com.ataybur.garage.utils;

public class ResponseUtils {
    public static String allocationMessage(final int vehicleSlot) {
        return  "Allocated " + vehicleSlot + " slot" + (vehicleSlot > 1 ? "s" : "");
    }
    public static String garageIsEmpty(){
        return "All slots are available";
    }
}
