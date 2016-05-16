package by.it.novik.jd01_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class Bookcase extends Cupboards {
    // Укажем состояние для книжных шкафов по вешанью
    private boolean stateHang;
    //Укажем список книг в шкафу
    private List <Book> listOfBooks;

    public Bookcase () {
        super();
        stateHang = false;
        this.listOfBooks = new ArrayList<>();
    }

    public Bookcase (double stateX, double stateY) {
        super();
        stateHang = false;
        setStateX(stateX);
        setStateY(stateY);
    }

    /**
     * Метод повесить шкаф
     */
    public void hangBookcase () {
        stateHang = true;
    }

    /**
     * Перегрузка метода putThing - положить вещь в шкаф
     * @param book Объект книга
     * @return true - книга положена, в противном случае - false
     */
    public boolean putThing (Book book){
        if (book != null) { // Проверка на не пустой объект
            listOfBooks.add(book);
            return true;
        }
        return false;
    }

    /**
     * Перегрузка метода takeThing - взять вещь
     * @param isbnBook Поле ISBN книги
     * @return Обект book или null
     */
    public Book takeThing (String isbnBook){
        if (!isbnBook.isEmpty()) { // Проверка на не пустой ISBN книги
                   for (Book book : listOfBooks) {
                      if (book.getISBNBook().equals(isbnBook)) {
                          listOfBooks.remove(book);
                       }
                       return book;
                   }
        }
        return null;
    }

    /**
     * Используем динамическое связывниие, переопределяя метод disassemble абстрактного класса
     * Добавляем значение поля stateHang = false, т.к. при разборке шкаф не повешен
     */
    @Override
    public boolean disassemble () { // Динамическое связывание
        super.disassemble();
        stateHang = false; // Добавляем значение поля повешен
        return getStateAssemble();
    }

    /**
     * Показать состояния шкафа
     */
    public void showState (){
        System.out.print("Состояние книжного шкафа:");
       if (getStateAssemble()) {
           System.out.print("собран");
           if (stateHang) {
               System.out.print(", повешен"); }
           else { System.out.print(", не повешен"); }
           if (getStateOpen()) {
               System.out.print(", открыт"); }
           else { System.out.print(", закрыт"); }
    }
    else {
        System.out.print("разобран, не повешен, открыт");
    }
    System.out.print(", положение x=" + getStateX()+", положение y="+getStateY());
}

    /**
     * Сортировка книг
     * @return true - книги отсортированы
     */
    public boolean sortThings () {
        Collections.sort(listOfBooks, new Comparator <Book> () {
            public int compare(Book book1, Book book2) {
                return book1.getISBNBook().compareToIgnoreCase(book2.getISBNBook());
            }
        });
return true;
    }

    public void setStateHang (boolean stateHang) {
        this.stateHang = stateHang;
    }
    public boolean getStateHang () {
        return stateHang;
    }

    public List getListOfBooks () {
        return listOfBooks;
    }


}
