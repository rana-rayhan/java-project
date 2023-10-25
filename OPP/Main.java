package OPP;

public class Main {
    public static void main(String[] args) {
        Teacher teacherObject1 = new Teacher();
        teacherObject1.displayInfo();

        Teacher teacherObject2 = new Teacher("Ryan", "CSE", 101);
        teacherObject2.displayInfo();

        Teacher teacherObject3 = new Teacher("Pial", "CSE", 102);
        teacherObject3.displayInfo();

    }
}
