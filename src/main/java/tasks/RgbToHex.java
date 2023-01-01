package tasks;

/**
 * The rgb function is incomplete. Complete it so that passing in RGB decimal values will
 * result in a hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255.
 * Any values that fall out of that range must be rounded to the closest valid value.
 * <p>
 * Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
 * <p>
 * The following are examples of expected output values:
 * <p>
 * RgbToHex.rgb(255, 255, 255) // returns FFFFFF
 * RgbToHex.rgb(255, 255, 300) // returns FFFFFF
 * RgbToHex.rgb(0, 0, 0)       // returns 000000
 * RgbToHex.rgb(148, 0, 211)   // returns 9400D3
 */
public class RgbToHex {
    public static void main(String[] args) {
        System.out.println(rgb(0, 255, 300));
    }

    public static String rgb(int r, int g, int b) {
        if (r <= 0) r = 0;
        else if (r > 255) r = 255;

        if (g < 0) g = 0;
        else if (g > 255) g = 255;

        if (b < 0) b = 0;
        else if (b > 255) b = 255;
        String red = "";
        if (r >= 0 && r < 10) red = "0" + r;
        else red = Integer.toHexString(r).toUpperCase();
        String green = "";
        if (g >= 0 && g < 10) green = "0" + g;
        else green = Integer.toHexString(g).toUpperCase();
        String blue = "";
        if (b >= 0 && b < 10) blue = "0" + b;
        else blue = Integer.toHexString(b).toUpperCase();

        return red + green + blue;
    }
}
