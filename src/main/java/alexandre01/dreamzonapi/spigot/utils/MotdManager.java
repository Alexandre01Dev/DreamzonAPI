package alexandre01.dreamzonapi.spigot.utils;


import net.minecraft.server.v1_8_R3.MinecraftServer;

public class MotdManager {

    private static MotdManager instance = new MotdManager();
    private MotdManager(){}

    public static MotdManager getInstance() {
        return instance;
    }

    public void setMotd(String motd){
        MinecraftServer.getServer().setMotd(motd);
    }

}
