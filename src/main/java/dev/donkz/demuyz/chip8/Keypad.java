package main.java.dev.donkz.demuyz.chip8;

import main.java.dev.donkz.demuyz.core.driver.EventDriver;
import main.java.dev.donkz.demuyz.core.driver.InputDriver;

public class Keypad {
    public enum Key {
        ONE('1'), TWO('2'), THREE('3'), C('4'),
        FOUR('Q'), FIVE('W'), SIX('E'), D('R'),
        SEVEN('A'), EIGHT('S'), NINE('D'), E('F'),
        A('Z'), ZERO('X'), B('C'), F('V');

        public final char key;
        Key(char key) {
            this.key = key;
        }
    }

    private final InputDriver driver;

    public Keypad(InputDriver driver) {
        this.driver = driver;
    }

    public void connect(EventDriver eventDriver) {
        eventDriver.registerInput(driver);
    }

    public InputDriver getDriver() {
        return driver;
    }
}
