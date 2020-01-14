package alexandre01.dreamzonapi.spigot.utils.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.entity.Player;

public class MessageConfig {
    public static void noPerms(Player player, boolean isForVip){
        if(isForVip){
            MessageBuilder messageBuilder = new MessageBuilder( "§c§lCette commande est disponnible que pour les personne ayant le V.I.P §7[Acheter ici]");
            messageBuilder.setHoverMessage(HoverEvent.Action.SHOW_TEXT,"§7Cliquez pour acceder à la boutique");
            messageBuilder.setClickMessage(ClickEvent.Action.OPEN_URL,"http://dreamzon.fr/shop");
            messageBuilder.send(player);
        } else {
            MessageBuilder messageBuilder = new MessageBuilder( "§c§lCette commande est disponnible que pour les personne étant des Administrateurs");
            messageBuilder.setHoverMessage(HoverEvent.Action.SHOW_TEXT,"§7Cliquez pour acceder à notre support");
            messageBuilder.setClickMessage(ClickEvent.Action.OPEN_URL,"https://bit.ly/dreamzon");
            messageBuilder.send(player);
        }
    }
}
