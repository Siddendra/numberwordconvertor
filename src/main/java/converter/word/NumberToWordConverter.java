package converter.word;

import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import static converter.word.constant.NumberToWordConstant.*;

/**
 * Java program to print a given number in words.
 * The program handles numbers from 0 to 999,999,999.
 */
public class NumberToWordConverter {

    private static final Logger logger = Logger.getLogger(NumberToWordConverter.class);

    /**
     * The First String is not used, it is to make array index simple.
     */
    public static final String[] units = {EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN,
            TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN};

    /**
     * The first Two string are not used, they are to make array indexing simple.
     */
    public static final String[] tens = {
            EMPTY,              //0
            EMPTY,              //1
            TWENTY,             //2
            THIRTY,             //3
            FORTY,              //4
            FIFTY,              //5
            SIXTY,              //6
            SEVENTY,            //7
            EIGHTY,             //8
            NINETY              //9
    };


    /**
     * The function that returns the given number in words by using the rail recursion.
     *
     * @param n
     * @return
     */
    public static String convert_to_words(final int n) {
        if (n < 0) {
            return "Minus " + convert_to_words(-n);
        }

        //For the numbers below 20.
        if (n < 20) {
            return units[n];
        }
        //For the number below 100 adding Tens.
        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }
        //For the number below 1000 adding Hundreds
        if (n < 1000) {
            return units[n / 100] + HUNDRED + ((n % 100 != 0) ? " " : "") + convert_to_words(n % 100);
        }
        //For the number below 100000 adding Thousand
        if (n < 100000) {
            return convert_to_words(n / 1000) + THOUSAND + ((n % 1000 != 0) ? " " : "") + convert_to_words(n % 1000);
        }
        //For the Number 1000000 adding the Hundred thousands.
        if (n < 1000000) {
            if (n != 100000) {
                return convert_to_words(n / 100000) + HUNDRED + ((n % 100000 != 0) ? " " : "") + convert_to_words(n % 100000);
            } else {
                return convert_to_words(n / 100000) + HUNDRED_THOUSAND + ((n % 100000 != 0) ? " " : "") + convert_to_words(n % 100000);
            }
        }
        //For the Number below 1000000 adding the Millions
        return convert_to_words(n / 1000000) + MILLION + ((n % 1000000 != 0) ? " " : "") + convert_to_words(n % 1000000);

    }

    /**
     * The Driver Code
     *
     * @param args
     */
    public static void main(String args[]) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the Number to convert into Word format :");
        try {
            n = scanner.nextInt();
            logger.info("The Given number is :" + n);
            logger.info(NumberFormat.getInstance().format(n) + "='" + convert_to_words(n) + "'");
        } catch (InputMismatchException e) {
            logger.error("Exception : " + e +". \n Please enter the valid number" );
        }
    }

}
