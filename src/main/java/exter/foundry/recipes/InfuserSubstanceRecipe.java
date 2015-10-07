package exter.foundry.recipes;

import exter.foundry.api.FoundryUtils;
import exter.foundry.api.recipe.IInfuserSubstanceRecipe;
import exter.foundry.api.substance.InfuserSubstance;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Metal Infuser substance recipe manager
 */
public class InfuserSubstanceRecipe implements IInfuserSubstanceRecipe
{
  /**
   * Substance produced.
   */
  public final InfuserSubstance substance;

  /**
   * Item required.
   */
  public final Object item;

  /**
   * Amount of energy needed to extract.
   */
  public final int extract_energy;
  
  @Override
  public Object getInput()
  {
    if(item instanceof ItemStack)
    {
      return ((ItemStack)item).copy();
    }
    return item;
  }
  
  @Override
  public InfuserSubstance getOutput()
  {
    return substance;
  }
  
  @Override
  public int getEnergyNeeded()
  {
    return extract_energy;
  }
  
  public InfuserSubstanceRecipe(InfuserSubstance subs,Object itm, int energy)
  {
    if(!(itm instanceof ItemStack) && !(itm instanceof String) && !(itm instanceof Item) && !(itm instanceof Block))
    {
      throw new IllegalArgumentException("Infuser substance recipe item is not of a valid class.");
    }
    substance = new InfuserSubstance(subs);
    if(itm instanceof ItemStack)
    {
      item = ((ItemStack)itm).copy();
    } else
    {
      item = itm;
    }
    extract_energy = energy;
  }
  
  @Override
  public boolean matchesRecipe(ItemStack item_stack)
  {
    return FoundryUtils.isItemMatch(item_stack, item);
  }
}
