package main.utils;

import java.awt.*;

public final class ColorUtils {

    public static javafx.scene.paint.Color RS2HSB_to_RGB(int RS2HSB) {
        int decode_hue = (RS2HSB >> 10) & 0x3f;
        int decode_saturation = (RS2HSB >> 7) & 0x07;
        int decode_brightness = (RS2HSB & 0x7f);
        Color awtColor = new Color(Color.HSBtoRGB((float) decode_hue / 63, (float) decode_saturation / 7, (float) decode_brightness / 127));
        int r = awtColor.getRed();
        int g = awtColor.getGreen();
        int b = awtColor.getBlue();
        int a = awtColor.getAlpha();
        double opacity = a / 255.0;
        javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);
        return fxColor;
    }

    public static int convertToHSB(int red, int green, int blue) {
        float[] HSB = Color.RGBtoHSB(red, green, blue, null);
        float hue = (HSB[0]);
        float saturation = (HSB[1]);
        float brightness = (HSB[2]);
        int encode_hue = (int) (hue * 63);            //to 6-bits
        int encode_saturation = (int) (saturation * 7);        //to 3-bits
        int encode_brightness = (int) (brightness * 127);    //to 7-bits
        return (encode_hue << 10) + (encode_saturation << 7) + (encode_brightness);
    }

}
