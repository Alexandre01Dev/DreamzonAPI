package alexandre01.dreamzonapi.spigot.utils;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {

    private ItemStack is;

    public ItemBuilder(Material material){
        this(material, 1);
    }

    public ItemBuilder(ItemStack is){
        this.is = is;
    }

    public ItemBuilder(Material material, int ammount){
        is = new ItemStack(material,ammount);
    }

    public ItemBuilder(Material material, int amount, short meta){
        is = new ItemStack(material, amount, meta);
    }

    public ItemBuilder clone(){
        return new ItemBuilder(is);
    }

    public ItemBuilder setDurability(short durability){
        is.setDurability(durability);
        return this;
    }

    public ItemBuilder setName(String name){
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder addUnsafeEnchantment(Enchantment enchantment, int level){
        is.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment enchantment){
        is.removeEnchantment(enchantment);
        return this;
    }

    public ItemBuilder setSkullOwner(String owner){
        try {
            SkullMeta im = (SkullMeta) is.getItemMeta();
            im.setOwner(owner);
            is.setItemMeta(im);
        }catch (ClassCastException e){
        }
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level){
        ItemMeta im = is.getItemMeta();
        im.addEnchant(enchantment,level, true);
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setInfinityDurability(){
        is.setDurability(Short.MAX_VALUE);
        return this;
    }

    public ItemBuilder setLore(String lore){
        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setWoolColor(DyeColor color){
        if(!is.getType().equals(Material.WOOL))
            return this;
            this.is.setDurability(color.getData());
            return this;
    }

    public ItemBuilder setClayColor(DyeColor color){
        if(!is.getType().equals(Material.CLAY))
            return this;
            this.is.setDurability(color.getData());
            return this;
    }

    public ItemBuilder setGlassColor(DyeColor color){
        if(!is.getType().equals(Material.STAINED_GLASS_PANE))
            return this;
            this.is.setDurability(color.getData());
            return this;
    }

    public ItemBuilder setCarpetColor(DyeColor color){
        if(!is.getType().equals(Material.CARPET))
            return this;
            this.is.setDurability(color.getData());
            return this;
    }

    public ItemBuilder setLeatherArmorColor(Color color){
        try {
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();

            im.setColor(color);
            is.setItemMeta(im);

        }catch (ClassCastException e){
        }

        return this;
    }

    public ItemStack toItemStack(){
        return is;
    }
}
