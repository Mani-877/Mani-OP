class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Friday", "Saturday", "Sunday", "Monday",
                         "Tuesday", "Wednesday", "Thursday"};

        int[] daysInMonth = {31, 28, 31, 30, 31, 30,
                             31, 31, 30, 31, 30, 31};

        int totalDays = 0;

        // Add days for complete years
        for (int y = 1971; y < year; y++) {
            totalDays += isLeap(y) ? 366 : 365;
        }

        // Add days for complete months
        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];
            if (m == 2 && isLeap(year)) {
                totalDays++; // February in a leap year
            }
        }

        // Add days of current month
        totalDays += day - 1;

        return week[totalDays % 7];
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}

Output

Input	Output
day = 31, month = 8, year = 2019	"Saturday"
day = 18, month = 7, year = 1999	"Sunday"
day = 15, month = 8, year = 1993	"Sunday"
