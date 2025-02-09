public class PrintStar {
    public static void main(String[] args) {
        int rows = 5; // number of rows for the pattern

        for (int i = 1; i <= rows; i++) {
            // printing the spaces
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            // printing asterisks
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // moving to the next line
            System.out.println();
        }
    }
}