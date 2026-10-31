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
    // Creamos una fecha valida para poder pasar el segundo test
    public MyDate(){
        this.day = 16;
        this.month = Months.MARCH;
        this.year = 1987;
    }

    // Constructor con parámetros para los test que utilizan new MyDate(day, month, year);
    public MyDate(int day, Months month, int year){

        // Comprobamos la validación de la fecha introducida
        validateDate(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Método auxiliar para obtener el número total de días de un mes y un año determinados
    public static int getDaysInMonth(Months month, int year) {
        if (month == null) {
            return 0;
        }
        switch (month) {
            case FEBRUARY:
                return isLeapYear(year) ? 29 : 28;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return 30;
            default:
                return 31;
        }
    }

    // Lógica de validación
    private void validateDate(int day, Months month, int year) {

        if (month == null) {
            throw new IllegalArgumentException(ERR_INVALID_MONTH);
        }
        int maxDays = getDaysInMonth(month, year);
        if (day < 1 || day > maxDays) {
            throw new IllegalArgumentException(ERR_INVALID_DAY);
        }
    }

    // Método auxiliar para comprobar años bisiestos (aceptamos años negativos según lógica de los test)
    public static boolean isLeapYear(int year) {
        /*if (year == 0) {
            return false;
        }

         */

        int absYear = Math.abs(year);
        return (absYear % 4 == 0 && absYear % 100 != 0) || (absYear % 400 == 0);
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
