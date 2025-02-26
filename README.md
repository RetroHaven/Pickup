# Spawner Pickup
This plugin allows a player mine a monster spawner with a golden pickaxe and be able to set what the spawners spawn.

# Commands
/setspawner <mob>
/spawnerchange <mob> <player> (Groups with the spawnerpickup.setspawner.others permission can do this command)

# Permissions
spawnerpickup.use (Use for the mining of the spawner)

spawnerpickup.setspawner (Use for the /setspawner command)

spawnerpickup.setspawner.others (Admin permission to change the players mobspawner if there has been a change by a cheeky player)

# Compiling
Compiling is done via maven. To compile a JAR, cd into the Project Poseidon directory and run the following command:

`mvn clean package`

You should now have a runnable JAR inside the /target folder
