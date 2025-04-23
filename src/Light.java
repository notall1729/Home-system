public class Light extends Device implements HomeSystem {
    private int brightness = 50;

    public Light(String name, String protocol, boolean status){
        super(name, protocol, status);
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            System.out.println("invalid value");
        } else {
            this.brightness = brightness;
            System.out.println("device update successfully");
        }
    }

    @Override
    public void setProperty(String property, String value){
        if(property.equals("brightness")){
            setBrightness(Integer.parseInt(value));
        }

        if (property.equals("temperature")){
            System.out.println("invalid property");
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
        String status1;
        if(status == false){
            status1 = "off";
        }
        else if (status == true){
            status1 = "on";
        } else return;

        System.out.println("light: <" + name + "> <" + status1 + "> <" + brightness + ">% <" + protocol + ">");
    }
}
