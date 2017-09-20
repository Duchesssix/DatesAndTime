package com.company;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        LocalDateTime startDate = LocalDateTime.of(2017,1,12, 4,35);  //set date of first full moon
        LocalDateTime today = LocalDateTime.now(); // to get current date / time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //set date format

        //Print today's date to console
        String textToday = today.format(formatter);  //format today's date as a string
        System.out.println("Today's date is " + textToday);  //print today's date to console

        //Calculate date of next full moon
        if (today.compareTo(startDate)>0) {   //if today's date is greater than the date of the first full moon

            // calculate the date of the next full moon
            LocalDateTime fullMoon = startDate.plusMinutes(42524);  //add 29 days 12 hours and 44 min to date of first full moon

            //if today's date is greater than the date of the next full moon then increment to next full moon
            if (today.compareTo(fullMoon)>0) {
                do {
                    fullMoon = fullMoon.plusMinutes(42524);  //add 29 days 12 hours and 44 min to last full moon
                } while (today.compareTo(fullMoon) > 0);  //stop incrementing when fullMoon is greater than today's date

                LocalDateTime lastFullMoon = fullMoon.minusMinutes(42524);  //calculate the previous full moon
                String textLastFullMoon = lastFullMoon.format(formatter);   //format previous full moon as string
                System.out.println("The last full moon was on " + textLastFullMoon);  //print previous full moon to console

                String textFullMoon = fullMoon.format(formatter);   //format next full moon as string
                System.out.println("The next full moon is on " + textFullMoon);   //print next full moon to console
            }
        } else {
            System.out.println("\033[0;31m" +"System date is in the past. Check date and try again.");
        }
    }
}