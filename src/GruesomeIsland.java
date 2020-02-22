// Main driver/player side for GruesomeIsland

import java.lang.Object;
import java.lang.String;
import java.util.*;

public class World {

    // Create a 26x26 array of chunks
    public static Matrix chunks = new Matrix(26, 26, Chunk());
    
    public class Chunk(Biome biome) {
        public static Biome biome = biome;
        public int elevation;

    }
    
    public class Biome(int biomeSelection) {
        public int defaultMod = 5;
        public int soundMod = defaultMod;
        public int tracksMod = defaultMod;
        public int coverMod = defaultMod;
        public String biomeName;

        public int fixedMod = 2;

        // Biome switching
        public void biomeSelect() {
            switch(biomeSelection) {
                case 1: // winter
                    biomeName = "Winter";
                    soundMod -= fixedMod;
                    tracksMod +=  fixedMod;
                    cover -= fixedMod;
                case 2: // desert
                    biomeName = "Desert";
                    tracksMod +=  fixedMod;
                    cover -= fixedMod;
                case 3: // forest
                    biomeName = "Forest";
                    soundMod -= fixedMod;
                    cover += fixedMod;
                case 4:
                    biomeName = "City";
                    soundMod += fixedMod;
                    tracksMod -=  fixedMod;
                    cover += fixedMod;
                default:
                    biomeName = "Forest (default)";
                    soundMod -= fixedMod;
                    cover += fixedMod;
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
        public String biomeName() {
            return biomeName;
        }

    }


}





