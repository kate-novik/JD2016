package by.it.sergeev.jd01_08;

public class Main {
    public static void main(String[ ] args) {
        //создадим видеоплеер, запустим, два раза нажмем на паузу, остановим
        DomesticFilm df=new DomesticFilm() {
            @Override
            public String showState() {
                return null;
            }
        };
        System.out.println(df.showState());
        df.play();  // нажали воспроизведение
        System.out.println(df.showState());
        df.pause(); //поставили на паузу
        System.out.println(df.showState());
        df.pause(); //сняли с паузы
        System.out.println(df.showState());
        df.stop();  //остановили
        System.out.println(df.showState());
    }
}

