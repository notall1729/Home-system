import exception.InvalidCommandException;

public class Light extends Device{
    private int brightness;

    public Light(String name, String protocol, boolean status){
        super(name, protocol, status);
    }

    public void setBrightness(int brightness) {
        if(brightness < 0 || brightness > 100){
            throw new InvalidCommandException("invalid value");
        }
        this.brightness = brightness;
        System.out.println("device update successfully");
    }

    private void setProperty(String property, String value){
        if(property.equals("brightness")){
            setBrightness(Integer.parseInt(value));
        }

        if (property.equals("temperature")){
            throw new InvalidCommandException("invalid property");
        }

        if (property.equals("status")){
            int status;
            if(value.equals("on")){
                status = 1;
            }

            else if (value.equals("off")){
                status = 0;
            }

            else status = 2;

            setStatus(status);
        }
    }
}
