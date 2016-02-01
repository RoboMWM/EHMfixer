package me.robomwm.EHMfixer;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Robo on 1/31/2016.
 */
public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }
}
