package com.swastikairhub.SwastiKAirHubBackend.Util;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class DateFormatter {
    public static LocalDate
    getDateFromString(String string,
                      DateTimeFormatter format)
    {

        // Converting the string to date
        // in the specified format
        LocalDate date = LocalDate.parse(string, format);

        // Returning the converted date
        return date;
    }
    public LocalDate formatDate(String date){
        DateTimeFormatter format
                = DateTimeFormatter.ofPattern("d MMMM, yyyy");
        LocalDate formattedDate = null;
        // Try block tp check for exceptions
        try {

            // Getting the Date from String
            formattedDate
                    = getDateFromString(date, format);
        }

        // Block 1
        // Catch block to handle exceptions occuring
        // if the String pattern is invalid
        catch (IllegalArgumentException e) {

            // Display the exception
            System.out.println("Exception: " + e);
        }
        return formattedDate;
    }
}
