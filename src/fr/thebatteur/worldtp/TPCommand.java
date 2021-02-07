package fr.thebatteur.worldtp;

import org.bukkit.Location;

public class TPCommand {

    private String name;
    private String command;
    private String permission;
    Location location;

    public TPCommand(String name, String command, String permission, Location location) {
        this.name = name;
        this.command = command;
        this.permission = permission;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
