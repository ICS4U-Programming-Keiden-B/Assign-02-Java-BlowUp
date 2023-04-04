
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
* Assignment 2; String Stuff.
*
* @author  Keiden B
* @version 1.0
* @since   2023-04-03
*/

public final class BlowUp {
    /**
    * Necessary to prevent HideUtilityClass Error.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */
    private BlowUp() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Function to blow up the text input.
    *
    * @param unBlown a placeholder value when making the main function.
    * @return the blown-up text.
    */
    public static String blowUpString(String unBlown) {
        // Converting the text into an array of characters
        final char[] charArray = unBlown.toCharArray();
        // Declaring variables
        int multiplier = 0;
        int letterInt = 0;
        String allLine = "";
        // Loop for each letter from the inputted string.
        for (char letter : charArray) {
            // Declares variable for what should be added to the string.
            String addLetter = "";
            // Tries to convert the character to a string.
            try {
                letterInt = Integer.parseInt(String.valueOf(letter));
                // Adds an amount of this loop's character depending on the
                // number that came in the previous loop.
                // Does not activate if there is no
                // multiplier from the previous loop.
                if (multiplier != 0) {
                    for (int times = 0; times <= multiplier; times++) {
                        addLetter += letter;
                    }
                    // Resets the multiplier back to 0.
                    multiplier = 0;
                }
                // Creates a new multiplier for the next loop.
                multiplier = letterInt;
                // Will add the character to the string if it is not an int.
            } catch (NumberFormatException error) {
                // Adds an amount of this loop's character depending on the
                // number that came in the previous loop.
                for (int times = 0; times <= multiplier; times++) {
                    addLetter += letter;
                }
                // Resets the multiplier back to 0.
                multiplier = 0;
                // Resets letterInt to 0 to not cause problems when
                // there is a number at the end of the text.
                letterInt = 0;
            }
            // Adds the text that should be added to the end of a string.
            allLine += addLetter;
        }
        // If there is a letter at the end of the input text,
        // adds it to the output string.
        if (letterInt != 0) {
            allLine += Integer.toString(letterInt);
        }
        // Returns the string with the blown-up text.
        return allLine;
    }

    /**
    * Main lines of code.
    *
    * @param args a placeholder value when making the main function.
    * @throws Exception thrown when making scanner for the input file.
    */
    public static void main(String[] args) throws Exception {
        // Making file path and scanner objects.
        final File filePath = new File("./Assign-02-Input.txt");
        final FileWriter fileOut = new FileWriter("./Assign-02-Output.txt");
        final Scanner scanNext = new Scanner(filePath);

        // Repeats for all lines in the text file.
        while (scanNext.hasNextLine()) {
            // Grabs a line.
            final String strLine = scanNext.nextLine();
            // Calls function to convert the string
            // into a blown-up form.
            final String blownUp = blowUpString(strLine);
            // Printing the blown-up text to the console.
            System.out.println(blownUp);
            // Printing the blown-up text to an output file.
            fileOut.write(blownUp);
        }
        // Closing the scanners.
        fileOut.close();
        scanNext.close();
    }
}
