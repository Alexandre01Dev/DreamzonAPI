package alexandre01.dreamzonapi.spigot.utils.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutCustomPayload;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftMetaBook;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class Books {

    public static void openBook(ItemStack book, Player p) {
        int slot = p.getInventory().getHeldItemSlot();
        ItemStack old = p.getInventory().getItem(slot);
        p.getInventory().setItem(slot, book);

        ByteBuf buf = Unpooled.buffer(256);
        buf.setByte(0, (byte) 0);
        buf.writerIndex(1);

        PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
        //PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(Unpooled.buffer())); //This might work as well..im not waiting even more for my IDE to stop dying
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        p.getInventory().setItem(slot, old);
    }

    public static ItemStack getSkinBook() {
        try {
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta); //This
            TextComponent page1 = new TextComponent(new ComponentBuilder("§cSysteme de Skins §7[BETA]").event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7[BETA]").create())).create()); //This
            page1.addExtra("\n \n");
            TextComponent warning = new TextComponent(TextComponent.fromLegacyText("§cCe systeme contient d'inombrable bug / Lorsque un d'eux surgit veuillez contacter le support !"));
            page1.addExtra(warning);
            page1.addExtra(" \n \n");
            TextComponent warning2 = new TextComponent(TextComponent.fromLegacyText("§cLorsque vous changez de pages vous acceptez des lors les conditions ci dessus et les adhérer "));
            page1.addExtra(warning2);
            IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(new BaseComponent[]{page1}));
            //PAGE2
            TextComponent page2txt = new TextComponent(new ComponentBuilder("§cSysteme de Skins §7[BETA]").event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7[BETA]").create())).create()); //This
            page2txt.addExtra("\n \n \n");
            TextComponent asking = new TextComponent(TextComponent.fromLegacyText("§9Veuillez cliquez dans les cases ci dessous pour choisir votre skins \n "));
            page2txt.addExtra(asking);
            TextComponent button1 = new TextComponent(TextComponent.fromLegacyText("        §7[Clique-ici]"));
            button1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new ComponentBuilder("§7Clique ici").create()));

            button1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/skin choice"));
            page2txt.addExtra(button1);
            page2txt.addExtra("\n");

            IChatBaseComponent page2 = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(new BaseComponent[]{page2txt}));
            pages.add(page); // and this is what you need for it to work
            pages.add(page2);
            meta.setTitle("§cSysteme de Skins §7[BETA]");
            meta.setAuthor("DreamZon Network");
            book.setItemMeta(meta);
            return book;
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {

        }
        return null;
    }

}
