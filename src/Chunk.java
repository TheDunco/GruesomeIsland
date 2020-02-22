
public class Chunk 
{
    public Biome biome;
    public int elevation;
    public int worldSize;
    public Sounds chunkSounds = new Sounds();

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
                    // throw new IllegalStateException("You ran into the Northern border!");
                }
                ret[0] = this.iPos--;
                ret[1] = this.jPos;
                return ret;

            case ("East"):
                if(this.jPos++ >= worldSize) {
                    // throw new IllegalStateException("You ran into the Eastern border!");
                }
                ret[0] = this.iPos;
                ret[1] = this.jPos++;
                return ret;
            case ("South"):
                if(this.iPos++ >= worldSize) {
                    // throw new IllegalStateException("You ran into the Southern border!");
                }
                ret[0] = this.iPos++;
                ret[1] = this.jPos;
                return ret;

            case ("West"):
                if(this.jPos-- < 0) {
                    // throw new IllegalStateException("You ran into the Western border!");
                }
                ret[0] = this.iPos;
                ret[1] = this.jPos--;
                return ret;

            default:
                return new int[]{-1, -1};
        }
    }
    // string of the sounds from the various locations around the map
    // for the user end
    public String getSounds(){
        String totalSounds = "";

        totalSounds += chunkSounds.fromNorth();
        totalSounds += chunkSounds.fromSouth();
        totalSounds += chunkSounds.fromEast();
        totalSounds += chunkSounds.fromWest();
        totalSounds += chunkSounds.fromSelf();

        return chunkSounds;
    }

    public void receiveSounds(Sounds next){

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