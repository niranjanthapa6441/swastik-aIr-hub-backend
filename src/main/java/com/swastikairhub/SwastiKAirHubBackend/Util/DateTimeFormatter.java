package com.swastikairhub.SwastiKAirHubBackend.Util;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DateTimeFormatter {
    public static LocalDate
    getDateFromString(String string,
                      java.time.format.DateTimeFormatter format)
    {

        // Converting the string to date
        // in the specified format
        LocalDate date = LocalDate.parse(string, format);// Returning the converted date
        return date;
    }
    public LocalDate formatDate(String date){
        java.time.format.DateTimeFormatter format
                = java.time.format.DateTimeFormatter.ofPattern("d MMMM, yyyy");
        // Try block tp check for exceptions
        try {

            // Getting the Date from String
            LocalDate formattedDate = getDateFromString(date, format);
            return formattedDate;
        }

        // Block 1
        // Catch block to handle exceptions occuring
        // if the String pattern is invalid
        catch (IllegalArgumentException e) {
            throw new CustomException(CustomException.Type.DATE_INVALID);
        }
    }
    public LocalTime formatTime(String time){
        java.time.format.DateTimeFormatter format
                = java.time.format.DateTimeFormatter.ofPattern("HH:mm");
        try{
         LocalTime formattedTime=getTimeFromString(time,format);
         return formattedTime;
        }
        catch (IllegalArgumentException e){
            throw new
                    CustomException(CustomException.Type.TIME_INVALID);
        }
    }

    private LocalTime getTimeFromString(String time, java.time.format.DateTimeFormatter format) {
        LocalTime localTime=LocalTime.parse(time,format);
        return localTime;
    }
}
