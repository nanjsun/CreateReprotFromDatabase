package main.java.readFile;

public class IgniteData {
    private String concentration = new String();
    private String time = new String();
    private String length = new String();
    private String action = new String();

    public String getConcentration() {
        return concentration;
    }

    public String getTime() {
        return time;
    }

    public String getLength() {
        return length;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
