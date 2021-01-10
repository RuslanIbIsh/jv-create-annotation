package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler(new BetDaoImpl(), new UserDaoImpl());
        System.out.println("Please, enter Name, age, value and risk for your bet!");
        handler.handle();
    }
}
