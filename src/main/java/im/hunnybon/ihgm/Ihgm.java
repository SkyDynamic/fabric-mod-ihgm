package im.hunnybon.ihgm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.level.GameRules;

public class Ihgm implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerTickEvents.START_SERVER_TICK.register((server) -> {
            if (server.getPlayerCount() == 0){
                if (server.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)){
                    server.overworld().setDayTime(server.overworld().getDayTime() - 1);
                }
            }
        });
    }
}
