package studentList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> list = new LinkedList<Student>();

        Student s1 = new Student("Ryan", 101);
        Student s2 = new Student("Ryan", 103);
        Student s3 = new Student("Ryan", 102);
        Student s4 = new Student("Ryan", 105);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        for (Student s : list){
            System.out.println(s.id+" \t"+s.name+" \t"+s.className);
        }

    }
}
