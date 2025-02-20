package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String EXIT_COMMAND = "q";
    private static final String SEPARATOR = " ";
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public ConsoleHandler() {
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(EXIT_COMMAND)) {
                return;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] betData = command.split(SEPARATOR);
                String userName = betData[0];
                int userAge = Integer.parseInt(betData[1]);
                int value = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                bet = new Bet(value, risk);
                betDao.add(bet);
                user = new User(userName, userAge);
                userDao.save(user);
                System.out.println(user.toString());
                System.out.println(bet.toString());
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please, enter correct data");
            }
        }
    }
}
