package christmas.io;

public enum IoException {
    ERROR("[ERROR] "),
    DATE_IS_NOT_NUMBER(ERROR.message + "유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NUM_OF_ORDER_IS_NOT_NUMBER(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_FORMAT_IS_INVALID(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ;

    private final String message;

    IoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
