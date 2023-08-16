package com.console;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleTransformerTest {

    @Test
    public void testValidation() {
        ConsoleTransformer consoleTransformer = new ConsoleTransformer();
        char[] line = "test string".toCharArray();
        String result = String.valueOf(consoleTransformer.validationAnswerPlayer(line));
        assertEquals("TeSt sTrInG", result);
    }

}
