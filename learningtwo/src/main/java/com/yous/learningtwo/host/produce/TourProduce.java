package com.yous.learningtwo.host.produce;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author syou
 * @date 2018/12/13.
 */
public class TourProduce {

    public static void main(String[] args) {

        System.out.println(LocalDate.now());

    }


    private static LocalDate timeStamp2LocalDate(Timestamp timestamp) {
        return Optional.ofNullable(timestamp)
                .map(Timestamp::toLocalDateTime)
                .map(LocalDateTime::toLocalDate)
                .orElse(LocalDate.MIN);
    }

    private static Timestamp localDate2TimeStamp(LocalDate localDate) {
        return Optional.ofNullable(localDate)
                .map(LocalDate::atStartOfDay)
                .map(Timestamp::valueOf)
                .orElse(null);
    }
}
