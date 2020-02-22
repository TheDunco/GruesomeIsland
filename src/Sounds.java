// A Sounds object stores three arrays of intensity, source, and direction values,
// where a pair of three terms in the nth index in each of the arrays represents one distinct sound in the chunk.

public class Sounds {
    private int[] intensity;
    private String[] source;
    private String[] direction;
    // default Sounds constructor; not meant to be used
    Sounds () { intensity = 0; source = "VOID"; direction = " "} 
    // Sounds constructor - t
    Sounds (int Intensity, String Source, String Direction) {
        intensity[0] = [Intensity];
        source[0] = [Source];
        direction[0] = Direction;
    }
    // adds another distinct sound to a Sounds object
    public void addSound(int Intensity, String Source, String Direction) {
        intensity[numSounds()] = Intensity;
        source[numSounds()] = Source;
        direction[numSounds()] = Direction;
    }
    // number of distinct sounds in chunk
    public int numSounds() {
        return intensity.length;
    }
    // returns intensity of the sound at soundIndex
    public int getIntensity(int soundIndex) {
        return intensity[soundIndex];
    }
    // returns source of the sound at soundIndex
    public String getSource(int soundIndex) {
        return source[soundIndex];
    }
    // returns the cardinal direction a distinct sound can be heard from
    public String soundDirection(int soundIndex) {
        return direction[soundIndex];
    }

    public String intensityTrans(int intensity){
        if (intensity <= 3){
            return "faintly hear";
        } else if (intensity <= 5){
            return "clearly hear";
        } else if (intensity <= 8){
            return "loudly hear";
        } else if (intensity > 8){
            return "very loudly hear"
        }
    }

    public String fromNorth(){
        String northSounds = "";
        for (int i = 0; i < direction.length; i++){
            if (direction[i] == "NORTH" && intensity[i] >= 3){
                northSounds += ("You " + intensityTrans(intensity[i]) + " from the northward direction.\n"); 
            }
        }
        if (northSounds == ""){
            return "You hear nothing from the northward direction";
        } else {
            return northSounds;
        }
    }

    public String fromSouth(){
        String southSounds = "";
        for (int i = 0; i < direction.length; i++){
            if (direction[i] == "SOUTH " && intensity[i] >= 3){
                southSounds += ("You " + intensityTrans(intensity[i]) + " from the southward direction.\n"); 
            }
        }
        if (southSounds == ""){
            return "You hear nothing from the southward direction";
        } else {
            return southSounds;
        }
    }

    public String fromEast(){
        String eastSounds = "";
        for (int i = 0; i < direction.length; i++){
            if (direction[i] == "EAST" && intensity[i] >= 3){
                eastSounds += ("You " + intensityTrans(intensity[i]) + " from the eastward direction.\n"); 
            }
        }
        if (eastSounds == ""){
            return "You hear nothing from the eastward direction";
        } else {
            return eastSounds;
        }
    }

    public String fromWest(){
        String westSounds = "";
        for (int i = 0; i < direction.length; i++){
            if (direction[i] == "WEST" && intensity[i] >= 3){
                westSounds += ("You " + intensityTrans(intensity[i]) + " from the westward direction.\n"); 
            }
        }
        if (westSounds == ""){
            return "You hear nothing from the westward direction";
        } else {
            return westSounds;
        }
    }

    public String fromSelf(){
        String selfSounds = "";
        for (int i = 0; i < direction.length; i++){
            if (direction[i] == "SELF" && intensity[i] >= 3){
                westSounds += ("You " + intensityTrans(intensity[i]) + " from within your location.\n"); 
            }
        }
        if (selfSounds == ""){
            return "You hear nothing from your current location.";
        } else {
            return selfSounds;
        }
    }
}