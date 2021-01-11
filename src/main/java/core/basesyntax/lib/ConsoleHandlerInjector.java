package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.DaoAnnotationException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.UserDaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ConsoleHandlerInjector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            DaoAnnotationException {
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
        Field[] clazzDeclaredFields = clazz.getDeclaredFields();
        for (Field field : clazzDeclaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    if (isAnnotationDao(BetDaoImpl.class)) {
                        field.set(instance, BetDaoFactory.getBetDao());
                    }
                }
                if (field.getType().equals(UserDao.class)) {
                    if (isAnnotationDao(UserDaoImpl.class)) {
                        field.set(instance, UserDaoFactory.getUserDao());
                    }
                }

            }
        }
        return instance;
    }

    private static boolean isAnnotationDao(Class clazz) throws DaoAnnotationException {
        if (clazz.getAnnotation(Dao.class) != null) {
            return true;
        }
        throw new DaoAnnotationException("Your class doesn't have @Dao annotation");
    }
}
