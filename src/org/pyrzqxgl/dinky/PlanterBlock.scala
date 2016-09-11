package org.pyrzqxgl.dinky

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraft.block.ITileEntityProvider
import net.minecraft.util.math.BlockPos
import net.minecraft.block.state.IBlockState
import net.minecraft.block.BlockContainer
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraft.util.ITickable
import net.minecraft.init.{Blocks => MCBlocks}
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.play.server.SPacketUpdateTileEntity
import net.minecraft.network.NetworkManager

class PlanterBlock extends BlockContainer(Material.WOOD) with IInitializer {
  this.setRegistryName("planterBlock")
  this.setUnlocalizedName("planterBlock")
  this.setCreativeTab(CreativeTabs.MISC)
  
  override def preInit() {
    GameRegistry.registerTileEntity( classOf[PlanterTileEntity], "planterTileEntity")
  }
  
  override def createNewTileEntity (world: World, var2: Int) = {
    new PlanterTileEntity() 
    }
    
  override def breakBlock(world: World, pos: BlockPos, state: IBlockState) {
    super.breakBlock(world, pos, state)     
  }

	override def getRenderType(state: IBlockState) = { EnumBlockRenderType.MODEL }
}

class PlanterTileEntity extends TileEntity with ITickable {
  override def update () {
    val pos = getPos()
    val dirtPos = new BlockPos( pos.getX(), pos.getY() + 1, pos.getZ() ) 
    val dirtBlockState = worldObj.getBlockState(dirtPos)
    val dirtBlock = dirtBlockState.getBlock()

    val plantPos = new BlockPos( pos.getX(), pos.getY() + 2, pos.getZ() )
    val plantBlockState = worldObj.getBlockState(plantPos)
    val plantBlock = plantBlockState.getBlock()

    if (dirtBlock == MCBlocks.DIRT) {
      worldObj.setBlockState(dirtPos, MCBlocks.FARMLAND.getDefaultState())
    }
    
    if (dirtBlock == MCBlocks.FARMLAND && plantBlock == MCBlocks.AIR) {
			worldObj.setBlockState(plantPos, MCBlocks.WHEAT.getDefaultState())
		}
	}
  
  override def writeToNBT(tag: NBTTagCompound) = {
    super.writeToNBT(tag)
    // serialize state here
    tag
  }
  
  override def readFromNBT(tag: NBTTagCompound) {
    super.readFromNBT(tag)
    // deserialize state here
  }
  
  override def getUpdateTag() = {
    super.getUpdateTag()
  }
  
  override def getUpdatePacket(): SPacketUpdateTileEntity = {
    val tagCompound = new NBTTagCompound()
    writeToNBT(tagCompound)
    return new SPacketUpdateTileEntity(this.pos, 1, tagCompound)
  }
  
  override def onDataPacket(net: NetworkManager, pkt: SPacketUpdateTileEntity) {
    val tag = pkt.getNbtCompound()
    readFromNBT(tag)
  }
  
}
