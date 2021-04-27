public class PhoneBuilder {

    private String os;
    private int ram;
    private String processors;
    private int batterySize;
    private double screenSize;

    public Phone getPhone() {
        return new Phone(this.os, this.ram, this.processors, this.batterySize, this.screenSize);
    }

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessors(String processors) {
        this.processors = processors;
        return this;
    }

    public PhoneBuilder setBatterySize(int batterySize) {
        this.batterySize = batterySize;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }
}
