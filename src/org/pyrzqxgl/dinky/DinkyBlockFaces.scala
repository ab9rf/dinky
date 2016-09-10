package org.pyrzqxgl.dinky

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

class DinkyBlockFaces extends Block(Material.WOOD) with IInitializer {
  this.setUnlocalizedName("dinkyBlockFaces")
  this.setCreativeTab(CreativeTabs.MISC)
}