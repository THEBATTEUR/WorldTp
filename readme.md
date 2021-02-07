# WorldTp - World Teleporter / Monde Téléporteur

![](https://cdn.discordapp.com/emojis/757360038770900993.png?v=1)  
A simple plugin to create commands of tp between the server Worlds. A friend asked to me to do a short plugin which can do that. And I decided to make it public :smile:.

![](https://cdn.discordapp.com/emojis/757359922416451675.png?v=1)  
Un plugin simple permettant de créer des commandes de tp entre les mondes d'un serveur. Une amie m'a demandé de faire un petit plugin qui pouvait faire ça. Et j'ai décidé de le rendre publique :smile:.

---------
## Configuration

### config.yml
![](https://cdn.discordapp.com/emojis/757360038770900993.png?v=1)  
There is the default configuration for example.
* In **language**, you choose the language of the plugin and the messages (only FR and EN for now).
* In **commands**, you put your commands. Each command you add, you add the number of commands created. For instance, cmd1, cmd2 cmd3...
* In **name**, you put the name of the world which will be in the message of teleportation.
* In **command**, you put the command that your players will execute.
* In **permission**, you put the permission to execute the command. Use "none" to make the command executable for everyone.
* In **world**, you put the name of the world where your players needs to be teleported.
* In **x**, **y**, **z**, you put the coordinates where your players needs to be teleported.
* In **yaw** and **pitch**, you put the direction that your players needs to look.
```yml
language: en
commands:
  cmd1:
    name: the overworld
    command: overworld
    permission: none
    world: world
    x: 0.0
    y: 80.0
    z: 0.0
    yaw: 0.0
    pitch: 0.0
  cmd2:
    name: the nether
    command: nether
    permission: none
    world: world_nether
    x: 0.0
    y: 80.0
    z: 0.0
    yaw: 0.0
    pitch: 0.0
  cmd3:
    name: the end
    command: end
    permission: none
    world: world_the_end
    x: 0.0
    y: 80.0
    z: 0.0
    yaw: 0.0
    pitch: 0.0
   ```

![](https://cdn.discordapp.com/emojis/757359922416451675.png?v=1)  
Prenons la configuration par défaut par exemple.
* Dans **language**, vous choisissez la langue du plugin et des messages (seulement FR et EN pour le moment).
* Dans **commands**, vous mettez vos commandes. Pour chaque command ajoutée, il faut ajouter 1. Ici nous avons cmd1, cmd2, cmd3...
* Dans **name**, vous mettez le nom du monde qui sera dans le message de téléportation.
* Dans **command**, vous mettez la command que vos joueurs vont executer.
* Dans **permission**, Vous mettez la permission requise pour executer la commande. Utilisez "none" pour rendre la commande executable pour tout le monde.
* Dans **world**, vous mettez le nom du monde dans lequel vos joueurs devrons être téléportés.
* Dans **x**, **y**, **z**, vous mettez les coordonnés où vos joueurs devrons être téléportés.
* Dans **yaw** et **pitch**, vous mettez la direction dans laquelle vos joueurs devrons regarder.
```yml
language: fr
commands:
  cmd1:
    name: l'overworld
    command: overworld
    permission: none
    world: world
    x: 0.0
    y: 80.0
    z: 0.0
    yaw: 0.0
    pitch: 0.0
  cmd2:
    name: le nether
    command: nether
    permission: none
    world: world_nether
    x: 0.0
    y: 80.0
    z: 0.0
    yaw: 0.0
    pitch: 0.0
  cmd3:
    name: l'end
    command: end
    permission: none
    world: world_the_end
    x: 0.0
    y: 80.0
    z: 0.0
    yaw: 0.0
    pitch: 0.0
   ```

### messages.yml
![](https://cdn.discordapp.com/emojis/757360038770900993.png?v=1)  
There is the default message configuration for example.  
If you chose "FR" language, you will have the message of the "messages_fr" category. And if you chose EN, you will obviously have the messages of the category "messages_en".
* **successtp** is the message displayed when a command have been executed correctly and the player have been teleported successfully.
* **alreadyinworld** is the message displayed when the player is already in the world of the command.
* **nopermission** is the message displayed if the player don't have the permission to teleport as you may set.
```yml
messages_fr:
  successtp: §aVous avez été téléporté dans %s !
  alreadyinworld: §cErreur ! Vous êtes déjà dans %s.
  nopermission: §cErreur ! Vous n'avez pas la permission d'executer cette commande.
messages_en:
  successtp: §aYou've been warped into %s !
  alreadyinworld: §cError ! You're already in %s.
  nopermission: §cError ! You don't have the permission to use this command.
```

![](https://cdn.discordapp.com/emojis/757359922416451675.png?v=1)  
Prenons la configuration des messages par défaut comme exemple.  
Si vous choisissez la langue FR, vous aurez les messages de la catégorie "message_fr". Et si vous avez choisi la langue EN, vous aurez évidemment les messages de la catégorie "messages_en".
* **successtp** est le message affiché lorsqu'une commande a été exécuté correctement et que le joueur a été correctement téléporté.
* **alreadyinworld** est le message affiché lorsque le joueur est déjà sur le monde de la commande.
* **nopermission** est le message affiché lorque le joueur n'a pas la permission que vous avez défini.
```yml
messages_fr:
  successtp: §aVous avez été téléporté dans %s !
  alreadyinworld: §cErreur ! Vous êtes déjà dans %s.
  nopermission: §cErreur ! Vous n'avez pas la permission d'executer cette commande.
messages_en:
  successtp: §aYou've been warped into %s !
  alreadyinworld: §cError ! You're already in %s.
  nopermission: §cError ! You don't have the permission to use this command.
```
---------
## The project / Le projet

![](https://cdn.discordapp.com/emojis/757360038770900993.png?v=1)

If you want to contribute, make a pull request and I will check it :smile:.  
Here is the link to the SpigotMC page : https://worldtp.thebatteur.fr/  

![](https://cdn.discordapp.com/emojis/757359922416451675.png?v=1)  
Si vous voulez contribuer, faites une demande et je regarderai ça :smile:.  
Voici le lien vers la page SpigotMC : https://worldtp.thebatteur.fr/
