package com.gmail.hankwu0501.testinv

import com.gmail.hankwu0501.invmaker.FastInv
import com.gmail.hankwu0501.invmaker.ItemBuilder
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.inventory.ItemStack


class ExampleInventory : FastInv(45, ChatColor.GOLD.toString() + "Example inventory") {
    private var preventClose = false
    public override fun onOpen(event: InventoryOpenEvent) {
        event.player.sendMessage(ChatColor.GOLD.toString() + "You opened the inventory")
    }

    public override fun onClose(event: InventoryCloseEvent) {
        event.player.sendMessage(ChatColor.GOLD.toString() + "You closed the inventory")
    }

    public override fun onClick(event: InventoryClickEvent) {
        // do something
    }

    init {

        // Just add a random item
        setItem(
            22, ItemStack(Material.IRON_SWORD)
        ) { e: InventoryClickEvent ->
            e.whoClicked.sendMessage("You clicked on the sword")
            SecondMenu().open(e.whoClicked as Player?)
        }

        // Add some blocks to the borders
        setItems(borders, ItemBuilder(Material.LAPIS_BLOCK).name(" ").build())

        // Add a simple item to prevent closing the inventory
        setItem(
            34, ItemBuilder(Material.BARRIER).name(ChatColor.RED.toString() + "Prevent close").build()
        ) { e: InventoryClickEvent? ->
            preventClose = !preventClose
        }

        // Prevent from closing when preventClose is to true
        setCloseFilter { p: Player? -> preventClose }
    }
}
