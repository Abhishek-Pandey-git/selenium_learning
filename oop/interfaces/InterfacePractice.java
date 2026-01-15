package oop.interfaces;

interface Voice{
    void speak(String str );
}

abstract class Work{
    String work;
   abstract public void doesWork(String str);
}

class Human extends Work implements Voice {
    String name;
    int age;

    public Human(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public void speak(String str){
        System.out.println(this.name+" says "+str);
    }

    @Override
    public void doesWork(String work){
        System.out.println(this.name+ " does "+work);
    }
}
public class InterfacePractice {
    public static void main(String[] args) {
        Human h=new Human("Aman",12);
        h.speak("Hello!");
        h.doesWork("Teaching");
    }
}
