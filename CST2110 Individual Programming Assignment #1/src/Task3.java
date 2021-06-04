import java.util.Scanner;
import java.util.stream.IntStream;

public class Task3 {

    private int currentState;
    private int startState;
    private Scanner scanner;
    private int[] endStates;

    public static void main(String[] args) {
        new Task3();
    }

    public Task3() {
        scanner = new Scanner(System.in);
        startState = 0;
        endStates = new int[]{2};
        // Here it's only one but with other FSMs there are often multiple
        startFSM();
    }

    public void startFSM() {
        // resets current state to startState
        currentState = startState;

        // Starts the console interface
        System.out.println("Enter word to check \n Type '/quit' or '/q' to quit");
        String input = scanner.next();
        try {
            if (checkWord(input)) {
                System.out.println("Word is part of language");
            }
            else if (input.equals("/quit") || input.equals("/q")) {
                System.exit(0);
            }
            else {
                System.out.println("Word is not part of language");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Error - no word entered");
        }
        startFSM();
    }

    public boolean checkWord(String word) {
        // Returns true if word is part of language
        for (int i = 0; i < word.length(); i++) {
            // Go through every character of the given word
            changeState(word.charAt(i));
        }

        // Checks if currentState is any of the end states
        return IntStream.of(endStates).anyMatch(x -> x == currentState);


    }

    public void changeState(char c) {
        // Check if/how the state changes, depending on current char and current state
        if (c == 'b' && currentState != 2) {
            currentState++;
        }
        else if (c == 'b') {
            currentState = 1;
        }
    }

}