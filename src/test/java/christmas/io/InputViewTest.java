package christmas.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 날짜를_받아온다() {
        InputView inputView = new InputView(() -> "3");
        int date = inputView.readDate();
        assertEquals(3, date);
    }

}