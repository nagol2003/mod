package nagol2003.MRE;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class MRECrop extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		this.iconArray = new IIcon[4];
		
		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = iconregister.registerIcon(Main.cropCornPlant + ":" + this.getUnlocalizedName().substring(5) + (i + 1));
			
		}
		
	}
	
	public IIcon getIcon(int side, int metadata) {
		if (metadata < 7) {
			if (metadata == 6) {
				metadata = 5;
			}
			
			return this.iconArray[metadata >> 1];
		}
		
		return this.iconArray[3];
		
	}
	
	public int quantityDropped (Random random) {
		return 5;
		
	}
	
	protected Item func_149866_i() {
		return MRE.CornSeeds;
	}
	
	protected Item func149865_P() {
		return MRE.CornSeeds;
	}
	
}

//return MRE.CornSeeds;