package by.it.drachyova.jd01_08;


public class TheatreVisitor {
    private String name;//имя посетителя
    private int age;//возрас посетителя
    private boolean isVisited=false;//посещал ли посетитель театр
    public TheatreVisitor(String name, int age){//конструктор для посетителя
        this.name=name;
        this.age=age;
    }
    public boolean visitTheatre(){//метод посещения театра
        System.out.println("Театр посещен");
        this.isVisited=true;
        return isVisited;
    }
    public boolean getIsVisited(){
        return isVisited;
    }
}
