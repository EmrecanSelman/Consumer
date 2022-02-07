package com.consumer.Consumer.Util;

import javax.servlet.http.HttpServletRequest;

public class ServiceUtil {
    public static String getParameter(HttpServletRequest req, String objectKey, String def) {
        String parameter = req.getParameter(objectKey);
        return parameter == null || parameter.equals("") ? def : parameter;
    }

    public static int getParameter(HttpServletRequest req, String objectKey, int def) {
        String parameter = req.getParameter(objectKey);
        int toInt;
        try {
            toInt = Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            toInt = def;
        }
        return toInt;
    }

    public static double getParameter(HttpServletRequest req, String objectKey, double def) {
        String parameter = req.getParameter(objectKey);
        double toDouble;
        try {
            toDouble = Double.parseDouble(parameter);
        } catch (NumberFormatException e) {
            toDouble = def;
        }
        return toDouble;
    }

    public static boolean getParameter(HttpServletRequest req, String objectKey, boolean def) {
        String parameter = req.getParameter(objectKey);
        boolean toBoolean;
        try {
            toBoolean = Boolean.parseBoolean(parameter);
        } catch (NumberFormatException e) {
            toBoolean = def;
        }
        return toBoolean;
    }


}

