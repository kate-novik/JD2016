package by.it.sergeev.jd01_08;

/**
 * Created by user_2 on 13.05.2016.
 */
public class Comedy extends DomesticFilm{
    @Override
    public String showState() {
        String state="Плеер остановлен";
        if (this.isStatePlay()) {
            state = "Воспроизведение видео";
            if (this.isStatePause())
                state = "Плеер на паузе";
        }
        return state;
    }
}
