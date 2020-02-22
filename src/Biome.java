
import java.lang.String;
import java.util.*;

public class Biome {

    public int defaultMod = 5;

    public int soundMod = defaultMod;
    public int tracksMod = defaultMod;
    public int coverMod = defaultMod;
    public String biomeName;

    public int fixedMod = 2;

    public Biome(int biomeSelection) {

        // Biome switching
        switch(biomeSelection) {
            case 0: // winter
                biomeName = "Winter";
                soundMod -= fixedMod;
                tracksMod += fixedMod;
                coverMod -= fixedMod;
                break;
            case 1: // desert
                biomeName = "Desert";
                tracksMod += fixedMod;
                coverMod -= fixedMod;
                break;
            case 2: // forest
                biomeName = "Forest";
                soundMod -= fixedMod;
                coverMod += fixedMod;
                break;
            case 3:
                biomeName = "City";
                soundMod += fixedMod;
                tracksMod -= fixedMod;
                coverMod += fixedMod;
                break;
            default:
                biomeName = "Forest (default)";
                soundMod -= fixedMod;
                coverMod += fixedMod;
                break;
        }
    }

    public int getSoundMod() {
        return soundMod;
    }

    public int getTracksMod() {
        return tracksMod;
    }

    public int coverMod() {
        return coverMod;
    }

    public String getBiomeName() {
        return biomeName;
    }
}