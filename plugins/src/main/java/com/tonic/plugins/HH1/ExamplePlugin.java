package com.tonic.plugins.HH1;

import com.tonic.services.pathfinder.Walker;
import com.tonic.util.VitaPlugin;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.PluginDescriptor;

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
        }
    }

    @Override
    protected void shutDown() {
        // cleanup if needed
    }
}
