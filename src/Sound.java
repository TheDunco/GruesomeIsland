package src;
// implements a single sound class with mutators and accessors
public class Sound {
    private int intensity;
    private String source;
    private String direction;

    public Sound(int intensity, String source, String direction) {
        this.intensity = intensity;
        this.source = source;
        this.direction = direction;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public String getSource() {
        return this.source;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
