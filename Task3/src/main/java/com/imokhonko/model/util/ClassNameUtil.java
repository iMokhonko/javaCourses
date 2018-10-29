package com.imokhonko.model.util;

/**
 * This utility class is used for getting class name from static context,
 * where it was invoked.
 */
public class ClassNameUtil {
    private ClassNameUtil() {}

    public static String getCurrentClassName() {
        try {
            throw new RuntimeException();
        } catch(RuntimeException e) {
            return e.getStackTrace()[1].getClassName();
        }
    }

}
