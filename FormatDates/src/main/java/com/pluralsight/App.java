package com.pluralsight;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Call different formatting methods
        displayMonthDayYearFormat(currentDateTime);
        displayYearMonthDayFormat(currentDateTime);
        System.out.println(getFullMonthDayYearFormat(currentDateTime));
        displayFullWeekdayMonthDayYearFormat(currentDateTime);
        displayTimeInGMTLabel(currentDateTime);
        displayTimeWithDateLocalLabel(currentDateTime);
    }

    // Format: MM-dd-yyyy
    static void displayMonthDayYearFormat(LocalDateTime dateTime) {
        DateTimeFormatter monthDayYearFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(dateTime.format(monthDayYearFormatter));
    }

    // Format: yyyy/MM/dd
    static void displayYearMonthDayFormat(LocalDateTime dateTime) {
        DateTimeFormatter yearMonthDayFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(dateTime.format(yearMonthDayFormatter));
    }

    // Format: Full month name dd, yyyy
    static String getFullMonthDayYearFormat(LocalDateTime dateTime) {
        DateTimeFormatter fullMonthDayYearFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return fullMonthDayYearFormatter.format(dateTime);
    }

    // Format: Day name, short month, day, year
    static void displayFullWeekdayMonthDayYearFormat(LocalDateTime dateTime) {
        DateTimeFormatter weekdayMonthDayFormatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");
        System.out.println(dateTime.format(weekdayMonthDayFormatter));
    }

    // Format: hour:minute with GMT display label
    static void displayTimeInGMTLabel(LocalDateTime dateTime) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(dateTime.format(timeFormatter) + " ß display in GMT time");
    }

    // Format: hour:minute on dd MMM yyyy with local time zone display label
    static void displayTimeWithDateLocalLabel(LocalDateTime dateTime) {
        DateTimeFormatter fullTimeDateFormatter = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(dateTime.format(fullTimeDateFormatter) + " ß display in your local time zone");
    }
}
