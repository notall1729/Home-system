
import exception.InvalidCommandException;
import rule.AutomationRule;

import java.util.*;

public class SmartHomeSystem {
    private Map<String, Device> devices = new LinkedHashMap<>();
    private List<AutomationRule> rules = new ArrayList<>();

    public void addDevice(String type, String name, String protocol){
        if(devices.containsKey(name)){
            throw new InvalidCommandException("duplicsted device name");
        }

        Device device;
        if(type.equals("light")){
            device = new Light(name, protocol, false);
        } else if(type.equals("thermostat")){
            device = new Thermostat(name, protocol, false);
        } else {
            throw new InvalidCommandException("invalid input");
        }

        devices.put(name, device);
        System.out.println("device added successfully");
    }

    public void setDevice(String name, String property, String value){
        if(!(devices.containsKey(name))){
            throw new InvalidCommandException("device not found");
        }

        Device device = devices.get(name);
        if(property.equals("status")){
            if(value.equals("on")){
                device.status = true;
            }
            else if(value.equals("off")){
                device.status = false;
            }
            else{
                throw new InvalidCommandException("invalid value");
            }
        }
        else if(property.equals("brightness")){
            if(devices instanceof Thermostat){
                throw new InvalidCommandException("invalid property");
            }
            else{
                Light light = (Light) device;
               light.setBrightness(Integer.parseInt(value));
            }
        }
        else if(property.equals("temperature")){
            if(device instanceof Light){
                throw new InvalidCommandException("invalid property");
            }
            else {
                Thermostat thermostat = (Thermostat) device;
                thermostat.setTemperature(Integer.parseInt(value));
            }
        }
        else {
            throw new InvalidCommandException("invalid property");
        }
    }

    public void revomeDevice(String name){
       if(!(devices.containsKey(name))){
           throw new InvalidCommandException("device not found");
       }

       devices.remove(name);
       for (AutomationRule rule : rules){
           if(rule.getName().equals(name)){
               rules.remove(rule);
           }
       }
       System.out.println("device removed successfully");
    }

    public void listDevice(){
        if(devices == null){
            System.out.println();
        }
        else {
            for (Device device : devices.values()){
                if (device instanceof Light){
                    Light light = (Light) device;
                    light.printInfo();
                }

                if (device instanceof Thermostat){
                    Thermostat thermostat = (Thermostat) device;
                    thermostat.printInfo();
                }
            }
        }
    }

    public void addRule(String name, String time, String action){
        if(devices.containsKey(name)){
            throw new InvalidCommandException("device not found");
        }

        if(isValidTimeFormat(time)){
            throw new InvalidCommandException("invalid time");
        }

        if (!action.equals("on") && !action.equals("off")){
            throw new InvalidCommandException("invalid action");
        }

        AutomationRule rule = new AutomationRule(name, time, action);
        if(rules.contains(rule)){
            throw new InvalidCommandException("duplicate rule");
        }

        rules.add(rule);
    }

    private boolean isValidTimeFormat(String time) {
        if (!time.matches("^([01]\\d|2[0-3]):[0-5]\\d$")) {
            return false;
        }
        return true;
    }

    public void checkRules(String time) {
        for (AutomationRule rule : rules) {
            if (rule.getTime().equals(time)) {
                setDevice(rule.getName(), "status", rule.getAction());
            }
        }
        System.out.println("rules checked");
    }

    public void listRules(){
        if(rules == null){
            System.out.println();
        }
        else {
            for (AutomationRule automationRule : rules){
                automationRule.printRule();
            }
        }
    }
}
