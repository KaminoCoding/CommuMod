package io.cyb3rwarri0r8.commumod.lib.handler;


/*
 *  CommuMod - A Minecraft Modification
 *  Copyright (C) ${YEAR} Cyb3rWarri0r8
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigHandler
{
    public static Configuration configuration;
//    public static Boolean testValue = false;
    public static int IronOreGenAmount;
    public static int DiamondOreGenAmount;
    public static int GoldOreGenAmount;
    public static String friendUserName;
    public static String friendNickName;
    public static String girlfriendUserName;
    public static String girlfriendNickName;
    public static String everyoneElsesNickname;


    public static void init(File configFile)
    {

//        boolean configValue = false;
        if(configuration == null){
            configuration = new Configuration(configFile, true);
            loadConfiguration();
        }
    }


    public static void loadConfiguration() {
    //TODO Flush the configuration file

        IronOreGenAmount = configuration.getInt("Iron Ore Generation Amount", Configuration.CATEGORY_GENERAL, 5, 0, 50, "This will change the amount of Iron Ore spawned into the world. The higher the amount the longer it will take to generate.");
        DiamondOreGenAmount = configuration.getInt("Diamond Ore Generation Amount", Configuration.CATEGORY_GENERAL, 5, 0, 50, "This will change the amount of Diamond Ore spanwned into the world.");
        GoldOreGenAmount = configuration.getInt("Gold Ore Generation Amount", Configuration.CATEGORY_GENERAL, 5, 0, 50, "This will change the amount of Gold Ore spawned into the world.");
        friendUserName = configuration.getString("Friends Username", Configuration.CATEGORY_GENERAL, "", "Enter your friends username for a cool tag added to their name");
        friendNickName = configuration.getString("Friends Nickname", Configuration.CATEGORY_GENERAL, " ", "Enter a title to append to your friends username", "key");
        girlfriendUserName = configuration.getString("Girlfriends Username", Configuration.CATEGORY_GENERAL, "", "Enter your girlfriends username");
        girlfriendNickName = configuration.getString("Girlfriends Nickname", Configuration.CATEGORY_GENERAL, "", "Enter a nickname/title to append to your girlfriends username");
        everyoneElsesNickname = configuration.getString("Title for everyone else", Configuration.CATEGORY_GENERAL, "", "Enter a title for every other player in minecraft universe");
        if (configuration.hasChanged())
        {
            configuration.save();
        }


    }

    /*@SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            loadConfiguration();
        }
    }*/
}
