import exception.InvalidCommandException;

public class Thermostat extends Device{
    private int temperature;

    public void setTemperature(int temperature) {
        if(temperature > 30 || temperature < 10){
            throw new InvalidCommandException("invalid value");
        }
        this.temperature = temperature;
    }

    private boolean setProperty(String property, int value){
        if(property.equals("temperature")){
            setTemperature(value);
        }

        if (property.equals("brightness")){
            throw new InvalidCommandException("invalid property");
        }

        if (property.equals("status")){
            setStatus(value);
        }
    }
}
