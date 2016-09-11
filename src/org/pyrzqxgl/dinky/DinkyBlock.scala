package org.pyrzqxgl.dinky

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

class DinkyBlock extends Block(Material.WOOD) with IInitializer {
  this.setRegistryName("dinkyBlock")
  this.setUnlocalizedName("dinkyBlock")
  this.setCreativeTab(CreativeTabs.MISC)
}