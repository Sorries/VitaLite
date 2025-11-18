package com.tonic.plugins.HH1;

import com.tonic.Logger;
import com.tonic.api.entities.PlayerAPI;
import com.tonic.data.wrappers.ActorEx;
import com.tonic.data.wrappers.PlayerEx;
import com.tonic.queries.PlayerQuery;
import com.tonic.services.GameManager;
import com.tonic.services.pathfinder.Walker;
import com.tonic.util.VitaPlugin;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.Objects;
import java.util.stream.Collectors;

@PluginDescriptor(
        name = "HH1 Example",
        description = "HH1 Example - 1",
        tags = {"HH1", "example"}
)

public class ExamplePlugin extends VitaPlugin {

    @Override
    protected void startUp() {
        int t = 0;
        while (t == 0) {
            Walker.walkTo(new WorldPoint(3096, 3236, 0));
            t++;
            Logger.info(" " + PlayerEx.getLocal().getPlayer());
            Logger.info(""+ PlayerAPI.search());
            Logger.info(""+ GameManager.playerList().get(0).getPlayer().getName());
            Logger.info(""+ GameManager.playerList()
                    .stream()
                    .map(PlayerEx::getName)
                    .collect(Collectors.toList()));
            Logger.info(""+ GameManager.playerList()
                    .stream()
                    .filter(playerEx -> !playerEx.getPlayer().getName().equals(PlayerEx.getLocal().getPlayer().getName()))
                    .map(player -> player.getPlayer().getName() )
                    .collect(Collectors.toList()));
            Logger.info(""+ GameManager.playerList()
                    .stream()
                    .filter(p -> !Objects.equals(p.getPlayer().getName(), PlayerEx.getLocal().getPlayer().getName()))
                    .map(player -> player.getPlayer().getName() )
                    .collect(Collectors.toList()));
            Logger.info(""+ PlayerAPI.search().withName("Honsinoa"));
        }
    }

    @Override
    protected void shutDown() {
        // cleanup if needed
    }
}
