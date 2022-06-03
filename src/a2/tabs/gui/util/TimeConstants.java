package a2.tabs.gui.util;

import java.util.Calendar;

public enum TimeConstants {

    // this class is because im very lazy and dont wanna have to keep converting time and stuff
    SECOND("second", 1000L),
    MINUTE("minute", 60000L),
    HOUR("hour", 3600000L),
    DAY("day", 86400000L),
    WEEK("week", 604800000L),
    MONTH("month", 2592000000L),
    YEAR("year", 31536000000L);

    private final String name;
    private final long millis;

    TimeConstants(String name, long millis) {
        this.name = name;
        this.millis = millis;
    }

    public String getName() {
        return name;
    }

    public long getMillis() {
        return millis;
    }

    public static String parseTime(String s) {
        try {
            String[] part = s.split("(?<=\\d)(?=\\D)");
            int timeLength = Integer.parseInt(part[0]);
            long multiplier;
            String letter = part[1];
            if (letter.length() == 1) {
                switch (letter) {
                    case "s":
                        multiplier = SECOND.millis;
                        break;
                    case "m":
                        multiplier = MINUTE.millis;
                        break;
                    case "h":
                        multiplier = HOUR.millis;
                        break;
                    case "d":
                        multiplier = DAY.millis;
                        break;
                    case "w":
                        multiplier = WEEK.millis;
                        break;
                    case "M":
                        multiplier = MONTH.millis;
                        break;
                    case "y":
                        multiplier = YEAR.millis;
                        break;
                    default:
                        return null;
                }
                long ms = (timeLength * multiplier);
                return String.valueOf(ms);
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return null;
        }
    }

    public static String timeMillisToDateString(long currentTimeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        String[] mon ={"January", "February", "March","April", "May", "June", "July", "August", "September", "October", "November", "December"};

        return mDay + " " + mon[mMonth] + " " + mYear;
    }

    public static String timeMillisToDateTimeString(long currentTimeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        int mHour = calendar.get(Calendar.HOUR_OF_DAY);
        int mMinute = calendar.get(Calendar.MINUTE);
//        int mSecond = calendar.get(Calendar.SECOND);

        String mHourString = (mHour < 10 ? "0" : "") + mHour;
        String mMinuteString = (mMinute < 10 ? "0" : "") + mMinute;
//        String mSecondString = (mSecond < 10 ? "0" : "") + mSecond;

        String[] mon ={"January", "February", "March","April", "May", "June", "July", "August", "September", "October", "November", "December"};

        return mDay + " " + mon[mMonth] + " " + mYear + " " + mHourString + ":" + mMinuteString;
    }

    public static String timeMillisToTimeString(Long ms) {
        long days = ((ms - (ms % DAY.millis)) / DAY.millis);
        long dayRemainder = (ms - (days * DAY.millis));

        long hours = ((dayRemainder - (dayRemainder % HOUR.millis)) / HOUR.millis);
        long hoursRemainder = (dayRemainder - (hours * HOUR.millis));

        long minutes = ((hoursRemainder - (hoursRemainder % MINUTE.millis)) / MINUTE.millis);
        long minutesRemainder = (hoursRemainder - (minutes * MINUTE.millis));

        long seconds = (minutesRemainder / 1000);

        String messageBuilder = "";
        if (days > 0) {
            messageBuilder += String.format("%d days, ", days);
        }
        if (hours > 0) {
            messageBuilder += String.format("%d hours, ", hours);
        }
        if (minutes > 0) {
            messageBuilder += String.format("%d minutes, ", minutes);
        }
        if (seconds >= 0) {
            messageBuilder += String.format("%d seconds", seconds);
        }

        return messageBuilder.trim();
    }
}