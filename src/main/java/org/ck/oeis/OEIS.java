package org.ck.oeis;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class OEIS {

    private OEIS() {
    }

    public static Series get(String id) {
        final String packageName = id.substring(0, 4).toLowerCase();

        try {
            final Class<?> series = OEIS.class.getClassLoader().loadClass("org.ck.oeis.series." + packageName + "." + id);
            final Constructor<?> declaredConstructor = series.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            return (Series) declaredConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException();
        }
    }
}
