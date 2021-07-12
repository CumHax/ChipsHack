package me.cumhax.chipshack.module.combat;

import me.cumhax.chipshack.util.EntityUtil;
import me.cumhax.chipshack.value.Value;
import me.cumhax.chipshack.event.UpdateEvent;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Aura extends Module 
{
	public Aura() {
		super("Aura", "", Category.COMBAT);	
    }
		
    private final Value<Sword> swordValue = new Value<>("Test", Sword.REQUIRE);
    private final Value<Float> range = new Value<>("Range", 5F, 1F, 6F);
    private final Value<Boolean> players = new Value<>("Players", true);
    private final Value<Boolean> animals = new Value<>("Animals", true);
    private final Value<Boolean> mobs = new Value<>("Mobs", true);
    private final Value<Boolean> projectiles = new Value<>("Projectiles", true);

    @SubscribeEvent
    public void onUpdate(UpdateEvent event) {
        if (swordValue.getValue() == Sword.REQUIRE && !(mc.player.getHeldItemMainhand().getItem() instanceof ItemSword)) {
            return;
        }

        final Entity entity;
        entity = getTarget();
        if (entity != null) {
            if (mc.player.getCooledAttackStrength(0) >= 1F) {
                mc.playerController.attackEntity(mc.player, entity);
                mc.player.swingArm(EnumHand.MAIN_HAND);
            }
        } else {
            return;
        }

    }

    Entity getTarget() {

        double maxDistance = -1D;
        Entity entity = null;
        for (Entity ent : mc.world.loadedEntityList) {
            if (EntityUtil.isValidEntity(ent, range.getValue())) {
                if (ent instanceof EntityPlayer && players.getValue() || ent instanceof EntityAnimal && animals.getValue() || ent instanceof EntityMob && mobs.getValue() || ent instanceof EntityShulkerBullet && projectiles.getValue()) {
                    final double distance = mc.player.getDistanceSq(ent);
                    if (maxDistance == -1D || distance < maxDistance) {
                        maxDistance = distance;
                        entity = ent;
                    }
                }
            }
        }

        return entity;
    }

    public enum Sword {
        REQUIRE,
        NONE
    }

}
