package com.gmail.hankwu0501

import com.gmail.hankwu0501.invmaker.FastInvManager
import com.gmail.hankwu0501.command.Menu
import org.bukkit.plugin.java.JavaPlugin

class Inv :JavaPlugin(){
    override fun onEnable() {
        FastInvManager.register(this)
        getCommand("menu")?.setExecutor(Menu)
    }

    override fun onDisable() {
    }
}