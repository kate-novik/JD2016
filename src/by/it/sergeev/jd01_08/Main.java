package by.it.sergeev.jd01_08;

public class Main {
    public static void main(String[ ] args) {

            IFilm film = new Comedy("Весёлые ребята");
            System.out.println(film.getName());
            IFilm filmmaking = new Comedy("");
            filmmaking.development();
            filmmaking.preproduction();
            filmmaking.production();
            filmmaking.postproduction();
            filmmaking.distribution();
        }
    }
