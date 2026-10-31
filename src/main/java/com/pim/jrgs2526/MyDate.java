package com.pim.jrgs2526;

public class MyDate {

    public static final String ERR_INVALID_YEAR = "Year value not valid";
    public static final String ERR_INVALID_MONTH = "Month value not valid";
    public static final String ERR_INVALID_DAY = "Day value not valid";
    public static final String ERR_INVALID_DATE = "Invalid date";

    // Añadimos las variables necesarias
    private int day;
    private Months month;
    private int year;

    // Constructor vacio necesario para los test que utilizan new MyDate();
    public MyDate(){
    }

    // Constructor con parámetros para los test que utilizan new MyDate(day, month, year);
    public MyDate(int day, Months month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // GETTERS
    public int getDay() {
        return day;
    }
    public Months getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    // SETTERS
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(Months month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public enum Months {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        public final int monthNumber;

        private Months(int monthNumber) {
            this.monthNumber = monthNumber;
        }

        public static Months toMonth( int monthNumber ) {
            for (Months m : values())
                if (m.monthNumber == monthNumber)
                    return m;
            return null;
        }
    }
}
