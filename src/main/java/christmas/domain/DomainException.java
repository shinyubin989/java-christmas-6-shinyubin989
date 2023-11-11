package christmas.domain;

enum DomainException {
    ERROR("[ERROR] "),
    MENU_DOES_NOT_EXIST(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_NUM_MUST_BE_AT_LEAST_ONE(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_FORMAT_IS_NOT_VALID(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_IS_DUPLICATED(ERROR.message + "유효하지 않은 주문입니다. 다시 입력해 주세요."),

    ;
    private final String message;

    DomainException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
