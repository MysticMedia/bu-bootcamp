import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("/Users/chrissilvestro/BU/Module2/scores.txt");

        // Stop if no valid scores were found
        if (scores.isEmpty()) {
            System.out.println("No valid scores were found.");
            return;
        }

        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        int high = scores.get(0);
        int low = scores.get(0);

        for (int score : scores) {
            if (score > high) {
                high = score;
            }

            if (score < low) {
                low = score;
            }
        }

        // Step 3: write and print report
        writeReport(scores, average, high, low, "/Users/chrissilvestro/BU/Module2/report.txt");
    }

   // Returns a list of valid scores read from the file
public static ArrayList<Integer> readScores(String filename) {
    ArrayList<Integer> scores = new ArrayList<>();

    try (BufferedReader reader =
             new BufferedReader(
                 new java.io.FileReader(filename))) {

        String line;

        while ((line = reader.readLine()) != null) {
            // Remove whitespace from the line
            line = line.trim();

            // Skip the line if it is blank
            if (line.isEmpty()) {
                continue;
            }

            try {
                // Convert the line into a whole number
                int score = Integer.parseInt(line);

                // Add the valid score to the list
                scores.add(score);

            } catch (NumberFormatException e) {
                System.out.println(
                    "Warning: skipping invalid value: " + line
                );
            }
        }

    } catch (IOException e) {
        System.out.println("Could not read: " + filename);
        System.out.println(e.getMessage());
    }

    return scores;
}

    // Returns the average of a list of scores,
    // or 0.0 if the list is empty
    public static double calculateAverage(
            ArrayList<Integer> scores) {

        if (scores.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (int score : scores) {
            total = total + score;
        }

        return (double) total / scores.size();
    }
    // Grade Bands
    public static  String getGradeBand(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }   
    // Writes and prints the report
    public static void writeReport(
            ArrayList<Integer> scores,
            double avg,
            int high,
            int low,
            String outputFile) {
int countA = 0;
int countB = 0;
int countC = 0;
int countD = 0;
int countF = 0;

for (int score : scores) {
    if (score >= 90) {
        countA++;
    } else if (score >= 80) {
        countB++;
    } else if (score >= 70) {
        countC++;
    } else if (score >= 60) {
        countD++;
    } else {
        countF++;
    }
}
        String report =
            "Grade Analysis Report\n" +
            //"Valid scores: " + scores + "\n" +
            "Total Scores Processed: " + scores.size() + "\n" +
            "Average: " + String.format("%.2f", avg) + "\n" +
            "Highest score: " + high + "\n" +
            "Lowest score: " + low + "\n" +
            "Grade distribution:\n" +
            "  A (90-100):   " + countA + "\n" +
            "  B (80-89):    " + countB + "\n" +
            "  C (70-79):    " + countC + "\n" +
            "  D (60-69):    " + countD + "\n" +
            "  F (below 60): " + countF;
        
                       
        // Print the report on the screen
        System.out.println();
        System.out.println(report);

        // Write the report to a file
        try (PrintWriter writer =
                 new PrintWriter(new FileWriter(outputFile))) {

            writer.println(report);
            System.out.println();
            System.out.println("Report saved to " + outputFile);

        } catch (IOException e) {
            System.out.println(
                "Could not write report: " + outputFile
            );
        }
    }
}