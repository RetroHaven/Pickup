# Pickup
The Pickup plugin allows players to mine otherwise unobtainable blocks, such as:
<details>
<summary>Block List</summary>
Grass
<br>
Glass
<br>
Glowstone
<br>
Ice
<br>  
Snow Block
<br>
Snow
<br> 
Cobblestone Stairs
<br>
Wood Stairs
<br>
Clay Block
<br>
Cake
<br>
</details>

If you have a suggestion on what should be added to this plugin then let me know! open a issue with the **Suggestion** tag or make a pull request and I will take a look at it.

# Spawner Commands
`/setspawner <mob>`

`/spawnerchange <mob> <player> (Groups with the spawnerpickup.setspawner.others permission can do this command)`

# Spawner Permissions
`spawnerpickup.use (Use for the mining of the spawner)`

`spawnerpickup.setspawner (Use for the /setspawner command)`

`spawnerpickup.setspawner.others (Admin permission to change the players mobspawner if there has been a change by a cheeky player)`

# Compiling
Compiling is done via maven. To compile a JAR, cd into the directory and run the following command:

`mvn clean package`

You should now have a runnable JAR inside the /target folder
