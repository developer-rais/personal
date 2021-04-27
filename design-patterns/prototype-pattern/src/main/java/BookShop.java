import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {

    private String shopName;

    @Override
    protected BookShop clone() {

        BookShop newBookShop = new BookShop(this.shopName);

        for (Book book : this.books) {
            Book newBook = new Book();
            newBook.setBookName(book.getBookName());
            newBook.setBookId(book.getBookId());
            newBookShop.getBooks().add(newBook);
        }

        return newBookShop;
    }

    public String getShopName() {
        return shopName;
    }

    public BookShop(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private List<Book> books = new ArrayList<Book>();

    public void loadBooks() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("Name" + i);
            books.add(book);
        }
    }

}
