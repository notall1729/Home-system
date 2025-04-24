package rule;

public class AutomationRule {
    private String name;
    private String time;
    private String action;

    public AutomationRule(String name, String time, String action) {
        this.name = name;
        this.time = time;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString(){
        return name + " " + time + " " + action;
    }

    public void printRule(){
        System.out.println(name + " " + time + " " + action);
    }
}
