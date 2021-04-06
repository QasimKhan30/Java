
import java.util.Scanner ;
import java.io.File;

public class InputOutput {

    public static double sumNumbers(Scanner input) 
    {

        double sumTotal = 0;

        while(input.hasNext()) 
        {

            if (input.hasNextDouble()) 
            {

                sumTotal += input.nextDouble();
            }

            else if (input.hasNextInt()) 
            {
                sumTotal += input.nextInt();
            }

            else 
            {
                input.next();
            }
        }

        return sumTotal;
    }

    public static double sumNumbers(String parseString) {
        Scanner input = new Scanner(parseString);
        double result = sumNumbers(input);

        return result;
    }

    public static double sumNumbersInFile(String filename) throws Exception {
        double sumTotal;
        File inputfile = new File(filename);
        Scanner in = new Scanner(inputfile);

        sumTotal = sumNumbers(in);

        return sumTotal;
    }
}