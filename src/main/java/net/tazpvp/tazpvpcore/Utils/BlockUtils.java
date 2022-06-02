package net.tazpvp.tazpvpcore.Utils;

import org.bukkit.block.Block;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class BlockUtils {
    public static boolean isPlayerPlaced(Block b){
        List<MetadataValue> metaDataValues = b.getMetadata("PlayerPlaced");
        for (MetadataValue metaDataValue : metaDataValues) {
            return metaDataValue.asBoolean();
        }
        return false;
    }
}
