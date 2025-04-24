import rule.AutomationRule;

import java.util.*;

public class SmartHomeSystem {
    private Map<String, Device> devices = new LinkedHashMap<>();
    private ArrayList<AutomationRule> rules = new ArrayList<>();

    public void addDevice(String type, String name, String protocol) {
        if (devices.containsKey(name)) {
            System.out.println("duplicsted device name");
        } else {
            Device device;
            if (type.equals("light")) {
                if (protocol.equals("WiFi")) {
                    device = new Light(name, "WiFi", false);
                    devices.put(name, device);
                    System.out.println("device added successfully");
                } else if (protocol.equals("Bluetooth")) {
                    device = new Light(name, "Bluetooth", false);
                    devices.put(name, device);
                    System.out.println("device added successfully");
                } else System.out.println("invalid input");

            } else if (type.equals("thermostat")) {
                if (protocol.equals("WiFi")) {
                    device = new Thermostat(name, "WiFi", false);
                    devices.put(name, device);
                    System.out.println("device added successfully");
                } else if (protocol.equals("Bluetooth")) {
                    device = new Thermostat(name, "Bluetooth", false);
                    devices.put(name, device);
                    System.out.println("device added successfully");
                } else System.out.println("invalid input");
            } else {
                System.out.println("invalid input");
            }
        }
    }

    public void setDevice(String name, String property, String value) {
        if (!(devices.containsKey(name))) {
            System.out.println("device not found");
        } else {
            Device device = devices.get(name);
            if (property.equals("status")) {
                if (value.equals("on")) {
                    device.status = true;
                } else if (value.equals("off")) {
                    device.status = false;
                } else {
                    System.out.println("invalid value");
                }
            } else if (property.equals("brightness")) {
                if (device instanceof Thermostat) {
                    System.out.println("invalid property");
                } else {
                    Light light = (Light) device;
                    light.setBrightness(Integer.parseInt(value));
                }
            } else if (property.equals("temperature")) {
                if (device instanceof Light) {
                    System.out.println("invalid property");
                } else {
                    Thermostat thermostat = (Thermostat) device;
                    thermostat.setTemperature(Integer.parseInt(value));
                }
            } else {
                System.out.println("invalid property");
            }
        }
    }

    public void revomeDevice(String name) {
        if (!(devices.containsKey(name))) {
            System.out.println("device not found");
        }

        devices.remove(name);
        for (int i = 0; i < rules.size(); ++i) {
            if (rules.get(i).getName().equals(name)) {
                rules.remove(rules.get(i));
            }
        }
        System.out.println("device removed successfully");
    }

    public void listDevice() {
        if (devices.isEmpty()) {
            System.out.println();
        }

        for (Device device : devices.values()) {
            if (device instanceof Light) {
                Light light = (Light) device;
                light.printInfo();
            }
            if (device instanceof Thermostat) {
                Thermostat thermostat = (Thermostat) device;
                thermostat.printInfo();
            }
        }
    }

    public void addRule(String name, String time, String action) {
        if (!(devices.containsKey(name))) {
            System.out.println("device not found");
        }

        if (!(isValidTimeFormat(time))) {
            System.out.println("invalid time");
        }

        if (!action.equals("on") && !action.equals("off")) {
            System.out.println("invalid action");
        }

        AutomationRule rule = new AutomationRule(name, time, action);
        if (rules.contains(rule)) {
            System.out.println("duplicate rule");
        } else {
            rules.add(rule);
            System.out.println("rule added successfully");
        }
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

        public void listRules () {
            if (rules.isEmpty()) {
                System.out.println();
            } else {
                for (AutomationRule automationRule : rules) {
                    automationRule.printRule();
                }
            }
        }
    }

