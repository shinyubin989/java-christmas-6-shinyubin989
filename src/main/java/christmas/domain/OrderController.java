package christmas.domain;

import christmas.dto.OrderDto;
import christmas.io.InputPort;
import christmas.io.OutputPort;

import java.time.DateTimeException;
import java.util.List;

public final class OrderController {

    private final InputPort inputPort;
    private final OutputPort outputPort;

    OrderController(InputPort inputPort, OutputPort outputPort) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
    }

    VisitDate receiveDate() {
        while (true) {
            try {
                return new VisitDate(inputPort.readDate());
            } catch (IllegalArgumentException e) {
                outputPort.printException(e.getMessage());
            } catch (DateTimeException e) {
                outputPort.printException(DomainException.INVALID_DATE.getMessage());
            }
        }
    }

    Order receiveOrder() {
        while (true) {
            try {
                List<OrderDto> orders = inputPort.readMenus();
                return new Order(orders);
            } catch (IllegalArgumentException e) {
                outputPort.printException(e.getMessage());
            }
        }
    }

}
