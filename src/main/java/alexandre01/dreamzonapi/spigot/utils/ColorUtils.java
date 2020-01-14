package alexandre01.dreamzonapi.spigot.utils;


import net.minecraft.server.v1_8_R3.EnumColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;

import java.util.Random;

public class ColorUtils {

    private static Color[] colors;
    private static DyeColor[] dyeColors;
    private static ChatColor[] chatColorsSpigot;
    private static EnumColor[] enumColors;

    public static Color getRandomColor(){
        return ColorUtils.colors[new Random().nextInt(16)];
    }

    public static EnumColor getRandomEnumColor(){
        return ColorUtils.enumColors[new Random().nextInt(16)];
    }

    public static DyeColor getRandomDyeColor(){
        return ColorUtils.dyeColors[new Random().nextInt(16)];
    }

    public static ChatColor getRandomChatColorSpigot(){
        return ColorUtils.chatColorsSpigot[new Random().nextInt(7)];
    }

    static {
        ColorUtils.enumColors = new EnumColor[]{EnumColor.BLACK, EnumColor.BLUE, EnumColor.BROWN, EnumColor.CYAN,EnumColor.GRAY,EnumColor.GREEN,EnumColor.LIME,EnumColor.LIGHT_BLUE,EnumColor.MAGENTA,EnumColor.ORANGE,EnumColor.RED,EnumColor.PINK,EnumColor.PURPLE,EnumColor.SILVER,EnumColor.WHITE,EnumColor.YELLOW};
        ColorUtils.colors = new Color[]{Color.AQUA,Color.BLACK,Color.BLUE,Color.FUCHSIA,Color.GREEN,Color.GRAY,Color.LIME,Color.MAROON,Color.NAVY,Color.OLIVE,Color.ORANGE,Color.PURPLE,Color.RED,Color.SILVER,Color.WHITE,Color.YELLOW};
        ColorUtils.dyeColors = new DyeColor[]{DyeColor.BLACK,DyeColor.BLUE, DyeColor.BROWN,DyeColor.CYAN,DyeColor.GRAY,DyeColor.GREEN,DyeColor.LIGHT_BLUE,DyeColor.LIME,DyeColor.MAGENTA,DyeColor.ORANGE,DyeColor.PINK,DyeColor.PURPLE,DyeColor.RED,DyeColor.SILVER,DyeColor.WHITE,DyeColor.YELLOW};
        ColorUtils.chatColorsSpigot = new ChatColor[]{ChatColor.RED,ChatColor.YELLOW, ChatColor.GOLD,ChatColor.GREEN, ChatColor.AQUA,ChatColor.DARK_AQUA,ChatColor.GRAY};
    }

}
