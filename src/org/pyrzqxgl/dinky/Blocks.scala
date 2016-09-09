package org.pyrzqxgl.dinky

import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraft.item.ItemBlock
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item

object Blocks {
  final val dinkyBlock = new dinkyBlock()
  final val farmItemBlock = new ItemBlock(dinkyBlock)
  
  def registerBlocks() = {
    GameRegistry.register(dinkyBlock.setRegistryName("dinkyBlock"))
    GameRegistry.register(farmItemBlock.setRegistryName(dinkyBlock.getRegistryName()))
  }
  
  def registerModels() = {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				  .register(farmItemBlock, 0, new ModelResourceLocation(farmItemBlock.getRegistryName.toString(), "inventory"))
  }
}