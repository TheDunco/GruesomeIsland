package src;// Main driver/player side for GruesomeIsland

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Random;

// a singleton class of the world, access with World.getInstance(int worldSize)
class World
{
    public Chunk[][] chunks;
    public int worldSize = 10;

    private static World world_instance = null;

    public World(int worldSize) {
        if(world_instance == null) {


            this.worldSize = worldSize;
            this.chunks = new Chunk[worldSize][worldSize]; // main world matrix

            Random rnd = new Random();

            // populate matrix with random biome chunks
            for (int i = 0; i < worldSize; i++) {
                for (int j = 0; j < worldSize; j++) {
                    try {
                        // make a new chunk with random biome, elevation, and pass through size
                        this.chunks[i][j] = new Chunk(rnd.nextInt(4), rnd.nextInt(3), worldSize, i, j);
                    } catch (Exception e) {
                        System.out.print("\nexception:" + " i=" + i + " j=" + j);
                    }
                }
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

                    System.out.print(this.chunks[i][j].getBiome().getBiomeName() + this.chunks[i][j].getElevation() + " ");
                }
                catch (Exception e) { System.out.print("Exception"); }
            }
            System.out.println();
        }
    }
    // string of the sounds from the various locations around the map
    // for the user end

    public Chunk[][] getMatrix()
    {
        return chunks;
    }

    public int getWorldSize() { return this.worldSize; }

    public static World getInstance(int worldSize) {
        if (world_instance == null)
            world_instance = new World(worldSize);

        return world_instance;
    }

    // move a player from one chunk into a new one
    public boolean movePlayer(Player player, String direction) {
        Chunk currentLoc = player.getLocation();
        int[] nextChunkLoc = currentLoc.getAdjacentChunk(direction);

        if(nextChunkLoc[2] == -1) {
            return true;
        }
        currentLoc.removePlayer(player);
        chunks[nextChunkLoc[0]][nextChunkLoc[1]].addPlayer(player);
        return false;
    }

    // Will return a string with a cardinal direction if seen player is in range of looker player
    public String sightLine(Player looker, Player seen, int range) {
        // self chunk
        Chunk currentLoc = looker.getLocation();
        if(currentLoc.inRange(looker, seen, range)) {
            return "SELF";
        }

        // north
        int[] lookingChunkIndex = currentLoc.getAdjacentChunk("North");
        Chunk lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "NORTH";
        }

        // east
        lookingChunkIndex = currentLoc.getAdjacentChunk("East");
        lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "EAST";
        }

        // south
        lookingChunkIndex = currentLoc.getAdjacentChunk("South");
        lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "SOUTH";
        }

        // west
        lookingChunkIndex = currentLoc.getAdjacentChunk("West");
        lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "WEST";
        }

        return "NONE";
    }

    public String seenBiomes(Chunk currentLoc) {
        String ret = "You are currently in a " + currentLoc.getBiomeName();

        // switch to looking north
        int[] lookingLocIndex = currentLoc.getAdjacentChunk("NORTH");
        Chunk lookingLoc = chunks[lookingLocIndex[0]][lookingLocIndex[1]];
        ret += "To your north is a " + lookingLoc.getBiomeName() + "\n";

        // switch to looking east
        lookingLocIndex = currentLoc.getAdjacentChunk("EAST");
        lookingLoc = chunks[lookingLocIndex[0]][lookingLocIndex[1]];
        ret += "To your east is a " + lookingLoc.getBiomeName() + "\n";

        // switch to looking south
        lookingLocIndex = currentLoc.getAdjacentChunk("SOUTH");
        lookingLoc = chunks[lookingLocIndex[0]][lookingLocIndex[1]];
        ret += "To your south is a " + lookingLoc.getBiomeName() + "\n";

        // switch to looking west
        lookingLocIndex = currentLoc.getAdjacentChunk("WEST");
        lookingLoc = chunks[lookingLocIndex[0]][lookingLocIndex[1]];
        ret += "To your west is a " + lookingLoc.getBiomeName() + "\n";

        return ret;
    }
}





