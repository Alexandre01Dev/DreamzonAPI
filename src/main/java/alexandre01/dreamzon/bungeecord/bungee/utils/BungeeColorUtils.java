package alexandre01.dreamzon.bungeecord.bungee.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.Random;

public class BungeeColorUtils {

    private static ChatColor[] chatColors;

    public ChatColor getRandomChatColor(){
        return BungeeColorUtils.chatColors[new Random().nextInt(7)];
    }

    static {
        BungeeColorUtils.chatColors = new ChatColor[]{ChatColor.RED, ChatColor.YELLOW, ChatColor.GOLD, ChatColor.GREEN, ChatColor.AQUA, ChatColor.DARK_AQUA, ChatColor.GRAY};

    }
}
