// Main driver/player side for GruesomeIsland

import java.lang.Object;
import java.lang.String;
import java.util.*;

public class World() {

    World(int worldSize) {
        this.worldSize = worldSize;
    }

    
    
    public class Chunk(Biome biome) {
        public static Biome biome;
        public int elevation;

    }
    
    // Create a 26x26 array of chunks
    public static Chunk[][] chunks = new Chunk[worldSize][worldSize];
    
    private populateChunks() {
        Random rand = new Random();
        for (i = 0; i < worldSize; i++) {
            for (j = 0; j < worldSize; j++ ) {
                chunks[i][j] = new Chunk(rand.nextInt(4)); // 4 biomes so choose a random one
            }
        }
    }

    public abstract class Biome(int biomeSelection) {
        public int defaultMod = 5;
        public int soundMod = defaultMod;
        public int tracksMod = defaultMod;
        public int coverMod = defaultMod;
        public String biomeName;

        public int fixedMod = 2;

        // Biome switching
        public void biomeSelect() {
            switch(biomeSelection) {
                case 0: // winter
                    biomeName = "Winter";
                    soundMod -= fixedMod;
                    tracksMod +=  fixedMod;
                    cover -= fixedMod;
                case 1: // desert
                    biomeName = "Desert";
                    tracksMod +=  fixedMod;
                    cover -= fixedMod;
                case 2: // forest
                    biomeName = "Forest";
                    soundMod -= fixedMod;
                    cover += fixedMod;
                case 3:
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





