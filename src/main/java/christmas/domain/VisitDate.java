package christmas.domain;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public class VisitDate {

    private final LocalDate date;

    public VisitDate(int day) {
        try {
            this.date = LocalDate.of(2023, 12, day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(DomainException.INVALID_DATE.getMessage());
        }
    }

    public boolean isWeekend() {
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }

    public boolean isSpecificBenefitDay() {
        return SpecificBenefitDays.isSpecificBenefitDays(date.getDayOfMonth());
    }

    public int daysLeftUntilChristmas() {
        return Constants.CHRISTMAS_DATE.getValue() - date.getDayOfMonth();
    }

    public int dayOfMonth() {
        return date.getDayOfMonth();
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
