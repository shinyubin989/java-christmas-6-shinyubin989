package christmas.io;

import java.util.List;

public interface InputPort {
    int readDate();

    List<String> readMenus();
}
