public class Phone {

    private String os;
    private int ram;
    private String processors;
    private int batterySize;
    private double screenSize;

    public Phone(String os, int ram, String processors, int batterySize, double screenSize) {
        this.os = os;
        this.ram = ram;
        this.processors = processors;
        this.batterySize = batterySize;
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processors='" + processors + '\'' +
                ", batterySize=" + batterySize +
                ", screenSize=" + screenSize +
                '}';
    }

}
