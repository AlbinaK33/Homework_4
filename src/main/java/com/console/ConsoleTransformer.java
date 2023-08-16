package com.console;

import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleTransformer {

    static final Scanner scan = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(ConsoleTransformer.class.getName());

    public void getConvertString() {
        logger.info("Please enter any string.");
        char[] line = scan.nextLine().toCharArray();
        if (line.length == 0) {
            getConvertString();
        } else {
            validationAnswerPlayer(line);
        }
    }

    public Object validationAnswerPlayer(char[] line) {
        StringBuilder stringPlayer = new StringBuilder();
        for (int i = 0; i < line.length; i++) {
            if ((i % 2) == 0) {
                stringPlayer.append(Character.toUpperCase(line[i]));
            } else {
                stringPlayer.append(Character.toLowerCase(line[i]));
            }
        }
        logger.info(String.valueOf(stringPlayer));
        return stringPlayer;
    }
}
