package alexandre01.dreamzonapi.spigot.utils.utils;


import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.Navigation;
import net.minecraft.server.v1_8_R3.PathEntity;
import net.minecraft.server.v1_8_R3.PathfinderGoal;
import org.bukkit.Location;

public class PathfinderGoalWalkToLoc extends PathfinderGoal {

    private float speed;

    private EntityInsentient entity;

    private Location loc;

    private Navigation navigation;

    public PathfinderGoalWalkToLoc(EntityInsentient entity, Location loc, float speed) {
        this.entity = entity;
        this.loc = loc;
        this.navigation = (Navigation) this.entity.getNavigation();
        this.speed = speed;
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public void c() {
        PathEntity pathEntity = this.navigation.a(loc.getX(), loc.getY(), loc.getZ());
        this.navigation.a(pathEntity, speed);
    }
}