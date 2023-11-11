package christmas.domain;

import java.util.Arrays;

enum SpecificBenefitDays {
    DAY_3(3),
    DAY_10(10),
    DAY_17(17),
    DAY_24(24),
    DAY_25(25),
    DAY_31(31),
    ;

    private final int day;

    SpecificBenefitDays(int day) {
        this.day = day;
    }

    static boolean isSpecificBenefitDays(int day) {
        return Arrays.stream(values()).anyMatch(it -> it.day == day);
    }
}
