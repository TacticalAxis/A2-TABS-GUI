package a2.tabs.gui.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public enum FormFieldType {
    INT {
        @Override
        public String getFormat() {
            return "Format: Any integer value";
        }

        @Override
        public boolean isValid(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    LONG {
        @Override
        public String getFormat() {
            return "Format: Any integer value";
        }

        @Override
        public boolean isValid(String input) {
            try {
                Long.parseLong(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    DOUBLE {
        @Override
        public String getFormat() {
            return "Format: Any decimal value";
        }

        @Override
        public boolean isValid(String input) {
            try {
                Double.parseDouble(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    FLOAT {
        @Override
        public String getFormat() {
            return "Format: Any decimal value";
        }

        @Override
        public boolean isValid(String input) {
            try {
                Float.parseFloat(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    BOOLEAN {
        @Override
        public String getFormat() {
            return "Format: yes/y or no/n";
        }

        @Override
        public boolean isValid(String input) {
            return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no");
        }

        @Override
        public String getParsed(String input) {
            return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes") ? "true" : "false";
        }
    },
    STRING {
        @Override
        public String getFormat() {
            return "Format: A valid string value";
        }

        @Override
        public boolean isValid(String input) {
            return true;
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    NAME {
        @Override
        public String getFormat() {
            return "Format: Letters only";
        }

        @Override
        public boolean isValid(String input) {
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isLetter(input.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String getParsed(String input) {
            StringBuilder parsed = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (i == 0) {
                    parsed.append(Character.toUpperCase(input.charAt(i)));
                } else {
                    parsed.append(Character.toLowerCase(input.charAt(i)));
                }
            }
            return parsed.toString();
        }
    },
    USERNAME {
        @Override
        public String getFormat() {
            return "Format: Letters and Numbers only";
        }

        @Override
        public boolean isValid(String input) {
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isLetterOrDigit(input.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    EMAIL {
        @Override
        public String getFormat() {
            return "Format: username@host.com";
        }

        @Override
        public boolean isValid(String input) {
            return input.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$");
        }

        @Override
        public String getParsed(String input) {
            return input.toLowerCase();
        }
    },
    PHONE {
        @Override
        public String getFormat() {
            return "Format: 02123456789";
        }

        @Override
        public boolean isValid(String input) {
            return input.matches("^[0-9]{10,12}$");
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    IRD_NUMBER {
        @Override
        public String getFormat() {
            return "Format: 123-456-789";
        }

        @Override
        public boolean isValid(String input) {
            return input.matches("^[0-9]{3}-[0-9]{3}-[0-9]{3}$");
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    },
    MONEY {
        @Override
        public String getFormat() {
            return "Format: 123456 or $123456";
        }

        @Override
        public boolean isValid(String input) {
            return input.matches("^[0-9]{1,12}(\\.[0-9]{0,2})?$");
        }
//            return input.matches("^\\$?[0-9]+(\\.[0-9]{2})?$");
//        }

        @Override
        public String getParsed(String input) {
            return input.replace("$", "");
        }
    },
    CAR_REGISTRATION {
        @Override
        public String getFormat() {
            return "Format: ABC123";
        }

        @Override
        public boolean isValid(String input) {
            return input.matches("^[A-Za-z0-9]{0,6}$");
        }

        @Override
        public String getParsed(String input) {
            return input.toUpperCase();
        }
    },
    DATE {
        @Override
        public String getFormat() {
            return "Format: 01-01-2022";
        }

        @Override
        public boolean isValid(String input) {
            boolean matches = input.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$");
            if (!matches) {
                return false;
            }

            String[] parts = input.split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // check if date is correct including leap years
            if (month == 2) {
                GregorianCalendar gc = new GregorianCalendar(year, Calendar.FEBRUARY, day);
                if (gc.isLeapYear(gc.get(Calendar.YEAR)) && day > 29) {
                    return false;
                }

                if (!gc.isLeapYear(gc.get(Calendar.YEAR)) && day > 28) {
                    return false;
                }
            }

            // check if date is correct for months with 30 days
            return (month != 4 && month != 6 && month != 9 && month != 11) || day <= 30;
        }

        @Override
        public String getParsed(String input) {
            return input;
        }
    };

    public abstract String getFormat();

    public abstract boolean isValid(String value);

    public abstract String getParsed(String value);
}