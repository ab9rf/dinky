/*
 * Copyright (c) Kelly Kinkade (ab9rf) 2016
 * https://github.com/ab9rf/Dinky
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://....
 */

package org.pyrzqxgl.dinky

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.event.world.BlockEvent.BreakEvent
import net.minecraft.util.text.TextComponentString
import net.minecraft.util.text.TextFormatting
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraft.item.ItemBlock
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.client.Minecraft
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.Mod.Instance
import net.minecraftforge.fml.relauncher.Side


@Mod(modid = Dinky.modId, acceptedMinecraftVersions = "[1.10.2]", version = Dinky.version, name = "DinkyMod", modLanguage = "scala")
object Dinky {
 
  final val version = "DINKY_VER"
  final val modId = "Dinky"
  
  @Instance(modId)
  var instance = this
  
  @SidedProxy (clientSide = "org.pyrzqxgl.dinky.ClientProxy", serverSide = "org.pyrzqxgl.dinky.ServerProxy")
  var proxy: CommonProxy = null
  
  @EventHandler
  def preInit(e: FMLInitializationEvent) {
    Blocks.preInit()
    proxy.preInit()
  }
  
  @EventHandler 
  def init(e: FMLInitializationEvent) {
    Blocks.init()
  }
    
  
}

trait IInitializer {
  def init() { }
  def preInit() { }
}