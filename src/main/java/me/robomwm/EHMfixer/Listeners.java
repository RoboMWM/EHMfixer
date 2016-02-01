package me.robomwm.EHMfixer;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Robo on 1/31/2016.
 */
public class Listeners implements Listener
{
    //Fix: attempt to fix EHM's "item protection"
    // Currently EHM's implementation breaks creeper explosions entirely
    @EventHandler(ignoreCancelled = false, priority = EventPriority.LOWEST)
    public void onEntityDamage(EntityDamageEvent event)
    {
        if (!event.isCancelled())
            return;

        Entity entity = event.getEntity();
        EntityType entityType = entity.getType();
        //First see if EHM's logic is what cancelled this event
        if (entityType == EntityType.DROPPED_ITEM && event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)
        {
            event.setCancelled(false);
        }
        else
            return; //otherwise something else cancelled it

        //My guess is that it's just a logic error
        if (entityType == EntityType.DROPPED_ITEM && (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION))
            event.setCancelled(true);
    }
}
