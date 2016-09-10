package org.pyrzqxgl.dinky

import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraft.item.ItemBlock
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.block.Block
import net.minecraft.init.Items
import net.minecraft.block.material.Material

object Blocks {
  final val dinkyBlock = new DinkyBlock()
  
  final val planterBlock = new PlanterBlock()
  
  def preInit() = {
    def registerBlock(block: Block with IInitializer, name: String) = {
      block.preInit()
      GameRegistry.register(block.setRegistryName(name))
      GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()))
    }

    registerBlock(dinkyBlock, "dinkyBlock")
    registerBlock(planterBlock, "planterBlock")
  }
  
  def registerModels () = {
    def registerModel(block: net.minecraft.block.Block) = {
      val itemBlock = Item.getItemFromBlock(block)
      Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	        .register(itemBlock, 0, new ModelResourceLocation(itemBlock.getRegistryName.toString(), "inventory"))
    }

    registerModel(dinkyBlock)
    registerModel(planterBlock)
  }
  
  def init() = {
    dinkyBlock.init()
    planterBlock.init()
  }
}