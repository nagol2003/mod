package nagol2003.MRE;

//helpful stuff: System.out.println(itemGrain); for error and items for Items list

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemStack;

@Mod(modid = "MRE", name = "MRE Mod", version = "1.0")
public class Main {
	
	//Food items
	public static Item itemGrain;
	public static Item itemMeat;
	public static Item itemMRE;
	
	//Military decorations
	public static Block blockShell;
	
	//Crops
	public static Item cropCornSeeds;
	public static Item cropCorn;
	public static Block cropCornPlant;
	
   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
	   //Item/Block init and registering
	   //Config handling
	   
	   
	   //Military Decoration
	   blockShell = new BlockShell(Material.cloth).setBlockName("BlockShell").setBlockTextureName("MRE:Shell").setCreativeTab(tabMREMod);
	  
	   GameRegistry.registerBlock(blockShell, blockShell.getUnlocalizedName().substring(5));
	   
	   System.out.println(blockShell.getUnlocalizedName().substring(5));
	   
	   
	   //Food items
	   itemGrain = new ItemGrain().setUnlocalizedName("ItemGrain").setTextureName("MRE:Grain").setCreativeTab(tabMREMod); //item.item.Grain
	   itemMeat = new ItemMeat().setUnlocalizedName("ItemMeat").setTextureName("MRE:Meat").setCreativeTab(tabMREMod);
	   itemMRE = new ItemFood(20, 1.0F, false).setUnlocalizedName("ItemMRE").setTextureName("MRE:MRE").setCreativeTab(tabMREMod);
	   
	   GameRegistry.registerItem(itemGrain, itemGrain.getUnlocalizedName().substring(5));
	   GameRegistry.registerItem(itemMeat, itemMeat.getUnlocalizedName().substring(5));
	   GameRegistry.registerItem(itemMRE, itemMRE.getUnlocalizedName().substring(5));
	   
	   // x * 0,5 = hunger
	   
	   
	   //Crops
	   cropCornPlant = new MRECrop().setBlockName("CornPlant");
	   cropCornSeeds = new ItemSeeds(cropCornPlant, Blocks.farmland).setUnlocalizedName("CornSeeds").setTextureName("MRE:cornseeds").setCreativeTab(tabMREMod);
	   cropCorn = new ItemFood(4, 0.5F, false).setUnlocalizedName("Corn").setTextureName("MRE:corn").setCreativeTab(tabMREMod);
	 
	   GameRegistry.registerItem(cropCornSeeds, "CornSeed");
	   GameRegistry.registerItem(cropCorn, "Corn");
	   GameRegistry.registerBlock(cropCornPlant, "CornPlant");
	   
   }
   
   
   
   @EventHandler
   public void init(FMLInitializationEvent event) {
	   //Proxy TIleENtity, entity, GUI and Packet Registering
	   GameRegistry.addRecipe(new ItemStack(itemMeat, 3), new Object[]{"SSS","S S","SSS", 'S', Items.cooked_beef});
	   GameRegistry.addRecipe(new ItemStack(itemGrain, 3), new Object[]{"WWW"," W "," W ", 'W', Items.wheat}); 
	   GameRegistry.addRecipe(new ItemStack(itemMRE, 1), new Object[]{"PGP","MMM","PGP", 'P', Items.paper, 'G', itemGrain, 'M', itemMeat});
	   GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 4), new Object[]{"   ","OOO","FFF", 'O', Items.coal, 'F', Items.flint});
   }
   
   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {   
	   
   }
   
   public static CreativeTabs tabMREMod = new CreativeTabs("tabMREMod"){
	   @Override
	   public Item getTabIconItem(){
		   return new ItemStack(itemGrain).getItem();
	   }
   };
   
}
