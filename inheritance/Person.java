package inheritance;

public class Person extends Animal {
     String name;
     int age;

    public void setValue(String n, String ani, int a) {
        name = n;
        age = a;
        animalName=ani;
    }

    void display() {
        System.out.println("Display from person class");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("He own a: "+ animalName);
    }
}
