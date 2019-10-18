package bl4ckscor3.mod.woodenletterblocks.gen.asset;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import bl4ckscor3.mod.woodenletterblocks.Type;
import bl4ckscor3.mod.woodenletterblocks.WoodenLetterBlocks;

public class BlockStateGenerator
{
	public static void generate()
	{
		Type.forEach((color, wood, letter) -> {
			String w = wood.name().toLowerCase();
			String l = letter.name().toLowerCase();
			String c = color.name().toLowerCase();
			String name = c + "_" + w + "_" + l;
			List<String> content = new ArrayList<>();

			content.add("{");
			content.add("	\"variants\": {");
			content.add("        \"facing=south\": { \"model\": \"" + WoodenLetterBlocks.MODID + ":block/" + c + "_" + w + "_" + l + "\"},");
			content.add("        \"facing=west\": { \"model\": \"" + WoodenLetterBlocks.MODID + ":block/" + c + "_" + w + "_" + l + "\", \"y\": 90 },");
			content.add("        \"facing=north\": { \"model\": \"" + WoodenLetterBlocks.MODID + ":block/" + c + "_" + w + "_" + l + "\", \"y\": 180 },");
			content.add("        \"facing=east\": { \"model\": \"" + WoodenLetterBlocks.MODID + ":block/" + c + "_" + w + "_" + l + "\", \"y\": 270 }");
			content.add("	}");
			content.add("}");

			try
			{
				FileUtils.writeLines(new File(System.getProperty("user.home") + "/Downloads/generated/assets/" + WoodenLetterBlocks.MODID + "/blockstates/" + name + ".json"), content);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		});
	}
}