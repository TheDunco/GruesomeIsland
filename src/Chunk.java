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
        // Create a worldSize x worldSize array of chunks
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

    /*
    Returns an int[] containing the i,j matrix coordinates of the chunk adjacent to this one in the direction specified
    The 3rd element (index 2) of the array will be a -1 if player tried to move out of bounds
     */
    public int[] getAdjacentChunk(String direction)
    {
        // String direction = direction;
        switch(direction) {
            // Keep in mind that b/c of matrix indexing, 0,0 is at top left (north west)
            case ("UP"):
            case ("NORTH"):
                if((this.iPos - 1) < 0) {

                    // out of bounds
                    return new int[]{iPos, jPos, -1};
                }
                return new int[]{this.iPos-1, this.jPos, 0};

            case ("RIGHT"):
            case ("EAST"):
                if((this.jPos + 1) >= worldSize) {

                    // out of bounds
                    return new int[]{iPos, jPos, -1};
                }
                return new int[]{this.iPos, this.jPos+1, 0};

            case ("DOWN"):
            case ("SOUTH"):
                if((this.iPos + 1) >= worldSize) {

                    // out of bounds
                    return new int[]{iPos, jPos, -1};
                }
                return new int[]{this.iPos+1, this.jPos, 0};

            case ("LEFT"):
            case ("WEST"):
                if((this.jPos - 1) < 0) {

                    // out of bounds
                    return new int[]{iPos, jPos, -1};
                }
                return new int[]{this.iPos, this.jPos-1, 0};

            default:
                return new int[]{-1, -1, -1};
        }
    }


    // add sounds
    public void receiveSounds(Sound next) {
        this.chunkSounds.addSound(next);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public LinkedList<Item> getItems() {
        return this.items;
    }

    // can directly print the output of this
    public String getSounds() {
        return this.chunkSounds.getSoundsString();
    }

    public Boolean inRange(Player player1, Player player2, int range) {
        for(int i = 0; i <= range; i++) {
            if(playerIn(player2.getName())) {
                return true;
            }
        }
        return false;
    }

    // returns a string of items
    public String seenItems() {
        String ret = "";
        for (int i = 0; i < this.items.size(); i++) {
            ret += this.items.get(i).getItem();
        }
        if (ret == "") {
            return "nothing";
        }
        return ret;
    }

    public String getBiomeName() {
        return this.biome.getBiomeName();
    }

    public void addPlayer(Player player)
    {
      this.players.add(player);
      player.setLocation(this);
    }

    public void removePlayer(Player player)
    {
        this.players.remove(player);
    }

    // Precondition: searching player MUST be in this chunk
    public Player getPlayer(Player searching, String target) {
        int i;
        for(i = 0; i < players.size(); i++) {
            if(players.get(i).getName() == target) {
                return players.get(i);
            }
        }
        return searching;
    }

    public Boolean playerIn(String playerName) {
        int i;
        for(i = 0; i < players.size(); i++) {
            if(players.get(i).getName() == playerName) {
                return true;
            }
        }
        return false;
    }

    public void userThrownSounds(String source, int intensity){
        chunkSounds.addSound(intensity, source, "SELF");
    }

}