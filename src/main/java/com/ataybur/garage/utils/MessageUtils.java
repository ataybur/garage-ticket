package com.ataybur.garage.utils;

public class MessageUtils {
    public static String allocationMessage(final int vehicleSlot) {
        return  "Allocated " + vehicleSlot + " slot" + (vehicleSlot > 1 ? "s" : "");
    }
}
