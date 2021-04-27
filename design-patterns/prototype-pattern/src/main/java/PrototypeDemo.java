public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

        BookShop bookShop1=new BookShop("bookShop1");
        bookShop1.loadBooks();
        System.out.println(bookShop1.toString());


        BookShop bookShop2=bookShop1.clone();
        bookShop1.setShopName("A1");
        System.out.println(bookShop2.toString());
    }
}
