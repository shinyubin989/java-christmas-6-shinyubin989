package christmas.io;

import java.text.DecimalFormat;
import java.util.Map;

final class OutputView implements OutputPort{
    @Override
    public void printException(String message) {
        System.out.println(message);
    }
}
