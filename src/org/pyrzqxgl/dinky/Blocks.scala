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
  final val blocks = Iterable(new DinkyBlock(), new DinkyBlockFaces(), new PlanterBlock())
  
  def preInit() = {
    def registerBlock(block: Block with IInitializer) = {
      block.preInit()
      GameRegistry.register(block)
      GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()))
    }

    blocks.foreach (registerBlock)
  }
  
  def registerModels () = {
    def registerModel(block: net.minecraft.block.Block) = {
      val itemBlock = Item.getItemFromBlock(block)
      Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	        .register(itemBlock, 0, new ModelResourceLocation(itemBlock.getRegistryName.toString(), "inventory"))
    }
    
    blocks.foreach (registerModel)
  }
  
  def init() = {
    blocks.foreach(_.init())
  }
}