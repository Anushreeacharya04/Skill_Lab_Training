import java.util.*;

public class IPv4Validator {
    public boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            if (!isValidPart(part)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidPart(String part) {
        if (part.isEmpty() || part.length() > 3) {
            return false;
        }
        
        if (part.charAt(0) == '0' && part.length() > 1) { // Leading zero case
            return false;
        }
        
        try {
            int num = Integer.parseInt(part);
            return num >= 0 && num <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IPv4Validator validator = new IPv4Validator();
        
        System.out.print("Enter an IPv4 address: ");
        String input = scanner.nextLine();
        
        System.out.println("Valid IPv4 address: " + validator.isValidIPv4(input));
        
        scanner.close();
    }
}
