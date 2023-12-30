# Set Max Health

> [!NOTE]
> Currently, the config.yml in the SetMaxHealth folder that is automatically generated does not server any purpose, and any changes to it will not have an effect. It is planned to be functional in the next update.

## Information:
SetMaxHealth is a spigot plugin that allows you to set the maximum health value of a player or all online players.
Current Version: 1.1
Minecraft Versions: 1.19, 1.20 (Should work for older versions as well)
*Please do report any bugs and issues you face, and any contributions would be greatly appreciated*

## Installation:
Requirement: Spigot or Paper Server
**Installation Steps:**
1. Download the release of the plugin or build the project form source yourself
2. Drag the .jar file into the plugins folder once server is initialized
3. Enjoy :)

## Commands:
`/setmaxhealth <player> <healthPoints>`
sets the max health for the specified player (please note that 1 health point is half a heart, so for example 10 hearts will be 20 health points)

`/setmaxhealth all <healthPoints>`
sets the max health for all online players

## Permissions:
`setmaxhealth.set` - allows user/group to set another player's or their own max health

## Build From Source:
By cloning the repository, the maven file that is needed to build the project
For intellij, click on the maven tab on the right and double click Lifecycle > package, and it will be built!

## Extra Information
The updates to this plugin will not be consistent as this is a side project, please do feel free to add any functions you believe is useful, thanks for using SetMaxHealth!
