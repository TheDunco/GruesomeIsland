package src;

import java.util.LinkedList;

public class Chunk 
{
    public Biome biome;
    public int elevation;
    public int worldSize;
    public Sounds chunkSounds = new Sounds();

    public LinkedList<Item> items = new LinkedList<Item>();


    public LinkedList<Player> players = new LinkedList<Player>();

    public int iPos;
    public int jPos;

    public Chunk(int biomeSelect, int elevation, int worldSize, int i, int j) {
        // Create a worldSizexworldSize array of chunks
        this.worldSize = worldSize;
        this.elevation = elevation;
        this.biome = new Biome(biomeSelect);

        this.iPos = i;
        this.jPos = j;
    }
    
    public int getElevation()
    {
        return this.elevation;
    }

    public Biome getBiome()
    {
        return this.biome;
    }

    public int[] getAdjacentChunk(String direction)// throws IllegalStateException
    {
        int[] ret = new int[2];

        // String direction = direction;
        switch(direction) {
            case ("North"):
                if(this.iPos-- < 0) {
                    // out of bounds
                    return new int[]{-1};
                }
                ret[0] = this.iPos--;
                ret[1] = this.jPos;
                return ret;

            case ("East"):
                if(this.jPos++ >= worldSize) {
                    // out of bounds
                    return new int[]{-1};
                }
                ret[0] = this.iPos;
                ret[1] = this.jPos++;
                return ret;
            case ("South"):
                if(this.iPos++ >= worldSize) {
                    // out of bounds
                    return new int[]{-1};
                }
                ret[0] = this.iPos++;
                ret[1] = this.jPos;
                return ret;

            case ("West"):
                if(this.jPos-- < 0) {
                    // out of bounds
                    return new int[]{-1};
                }
                ret[0] = this.iPos;
                ret[1] = this.jPos--;
                return ret;

            default:
                return new int[]{-1, -1};
        }
    }


    public void receiveSounds(Sound next){
        this.chunkSounds.addSound(next);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public LinkedList<Item> getItems() {
        return this.items;
    }

    public String getSounds() {
        return this.chunkSounds.getSoundsString();
    }

    public void addPlayer(Player player)
    {
      this.players.add(player);
    }

    public void removePlayer(Player player)
    {
        this.players.remove(player);
    }

    public void userThrownSounds(String source, int intensity){
        chunkSounds.addSound(intensity, source, "SELF");
    }

    public void receiveSoundThrows(){

    }

}