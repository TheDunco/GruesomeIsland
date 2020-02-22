public class Biome
{
    
    public Biome(int biomeSelection) {
        this.biomeSelection = biomeSelection;
    }
    public int biomeSelection;
    

    public int defaultMod = 5;

    public int soundMod = defaultMod;
    public int tracksMod = defaultMod;
    public int coverMod = defaultMod;
    public String biomeName;

    public int fixedMod = 2;

    // Biome switching
    public void biomeSelect() {
        switch (biomeSelection) {
            case 0: // winter
                biomeName = "Winter";
                soundMod -= fixedMod;
                tracksMod += fixedMod;
                coverMod -= fixedMod;
            case 1: // desert
                biomeName = "Desert";
                tracksMod += fixedMod;
                coverMod -= fixedMod;
            case 2: // forest
                biomeName = "Forest";
                soundMod -= fixedMod;
                coverMod += fixedMod;
            case 3:
                biomeName = "City";
                soundMod += fixedMod;
                tracksMod -= fixedMod;
                coverMod += fixedMod;
            default:
                biomeName = "Forest (default)";
                soundMod -= fixedMod;
                coverMod += fixedMod;
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