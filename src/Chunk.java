
public class Chunk {
    public Biome biome;
    public int elevation;
    public int worldSize;



    public Chunk(int biomeSelect, int elevation, int worldSize) {
        // Create a worldSizexworldSize array of chunks
        this.worldSize = worldSize;
        this.elevation = elevation;
        this.biome = new Biome(biomeSelect);
    }
    
    public int getElevation()
    {
        return this.elevation;
    }

    public Biome getBiome()
    {
        return this.biome;
    }
}