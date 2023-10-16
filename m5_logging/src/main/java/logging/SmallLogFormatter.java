package logging;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Vincent Verboven
 * 16/10/2023
 */
public class SmallLogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return String.format("%s Level: %s melding: \"%s\"\n", LocalDateTime.ofInstant(record.getInstant(), ZoneId.systemDefault()), record.getLevel().toString().toUpperCase(), MessageFormat.format(record.getMessage(), record.getParameters()));
    }
}
