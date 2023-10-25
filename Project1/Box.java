package Project1;

public class Box {
    double height, width, depth, volume;

    Box(double h, double w, double d) {
        height = h;
        width = w;
        depth = d;
    }

    void displayVolume() {
        volume = height * width * depth;
        System.out.println("Box volume= " + volume);
    }

}
