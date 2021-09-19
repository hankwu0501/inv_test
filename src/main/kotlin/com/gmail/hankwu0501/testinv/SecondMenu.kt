package com.gmail.hankwu0501.testinv

import com.gmail.hankwu0501.invmaker.FastInv
import com.gmail.hankwu0501.invmaker.FastInvManager
import org.bukkit.Material
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class SecondMenu :FastInv(45,"測試2"){
    init{
        setItem(
            22, ItemStack(Material.DIAMOND)
        ){e :InventoryClickEvent ->
            e.whoClicked.sendMessage("10%")
        }
    }
}