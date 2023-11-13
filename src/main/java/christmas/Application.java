package christmas;

import christmas.domain.*;
import christmas.io.ConsoleInputReader;
import christmas.io.InputView;
import christmas.io.OutputView;

public class Application {
    public static void main(String[] args) {
        OrderController controller = new OrderController(new InputView(new ConsoleInputReader()), new OutputView());
        PosMachine posMachine = new PosMachine();

        VisitDate date = controller.receiveDate();
        Order order = controller.receiveOrder();
        Receipt receipt = posMachine.printReceipt(date, order);

        controller.showReceipt(date, receipt);
    }
}
