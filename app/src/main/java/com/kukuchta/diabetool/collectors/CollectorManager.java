package com.kukuchta.diabetool.collectors;

import com.kukuchta.diabetool.collectors.base.CollectorPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Manages all available collector plugins.
 * It is responsible for activating and running the plugins selected in the app's preferences.
 */
@Singleton
public class CollectorManager {

    private final Set<CollectorPlugin> allPlugins;
    private final List<CollectorPlugin> activePlugins = new ArrayList<>();

    @Inject
    public CollectorManager(Set<CollectorPlugin> allPlugins) {
        this.allPlugins = allPlugins;
        updateActivePlugins();
    }

    /**
     * This method can be called when preferences change to update the active plugins at runtime.
     */
    public void updateActivePlugins() {
        // TODO Use preferences to select which plugins to activate
        String activePluginId = "com.kukuchta.diabetool.collectors.plugins.TestCollectorPlugin";

        activePlugins.clear();
        for (CollectorPlugin plugin : allPlugins) {
            // Here, you need a way to identify plugins. Using the class name is simple.
            if (plugin.getClass().getName().equals(activePluginId)) {
                activePlugins.add(plugin);
            } // TODO Identify plugins by a name
        }
    }

    /**
     * This method will be called by the scheduling mechanism (e.g., in the ViewModel).
     * It iterates over all currently active plugins and triggers data collection.
     */
    public void collectDataFromActivePlugins() {
        for (CollectorPlugin plugin : activePlugins) {
            plugin.collectData();
        }
    }
}
