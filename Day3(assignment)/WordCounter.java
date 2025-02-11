public class WordCounter {
    public static String removeDuplicateCharacters(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "banana";
        System.out.println(removeDuplicateCharacters(input));
    }
}
