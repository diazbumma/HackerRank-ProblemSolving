package strings;

import java.util.Scanner;

public class MakingAnagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(makingAnagrams(s1, s2));
        scanner.close();
    }

    public static int makingAnagrams(String s1, String s2) {
        int same = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i=0; i<s1.length(); i++)
            freq1[s1.charAt(i) - 'a']++;
        for (int i=0; i<s2.length(); i++)
            freq2[s2.charAt(i) - 'a']++;
        for (int i=0; i<26; i++)
            same += (Math.min(freq1[i], freq2[i]));
        return (s1.length()-same)+(s2.length()-same);
    }
}
