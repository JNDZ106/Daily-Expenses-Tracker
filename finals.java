import javax.swing.JOptionPane;
public class finals {
    
    public static void main(String []args){
        // TODO Auto-generated method stub

        // Scenario: A user wants to track their spending for one work week (5 days).

        // The Tasks:

        // Declare a double[] of size 5 to store expenses.

        // Use a for loop and showInputDialog to ask for the expense of each day
        // (Monday–Friday).

        // After input, use another loop to calculate the Total and Average spending.

        // Use a Conditional to check: if the total exceeds ₱2,000, show a "Budget Exceeded"
        // warning; otherwise, show "Within Budget."

        // Display the full list and results in a showMessageDialog.


        

        // Create array to store total expenses for each day (5 days)
        double[] expenses = new double[5];
        // Array of day names
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        
       try {
           // Loop through each day of the week
         for (int i = 0; i < expenses.length; i++) {
            // Variables to validate and store number of spending transactions
            boolean validNumTransactions = false;
            int numTransactions = 0;
            
            // Keep asking until user enters a valid number (not negative, not text)
            while (!validNumTransactions) {
                try {
                    // Ask user how many times they spent money on this day
                    String input = JOptionPane.showInputDialog(null, "How many times did you spend money on " + days[i] + "?", "Number of Transactions", JOptionPane.QUESTION_MESSAGE);
                    numTransactions = Integer.parseInt(input);
                    // Check if number is negative
                    if (numTransactions < 0) {
                        JOptionPane.showMessageDialog(null, "Number of transactions cannot be negative. Please try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // Valid input, exit the while loop
                        validNumTransactions = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                }
            }
            
            // Now ask for each individual spending amount
            double dayTotal = 0; // Sum all spending amounts for this day
            // Loop for each transaction the user specified
            for (int j = 0; j < numTransactions; j++) {
                boolean validAmount = false;
                while (!validAmount) {
                    try {
                        // Ask for amount of each spending
                        String input = JOptionPane.showInputDialog(null, "Enter spending amount #" + (j+1) + " for " + days[i] + ":", "Expense Amount", JOptionPane.QUESTION_MESSAGE);
                        double amount = Double.parseDouble(input);
                        // Check if amount is negative
                        if (amount < 0) {
                            JOptionPane.showMessageDialog(null, "Amount cannot be negative. Please try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        } else {
                            // Add amount to day total and mark as valid
                            dayTotal += amount;
                            validAmount = true;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            // Store the total spending for this day in the expenses array
            expenses[i] = dayTotal;
        }
        
        // Calculate total spending for the entire week
        double total = 0;
        for (double expense : expenses) {
            total += expense;
        }
        // Calculate average spending per day
        double average = total / expenses.length;

        // Create a message to display all results
        String message = "Expenses for the week:\n";
        // List each day's total expense
        for (int i = 0; i < expenses.length; i++) {
            message += days[i] + ": ₱" + String.format("%.2f", expenses[i]) + "\n---------------------------------------------\n";
        }
        // Add total and average to message
        message += "Total: ₱" + String.format("%.2f", total) + "\n";
        message += "Average: ₱" + String.format("%.2f", average) + "\n---------------------------------------------\n";



        // Check if total exceeded budget of ₱2,000
        if (total > 2000) {
            message += "Warning: Budget Exceeded!";
        } else {
            message += "Status: Within Budget.";
        }

        // Display the complete expense report
        JOptionPane.showMessageDialog(null, message);
       } catch (Exception e) {
        // TODO: handle exception
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for expenses.", "Error", JOptionPane.ERROR_MESSAGE);
       }

    }

}
