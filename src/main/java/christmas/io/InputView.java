package christmas.io;

import java.util.List;

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

    @Override
    public List<String> readMenus() {
        String input = inputReader.readLine();
        return List.of(input.split(","));
    }
}
