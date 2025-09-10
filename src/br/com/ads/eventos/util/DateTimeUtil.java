package br.com.ads.eventos.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public static LocalDateTime parse(String s) { return LocalDateTime.parse(s, FMT); }
    public static String format(LocalDateTime dt) { return dt.format(FMT); }
}
