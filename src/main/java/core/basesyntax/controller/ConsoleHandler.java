package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String EXIT_COMMAND = "q";
    private BetDao betDao;

    public ConsoleHandler(BetDao betDao) {
        this.betDao = betDao;
    }

    public void handler() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(EXIT_COMMAND)) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                betDao.add(bet);
                System.out.println(bet.toString());
            } catch (NumberFormatException e) {
                System.out.println("Please, enter correct data");
            } catch (NullPointerException e) {
                throw new NullPointerException("Please initialise class BetDaoImpl");
            }
        }
    }
}
