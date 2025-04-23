import exception.InvalidCommandException;

public class Thermostat extends Device{
    private int temperature;

    public Thermostat(String name, String protocol, boolean status){
        super(name, protocol, status);
    }

    public void setTemperature(int temperature) {
        if(temperature > 30 || temperature < 10){
            throw new InvalidCommandException("invalid value");
        }
        this.temperature = temperature;
        System.out.println("device update successfully");
    }

    private void setProperty(String property, String value){
        if(property.equals("temperature")){
            setTemperature(Integer.parseInt(value));
        }

        if (property.equals("brightness")){
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

    public void printInfo(){
        String status1;
        if(status == false){
            status1 = "off";
        }
        else if (status == true){
            status1 = "on";
        } else return;

        System.out.println("light: <" + name + "> <" + status1 + "> <" + temperature + ">C <" + protocol + ">");
    }
}
