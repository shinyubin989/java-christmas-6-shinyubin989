package christmas.io;

public enum IoException {
    ERROR("[ERROR] "),
    DATE_IS_NOT_NUMBER(ERROR.message + "날짜 입력값이 숫자가 아닙니다. 다시 입력해 주세요."),
    INVALID_ORDER(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NUM_OF_ORDER_IS_NOT_NUMBER(ERROR.message + "주문하신 갯수는 숫자가 아닙니다. 다시 입력해 주세요."),
    ;

    private final String message;

    IoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
