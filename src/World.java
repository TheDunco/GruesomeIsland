// Main driver/player side for GruesomeIsland

import java.util.Random;

class World
{
    public Chunk[][] chunks;
    int worldSize;

    public World(int worldSize) {
        this.worldSize = worldSize;
        this.chunks = new Chunk[worldSize][worldSize]; // main world matrix

        Random rnd = new Random();
        
        // populate matrix with random biome chunks
        for (int i = 0; i < worldSize; i++)
        {
            for (int j = 0; j < worldSize; j++)
            {
                try {
                    // make a new chunk with random biome, elevation, and pass through size
                    this.chunks[i][j] = new Chunk(rnd.nextInt(3), rnd.nextInt(3), worldSize);
                }
                catch(Exception e) { System.out.print("\nexception:" + " i=" + i + " j=" + j);}
            }
        }
    } 

    public void showMatrix() // for debugging
    {
        for (int i = 0; i < worldSize; i++)
        {
            for (int j = 0; j < worldSize; j++)
            {
                try {

                    System.out.print(this.chunks[i][j].getBiome().getBiomeName() + " ");
                }
                catch (Exception e) { System.out.print("Exception"); }
            }
            System.out.println();
        }
    }
}





