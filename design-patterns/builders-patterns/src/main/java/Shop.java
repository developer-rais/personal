public class Shop {
    public static void main(String[] args) {
        Phone phone=new PhoneBuilder().setOs("IOS").setBatterySize(2100).getPhone();
        System.out.println(phone.toString());
    }
}
