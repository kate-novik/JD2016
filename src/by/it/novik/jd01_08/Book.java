package by.it.novik.jd01_08;

/**
 * Created by Kate Novik.
 */
public class Book extends Things {
    private String isbnBook;
    private String author;

    public Book (String isbnBook, String author, String nameThing) {
        super.setNameThing(nameThing);
        this.isbnBook = isbnBook;
        this.author = author;
    }

    public void setISBNBook (String isbnBook) {
        this.isbnBook = isbnBook;
    }

    public String getISBNBook () {
        return isbnBook;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public String getAuthor () {
        return author;
    }
}
