import java.util.Scanner;
import java.util.Stack;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        int windowSize = s1.length();
        
        for (int i = 0; i < s2.length(); i++) {
            char currentChar = s2.charAt(i); 
            stack.push(currentChar);
            s2Count[currentChar - 'a']++;
            
            if (stack.size() > windowSize) {
                char removedChar = stack.remove(0);
                s2Count[removedChar - 'a']--;
            }
            
            if (matches(s1Count, s2Count)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();
        scanner.close();
        
        System.out.println(checkInclusion(s1, s2));
    }
}
