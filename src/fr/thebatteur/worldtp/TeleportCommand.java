package fr.thebatteur.worldtp;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class TeleportCommand extends BukkitCommand {

    private TPCommand cmd;

    public TeleportCommand(String name, TPCommand cmd) {
        super(name);
        this.cmd = cmd;
        if(!cmd.getPermission().equalsIgnoreCase("none"))
            this.setPermission(cmd.getPermission());
        this.usageMessage = "/" + cmd.getCommand();
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(!cmd.getPermission().equalsIgnoreCase("none") && !player.hasPermission(cmd.getPermission())) {
                player.sendMessage(WorldTp.getInstance().getNoPermissionMessage());
                return false;
            }
            if(args.length != 0) {
                switch (WorldTp.getInstance().language) {
                    case FR:
                        player.sendMessage("§cUtilisation : " + this.usageMessage);
                        return false;
                    case EN:
                        player.sendMessage("§cUsage : " + this.usageMessage);
                        break;
                }
                return false;
            }
            TPCommand command = this.cmd;
            if(player.getWorld().equals(command.getLocation().getWorld()))
                player.sendMessage(WorldTp.getInstance().getAlreadyInWorldMessageTp().replaceAll("%s",command.getName()));
            else {
                player.teleport(command.getLocation());
                player.sendMessage(WorldTp.getInstance().getSuccessMessageTp().replaceAll("%s",command.getName()));
            }
        } else {
            switch (WorldTp.getInstance().language) {
                case FR:
                    sender.sendMessage("§cCette commande ne peut être executée que par des joueurs.");
                    break;
                case EN:
                    sender.sendMessage("§cThis command can be only executed by players.");
                    break;
            }
        }
        return true;
    }
}