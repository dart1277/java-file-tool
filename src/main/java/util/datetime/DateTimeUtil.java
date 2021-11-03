package util.datetime;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateTimeUtil {
    public static LocalDateTime millisToLocalDateTime(long millis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }

    public static LocalDateTime shortDateStringLocalDateTime(String shortDate) {
        if (StringUtils.isBlank(shortDate)) {
            return null;
        }
        return LocalDate.parse(shortDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
    }
}
