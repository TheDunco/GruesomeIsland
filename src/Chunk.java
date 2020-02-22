import Biome;

public class Chunk(Biome biome) {
    public static Biome biome;
    public int elevation;

    // Create a worldSizexworldSize array of chunks
    public static Chunk[][] chunks = new Chunk[worldSize][worldSize];
        
    private populateChunks() {
        Random rand = new Random();
        for (i = 0; i < worldSize; i++) {
            for (j = 0; j < worldSize; j++ ) {
                chunks[i][j] = new Chunk(rand.nextInt(4)); // 4 biomes so choose a random one
            }
        }
    }
}