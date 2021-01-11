package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exception.DaoAnnotationException;
import core.basesyntax.lib.ConsoleHandlerInjector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = null;
        try {
            handler = (ConsoleHandler) ConsoleHandlerInjector.getInstance(ConsoleHandler.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("ConsoleHandler doesn't have empty constructor", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("ConsoleHandler doesn't have public constructor", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Doesn't exist ConsoleHandler class", e);
        } catch (InstantiationException e) {
            throw new RuntimeException("Can't create instance of ConsoleHandler", e);
        } catch (DaoAnnotationException e) {
            throw new RuntimeException("Daoimpl class not exists", e);
        }
        System.out.println("Please, enter Name, age, value and risk for your bet!");
        handler.handle();
    }
}
