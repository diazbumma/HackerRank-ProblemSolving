package strings;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<testCase; i++) {
            String s = scanner.nextLine();
            System.out.println(anagram(s));
        }
        scanner.close();
    }

    public static int anagram(String s) {
        int same = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        String s1 = s.substring(0, s.length()/2);
        String s2 = s.substring((s.length()/2), s.length());
        if (s1.length()!=s2.length())
            return -1;
        for (int i=0; i<s1.length(); i++)
            freq1[s1.charAt(i) - 'a']++;
        for (int i=0; i<s2.length(); i++)
            freq2[s2.charAt(i) - 'a']++;
        for (int i=0; i<26; i++)
            same += (Math.min(freq1[i], freq2[i]));
        return ((s1.length()-same)+(s2.length()-same))/2;
    }
}
