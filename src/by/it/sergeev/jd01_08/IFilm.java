package by.it.sergeev.jd01_08;

/**
 * Created by user_2 on 13.05.2016.
 */
public interface IFilm {
    String getName(); //Название фильма
    /**
     * Этапы создания фильма.
     */
    void development();//   Разработка
    void preproduction();// Предварительное производство
    void production();//    Производство
    void postproduction();//Пост-продакшн
    void distribution();//  Распределение
}
