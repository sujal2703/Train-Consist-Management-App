import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a LinkedList to represent the physical train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        System.out.println("--- UC4: Maintaining Ordered Train Consist (LinkedList) ---");

        // 2. Add initial bogies (addLast is the default for add)
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");
        trainConsist.add("Guard Coach");

        System.out.println("Initial Train Formation: " + trainConsist);

        // 3. Insert a Pantry Car at position 2 (after the Sleeper)
        System.out.println("\nAction: Inserting 'Pantry Car' at index 2...");
        trainConsist.add(2, "Pantry Car");

        // 4. Display the train after middle insertion
        System.out.println("Updated Formation: " + trainConsist);

        // 5. Remove the first and last bogies (Simulating decoupling)
        System.out.println("\nAction: Detaching Engine (First) and Guard Coach (Last)...");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // 6. Display the final ordered train consist
        System.out.println("\nFinal Consist State (After Shunting):");
        int position = 1;
        for (String bogie : trainConsist) {
            System.out.println("Position " + position + ": " + bogie);
            position++;
        }

        System.out.println("\nTotal Bogies Remaining: " + trainConsist.size());
    }
}