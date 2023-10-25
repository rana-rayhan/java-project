package inheritance;

public class Teacher extends Person {

    @Override
    void display() {
        super.display();
        System.out.println("\nDisplay from teacher class");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("He own a: "+ animalName);
    }
}
