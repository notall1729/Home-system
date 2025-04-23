import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeSystem homeSystem = new SmartHomeSystem();

        int q = scanner.nextInt();
        String[] commands = new String[q];

        for (int i = 0; i < q; ++ i){
            commands[i] = scanner.nextLine();
        }

        for (int i = 0; i < q; ++ i){
         String command = commands[i];
         String[] result = command.split(" ");
         switch (result[0]){
             case "add_device" :
                 homeSystem.addDevice(result[1], result[2], result[3]);
                 break;

             case "set_device":
                 homeSystem.setDevice(result[1], result[2], result[3]);
                 break;

             case "remove_device":
                 homeSystem.revomeDevice(result[1]);
                 break;

             case "list_devices":
                 homeSystem.listDevice();
                 break;

             case "add_rule":
                 homeSystem.addRule(result[1], result[2], result[3]);
                 break;

             case "check_rules":
                 homeSystem.checkRules(result[1]);
                 break;

             case "list_rules":
                 homeSystem.listRules();
                 break;
         }
        }
    }
}