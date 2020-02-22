package src;// Main driver/player side for GruesomeIsland

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
                    this.chunks[i][j] = new Chunk(rnd.nextInt(4), rnd.nextInt(3), worldSize, i, j);
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

                    System.out.print(this.chunks[i][j].getBiome().getBiomeName() + 
                    this.chunks[i][j].getElevation() + " ");
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

    // move a player from one chunk into a new one
    public void movePlayer(Player player, String direction) {
        Chunk currentLoc = Player.getLocation();
        int[] nextChunkLoc = currentLoc.getAdjacentChunk(direction);
        currentLoc.removePlayer(player);
        chunks[nextChunkLoc[0]][nextChunkLoc[1]].addPlayer(player);
    }

    // Will return a string with a cardinal direction if seen player is in range of looker player
    public String sightLine(Player looker, Player seen, int range) {
        // self chunk
        Chunk currentLoc = Player.getLocation();
        if(currentLoc.inRange(looker, seen, range)) {
            return "self";
        }

        // north
        int[] lookingChunkIndex = currentLoc.getAdjacentChunk("North");
        Chunk lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "North";
        }

        // east
        lookingChunkIndex = currentLoc.getAdjacentChunk("East");
        lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "East";
        }

        // south
        lookingChunkIndex = currentLoc.getAdjacentChunk("South");
        lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "South";
        }

        // west
        lookingChunkIndex = currentLoc.getAdjacentChunk("West");
        lookingChunk = chunks[lookingChunkIndex[0]][lookingChunkIndex[1]];
        if(lookingChunk.inRange(looker, seen, range)) {
            return "West";
        }

        return "none";
    }

}





