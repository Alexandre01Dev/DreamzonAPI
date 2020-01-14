package alexandre01.dreamzonapi.spigot.utils.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class MessageBuilder {
    private String message;
    private TextComponent textComponentmsg;
    public MessageBuilder(String msg){
        message = msg;
    }
    public void setHoverMessage(HoverEvent.Action action, String hoverMessage){
        TextComponent message;
        if(textComponentmsg != null){
             message = textComponentmsg;
        }else {
             message = new TextComponent(TextComponent.fromLegacyText(this.message));
        }
        message.setHoverEvent(new HoverEvent(action,new ComponentBuilder(hoverMessage).create()));
        textComponentmsg = message;
    }
    public void setClickMessage(ClickEvent.Action action, String clickMessage){
        TextComponent message;
        if(textComponentmsg != null){
            message = textComponentmsg;
        }else {
            message = new TextComponent(TextComponent.fromLegacyText(this.message));
        }
        message.setClickEvent(new ClickEvent(action,clickMessage));
        textComponentmsg = message;
    }
    public void send(Player player){
        if(textComponentmsg != null){
            player.spigot().sendMessage(textComponentmsg);
        }else {
            player.sendMessage(message);
        }

    }
}
