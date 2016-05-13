package by.it.sergeev.jd01_08;

/**
 * Created by user_2 on 13.05.2016.
 */
public interface IFilm {
    /**
     * Здесь описываются возможные действия с техникой
     * Задание 12 interface Техника <-- abstract class Плеер <-- class Видеоплеер.
     */
    boolean play();
    boolean stop();
    void pause();
}
