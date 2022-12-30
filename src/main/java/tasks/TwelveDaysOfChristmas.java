package tasks;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DESCRIPTION:
 * Oh No!
 * <p>
 * The song sheets have been dropped in the snow and the lines of each verse have become all jumbled up.
 * <p>
 * Task
 * You have to write a comparator function which can sort the lines back into their correct order, otherwise Christmas will be cancelled!
 * <p>
 * Reminder: Below is what the final verse should look like
 * <p>
 * On the 12th day of Christmas my true love gave to me
 * 12 drummers drumming,
 * 11 pipers piping,
 * 10 lords a leaping,
 * 9 ladies dancing,
 * 8 maids a milking,
 * 7 swans a swimming,
 * 6 geese a laying,
 * 5 golden rings,
 * 4 calling birds,
 * 3 French hens,
 * 2 turtle doves and
 * a partridge in a pear tree.
 */
public class TwelveDaysOfChristmas {
    public static void main(String[] args) {

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("12 drummers drumming,");
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    public static class HelpSaveChristmas implements Comparator<String> {

        @Override
        public int compare(final String line1, final String line2) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m1 = p.matcher(line1);
            Matcher m2 = p.matcher(line2);
            while (m1.find() && m2.find()) {
                return Integer.parseInt(m1.group()) > Integer.parseInt(m2.group()) ? 1 : 0;
            }
            return 0;
        }
    }
}
