package fr.thebatteur.worldtp;

import com.google.common.base.Charsets;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_9_R2.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class WorldTp extends JavaPlugin {

    private static WorldTp instance;
    private final String PLUGIN_NAME = "WorldTp";
    public Language language;
    private FileConfiguration messages;

    @Override
    public void onEnable() {
        createConfig();
        language = Language.getByName(getConfig().getString("language"));
        instance = this;
        int i = 1;
        while (true) {
            if(getConfig().getString("commands.cmd" + i) != null) {
                if(Bukkit.getWorld(getConfig().getString("commands.cmd" + i + ".world")) == null) {
                    try {
                        switch (language) {
                            case FR:
                                getLogger().log(Level.WARNING, "La commande '" + getConfig().getString("commands.cmd" + i + ".command") + "' ne peut pas être chargée (monde spécifié innexistant).");
                                break;
                            case EN:
                                getLogger().log(Level.WARNING, "The command '" + getConfig().getString("commands.cmd" + i + ".command") + "' could not be loaded (specified world not exist).");
                                break;
                        }
                    } catch (NullPointerException e) {
                        switch (language) {
                            case FR:
                                getLogger().log(Level.WARNING, "Un problème est survenu lors du chargement de la commande " + i + ". (valeur nule)");
                                break;
                            case EN:
                                getLogger().log(Level.WARNING, "Somthing went wrong while loading the command " + i + ". (null value)");
                                break;
                        }
                    }
                } else {
                    TPCommand command = null;
                    try {
                        command = new TPCommand(
                                getConfig().getString("commands.cmd" + i + ".name"),
                                getConfig().getString("commands.cmd" + i + ".command"),
                                null,
                                new Location(Bukkit.getWorld(getConfig().getString("commands.cmd" + i + ".world")),
                                        getConfig().getDouble("commands.cmd" + i + ".x"),
                                        getConfig().getDouble("commands.cmd" + i + ".y"),
                                        getConfig().getDouble("commands.cmd" + i + ".z"),
                                        (float) getConfig().getDouble("commands.cmd" + i + ".yaw"),
                                        (float) getConfig().getDouble("commands.cmd" + i + ".pitch")
                                )
                        );
                    } catch (NullPointerException e) {
                        switch (language) {
                            case FR:
                                getLogger().log(Level.WARNING, "Un problème est survenu lors du chargement de la commande " + i + ". (valeur nule)");
                                break;
                            case EN:
                                getLogger().log(Level.WARNING, "Somthing went wrong while loading the command " + i + ". (null value)");
                                break;
                        }
                    }
                    command.setPermission(getConfig().getString("commands.cmd" + i + ".permission"));
                    ((CraftServer) this.getServer()).getCommandMap().register(command.getCommand(), new TeleportCommand(command.getCommand(), command));
                }
            } else
                break;
            ++i;
        }
        switch (language) {
            case FR:
                Bukkit.getConsoleSender().sendMessage("[" + PLUGIN_NAME + "] §aDémarré ! §7(Créer par THE_BATTEUR <3");
                break;
            case EN:
                Bukkit.getConsoleSender().sendMessage("[" + PLUGIN_NAME + "] §aStarted! §7(Made by THE_BATTEUR <3)");
        }
    }

    public static WorldTp getInstance() {
        return instance;
    }

    public void reloadMessages() {
        this.messages = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "messages.yml"));
        InputStream defConfigStream = this.getResource("config.yml");
        if (defConfigStream != null) {
            this.messages.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        }
    }

    public FileConfiguration getMessages() {
        if(this.messages == null)
            reloadMessages();
        return this.messages;
    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) getDataFolder().mkdirs();
            File messages = new File(getDataFolder(), "messages.yml");
            if (!messages.exists())
                saveResource("messages.yml", false);
            File config = new File(getDataFolder(), "config.yml");
            if (!config.exists())
                saveDefaultConfig();
        } catch (Exception exception) {
            getLogger().info(exception.getMessage());
        }
    }

    public String getSuccessMessageTp() {
        return getMessages().getString("messages_" + language.getName() + ".successtp");
    }

    public String getAlreadyInWorldMessageTp() {
        return getMessages().getString("messages_" + language.getName() + ".alreadyinworld");
    }

    public String getNoPermissionMessage() {
        return getMessages().getString("messages_" + language.getName() + ".nopermission");
    }
}
