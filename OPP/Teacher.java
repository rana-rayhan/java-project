package OPP;

public class Teacher {
    String name, subject;
    int id;
   static int count;

    Teacher() {
        System.out.println("No value");
    }

    Teacher(String n, String s, int i) {
        name = n;
        subject = s;
        id = i;
        count++;
    }

    void displayInfo() {
        System.out.println("Teacher list: "+ count);
        System.out.println("id: "+id);
        System.out.println("Name: "+name);
        System.out.println("Subject: "+subject);
        System.out.println();
    }
}
