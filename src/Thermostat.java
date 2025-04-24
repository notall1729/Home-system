public class Thermostat extends Device implements HomeSystem {
    private int temperature = 20;

    public Thermostat(String name, String protocol, boolean status){
        super(name, protocol, status);
    }

    public void setTemperature(int temperature) {
        if (temperature > 30 || temperature < 10) {
            System.out.println("invalid value");
        } else {
            this.temperature = temperature;
            System.out.println("device update successfully");
        }
    }

    @Override
    public void setProperty(String property, String value){
        if (property.equals("brightness")){
            System.out.println("invalid property");
        }
       else if(property.equals("temperature")){
            setTemperature(Integer.parseInt(value));
        }
        else if (property.equals("status")){
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

    @Override
    public void printInfo(){
        String status1 = "off";
         if (status){
            status1 = "on";
        }

        System.out.println("thermostat: " + name + " " + status1 + " " + temperature + "C " + protocol);
    }
}
