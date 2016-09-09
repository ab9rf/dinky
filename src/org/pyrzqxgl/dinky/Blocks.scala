package org.pyrzqxgl.dinky

import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraft.item.ItemBlock
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item

object Blocks {
  final val dinkyBlock = new dinkyBlock()
  final val dinkyItemBlock = new ItemBlock(dinkyBlock)
  
  def registerBlocks() = {
    GameRegistry.register(dinkyBlock.setRegistryName("dinkyBlock"))
    GameRegistry.register(dinkyItemBlock.setRegistryName(dinkyBlock.getRegistryName()))
  }
  
  def registerModels() = {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				  .register(dinkyItemBlock, 0, new ModelResourceLocation(dinkyItemBlock.getRegistryName.toString(), "inventory"))
  }
}