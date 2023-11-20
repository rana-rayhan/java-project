
class Demo {
    String name, id;

    Demo(String n, String id) {
        this.name = n;
        this.id = id;
    }

    void printF() {
        System.out.println(this.name + id);
        System.out.println("Hello");
    }
}

public class Main {
    public static void main(String[] args) {

        Demo d = new Demo("Ryan", "101");
        d.printF();

    }
}