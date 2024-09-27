//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Cat cat = new Cat();
        cat.makeSound();
        WildCat wildCat = new WildCat();
        wildCat.makeSound();
    }
}

abstract class Animal { //abstract prevents from instantiating a new object
    abstract void makeSound();
    protected void chewig(){ //subclasses could access it
        System.out.println("I am a chewing");
    }
}

class Dog extends Animal {
    void makeSound(){ //is visible only in this package
        System.out.println("I am a dog");
    }
}

interface Item{ //pure abstract object
    int getId();
}

class Cat extends Animal implements Item{ //implements is a composition
    @Override
    public int getId() {
        return 0;
    }

    void makeSound(){ //is visible only in this package
        System.out.println("I am a cat");
    }
    private void digest(){ //only visible in the class
        System.out.println("I am digesting");
    }
}

class WildCat extends Cat{
    void live(){
        chewig();
    }
    void makeSound(){
        System.out.println("I am wild wild cat");
    }

}
