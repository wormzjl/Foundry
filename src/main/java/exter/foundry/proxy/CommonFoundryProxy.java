package exter.foundry.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import exter.foundry.container.ContainerAlloyFurnace;
import exter.foundry.container.ContainerAlloyMixer;
import exter.foundry.container.ContainerMetalCaster;
import exter.foundry.container.ContainerInductionCrucibleFurnace;
import exter.foundry.container.ContainerMetalInfuser;
import exter.foundry.gui.GuiAlloyFurnace;
import exter.foundry.gui.GuiAlloyMixer;
import exter.foundry.gui.GuiMetalCaster;
import exter.foundry.gui.GuiInductionCrucibleFurnace;
import exter.foundry.gui.GuiMetalInfuser;
import exter.foundry.tileentity.TileEntityAlloyFurnace;
import exter.foundry.tileentity.TileEntityAlloyMixer;
import exter.foundry.tileentity.TileEntityMetalCaster;
import exter.foundry.tileentity.TileEntityInductionCrucibleFurnace;
import exter.foundry.tileentity.TileEntityMetalInfuser;

public class CommonFoundryProxy implements IGuiHandler
{
  static public final int GUI_ICF = 0;
  static public final int GUI_CASTER = 1;
  static public final int GUI_ALLOYMIXER = 2;
  static public final int GUI_INFUSER = 3;
  static public final int GUI_ALLOYFURNACE = 4;
  
  public void Init()
  {

  }

  @Override
  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
    switch(ID)
    {
      case GUI_ICF:
        return new ContainerInductionCrucibleFurnace((TileEntityInductionCrucibleFurnace)world.getTileEntity(x, y, z),player.inventory);
      case GUI_CASTER:
        return new ContainerMetalCaster((TileEntityMetalCaster)world.getTileEntity(x, y, z),player.inventory);
      case GUI_ALLOYMIXER:
        return new ContainerAlloyMixer((TileEntityAlloyMixer)world.getTileEntity(x, y, z),player.inventory);
      case GUI_INFUSER:
        return new ContainerMetalInfuser((TileEntityMetalInfuser)world.getTileEntity(x, y, z),player.inventory);
      case GUI_ALLOYFURNACE:
        return new ContainerAlloyFurnace((TileEntityAlloyFurnace)world.getTileEntity(x, y, z),player.inventory);
    }
    return null;
  }

  @Override
  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
    switch(ID)
    {
      case GUI_ICF:
      {
        TileEntityInductionCrucibleFurnace te = (TileEntityInductionCrucibleFurnace)world.getTileEntity(x, y, z);
        return new GuiInductionCrucibleFurnace(te,player.inventory);
      }
      case GUI_CASTER:
      {
        TileEntityMetalCaster te = (TileEntityMetalCaster)world.getTileEntity(x, y, z);
        return new GuiMetalCaster(te,player.inventory);
      }
      case GUI_ALLOYMIXER:
      {
        TileEntityAlloyMixer te = (TileEntityAlloyMixer)world.getTileEntity(x, y, z);
        return new GuiAlloyMixer(te,player.inventory);
      }
      case GUI_INFUSER:
      {
        TileEntityMetalInfuser te = (TileEntityMetalInfuser)world.getTileEntity(x, y, z);
        return new GuiMetalInfuser(te,player.inventory);
      }
      case GUI_ALLOYFURNACE:
      {
        TileEntityAlloyFurnace te = (TileEntityAlloyFurnace)world.getTileEntity(x, y, z);
        return new GuiAlloyFurnace(te,player.inventory);
      }
    } 
    return null;
  }
}
