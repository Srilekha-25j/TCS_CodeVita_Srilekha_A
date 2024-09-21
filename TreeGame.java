import java.util.*;

public class TreeGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the trees in Ashok's row
        String ashokTrees = scanner.nextLine().trim();
        // Input the trees in Anand's row
        String anandTrees = scanner.nextLine().trim();

        // Validate inputs
        if (!isValidInput(ashokTrees) || !isValidInput(anandTrees)) {
            System.out.println("Invalid input");
            return;
        }

        // Calculate the possibilities
        int ashokPossibilities = calculatePossibilities(ashokTrees);
        int anandPossibilities = calculatePossibilities(anandTrees);

        // Determine the winner
        if (ashokPossibilities > anandPossibilities) {
            System.out.println("Ashok");
        } else if (anandPossibilities > ashokPossibilities) {
            System.out.println("Anand
