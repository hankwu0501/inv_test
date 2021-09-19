package com.gmail.hankwu0501.command

import com.gmail.hankwu0501.testinv.ExampleInventory
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Menu :CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        ExampleInventory().open(sender as Player?)
        return true
    }

}