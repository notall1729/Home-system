import exception.InvalidCommandException;

public class Light extends Device{
    private int brightness;

    public void setBrightness(int brightness) {
        if(brightness < 0 || brightness > 100){
            throw new InvalidCommandException("invalid value");
        }
        this.brightness = brightness;
    }
}
