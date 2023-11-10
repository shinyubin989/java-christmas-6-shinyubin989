package christmas.io;

final class InputView implements InputPort {

    private final InputReader inputReader;

    public InputView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public int readDate() {
        try {
            return Integer.parseInt(inputReader.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IoException.DATE_IS_NOT_NUMBER.getMessage());
        }
    }
}
