package christmas.domain;

import java.time.LocalDate;
import java.util.Objects;

class VisitDate {

    private final LocalDate date;

    VisitDate(int day) {
        this.date = LocalDate.of(2023, 12, day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitDate visitDate = (VisitDate) o;
        return Objects.equals(date, visitDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
