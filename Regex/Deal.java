package Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;

public class Deal {
    private String code;
    private int discountPercent;
    private LocalDate expiryDate;

    public Deal(String code, String description) {
        this.code = code;
        this.discountPercent = extractDiscount(description);
        this.expiryDate = extractExpiryDate(description);
    }

    // Extract percentage using regexcd ..
    
    private int extractDiscount(String text) {
        Pattern pattern = Pattern.compile("(\\d{1,2})%");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    // Extract date using regex
    private LocalDate extractExpiryDate(String text) {
        Pattern pattern = Pattern.compile("(\\d{2}-\\d{2}-\\d{4})");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(matcher.group(1), formatter);
        }
        return null;
    }

    public boolean isExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Deal{" + code + ", " + discountPercent + "%, expires on " + expiryDate + '}';
    }
}

