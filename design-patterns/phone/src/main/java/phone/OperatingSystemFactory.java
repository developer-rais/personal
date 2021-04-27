package phone;

public class OperatingSystemFactory {
    public OS getAndroidInstance() {
        return new Android();
    }

    public OS getOperatingSystemInstance(String string) {
        if ("android".equals(string))
            return new Android();
        else if ("ios".equals(string))
            return new IOS();

        return new IOS();
    }
}
