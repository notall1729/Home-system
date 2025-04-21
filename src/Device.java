import java.util.*;

public class Device {
    protected String name;
    protected String protocol;
    protected boolean status;

    public Device(String name, String protocol, boolean status){
        this.name = name;
        this.protocol = protocol;
        this.status = status;
    }
}
