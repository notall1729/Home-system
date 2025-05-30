public class Device {
    protected String name;
    protected String protocol;
    protected boolean status;

    public Device(String name, String protocol, boolean status){
        this.name = name;
        this.protocol = protocol;
        this.status = status;
    }

    public void setStatus(int status) {
        if (status != 0 && status != 1){
            System.out.println("invalid status");
        }
       else if(status == 1) {
            this.status = true;
            System.out.println("device update successfully");
        }
        else if (status == 0){
            this.status = false;
            System.out.println("device update successfully");
        }
    }
}
