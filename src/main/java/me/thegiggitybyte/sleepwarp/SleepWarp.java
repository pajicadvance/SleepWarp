package me.thegiggitybyte.sleepwarp;

import net.darktree.simpleconfig.SimpleConfig;
import net.fabricmc.api.ModInitializer;

public class SleepWarp implements ModInitializer {
    private static SimpleConfig config;
    
    @Override
    public void onInitialize() {
        config = SimpleConfig
                .of("sleepwarp")
                .provider(this::getDefaultConfig)
                .request();
    }
    
    public static SimpleConfig getConfig() {
        return config;
    }
    
    private String getDefaultConfig(String fileName) {
        return """
                # Maximum amount of ticks that can be added to the time every server tick. In other words: the max speed of the time warp.
                # Valid: 1 - 2147483647 | Default: 60
                maxTimeAdded=60
                
                # Scales time warp speed in relation to the amount of players currently sleeping.
                # Lower values will require more players to bring the warp up to full speed, and vice versa.
                # Valid: 0.1 - 1.0 | Default: 0.2
                accelerationCurve=0.2
                
                # When true, the 'playersSleepingPercentage' gamerule will be respected and a percentage of players must sleep to begin the time warp.
                # When false, only one player will be required to begin accelerating time.
                # Valid: true, false | Default: false
                useSleepPercentage=false
                """;
    }
}
