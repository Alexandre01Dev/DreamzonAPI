package alexandre01.dreamzonapi.spigot;


import alexandre01.dreamzonapi.spigot.utils.MotdManager;

public class API {

    public static MotdManager getMotdSystem(){
        return MotdManager.getInstance();
    }

}
