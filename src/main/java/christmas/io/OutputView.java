package christmas.io;

import java.text.DecimalFormat;
import java.util.Map;

final class OutputView implements OutputPort{
    @Override
    public void printException(String message) {
        System.out.println(message);
    }

    @Override
    public void printIntroduction() {
        System.out.println(OutputMessage.INTRODUCTION.getMessage());
    }

    @Override
    public void printInputDate() {
        System.out.println(OutputMessage.INPUT_DATE.getMessage());
    }

    @Override
    public void printInputMenu() {
        System.out.println(OutputMessage.INPUT_MENU.getMessage());
    }

    @Override
    public void printBenefitPreview() {
        System.out.println(OutputMessage.PREVIEW_BENEFIT.getMessage());
        System.out.println();
    }

}
