package implementation;

import java.util.Scanner;

public class TheTimeInWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minutes = scanner.nextInt();
        System.out.println(timeInWords(hour, minutes));
        scanner.close();
    }

    public static String timeInWords(int hour, int minutes) {
        if (minutes==0)
            return toWord(hour) + " o' clock";
        else if (minutes==1)
            return toWord(minutes) + " minute past " + toWord(hour);
        else if (minutes==15 || minutes==30)
            return toWord(minutes) + " past " + toWord(hour);
        else if (minutes<30)
            return toWord(minutes) + " minutes past " + toWord(hour);
        else if (minutes==45)
            return toWord(60-minutes) + " to " + toWord(hour+1);
        else if (minutes==59)
            return toWord(60-minutes) + " minute to " + toWord(hour+1);
        else
            return toWord(60-minutes) + " minutes to " + toWord(hour+1);
    }

    public static String toWord(int value) {
        switch (value) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "quarter";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            case 20:
                return "twenty";
            case 21:
                return "twenty one";
            case 22:
                return "twenty two";
            case 23:
                return "twenty three";
            case 24:
                return "twenty four";
            case 25:
                return "twenty five";
            case 26:
                return "twenty six";
            case 27:
                return "twenty seven";
            case 28:
                return "twenty eight";
            case 29:
                return "twenty nine";
            case 30:
                return "half";
            default:
                return "";
        }
    }
}
