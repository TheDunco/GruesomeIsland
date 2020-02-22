package src;// A Sounds object stores three arrays of intensity, source, and direction values,
// where a pair of three terms in the nth index in each of the arrays represents one distinct sound in the chunk.

import java.util.LinkedList;

public class Sounds {
    // sounds is a pair (tuple) of Integer intensity, String source, String direction
    private LinkedList<Sound> soundsList = new LinkedList<Sound>();

    Sounds() {
        // intentionally empty, used to initialize class
    }

    // Sounds constructor - t
    Sounds(Integer Intensity, String Source, String Direction) {
        Sound toAdd = new Sound(Intensity, Source, Direction);
        this.soundsList.addFirst(toAdd);
    }

    // adds another distinct sound to a Sounds object
    public void addSound(int Intensity, String Source, String Direction) {
        Sound toAdd = new Sound(Intensity, Source, Direction);
        this.soundsList.addLast(toAdd);
    }

    // add a pre-defined sound object
    public void addSound(Sound next) {
        this.soundsList.addLast(next);
    }

    // number of distinct sounds in chunk
    public int numSounds() {
        return this.soundsList.size();
    }

    // returns intensity of the sound at soundIndex
    public Integer getIntensity(int soundIndex) {
        return this.soundsList.get(soundIndex).getIntensity();
    }

    // returns the source of the sound
    public String getSource(int soundIndex) {
        return this.soundsList.get(soundIndex).getSource();
    }

    // returns the cardinal direction a distinct sound can be heard from
    public String soundDirection(int soundIndex) {
        return this.soundsList.get(soundIndex).getDirection();
    }

    public LinkedList<Sound> getSoundsList() {
        return this.soundsList;
    }

    public String getSoundsString() {
        String ret = "";
        for (int i = 0; i < this.soundsList.size(); i++) {
            ret += "You " + intensityTrans(soundsList.get(i).getIntensity()); // you (intensity) hear
            ret += " a " + this.soundsList.get(i).getSource();                  // a (source)
            ret += " from the " + this.soundsList.get(i).getDirection();      // from the (direction)

            ret += "and\n";
        }
        if (ret == "") {
            return "You here nothing from your location";
        } else {
            return ret;
        }
    }

    public String intensityTrans(int intensity) {
        if (intensity <= 3) {
            return "faintly hear";
        } else if (intensity <= 5) {
            return "clearly hear";
        } else if (intensity <= 8) {
            return "loudly hear";
        } else if (intensity > 8) {
            return "very loudly hear";
        }
        return "";
    }
}