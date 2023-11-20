package bitManipulation;

public class Main {
    public static void main(String[] args) {
        // bit --> get | set | clear | update
        int n = 5; // 0101
        int pos = 2;
        int bitMaks = 1 << pos; // 0001 --> 0100

        // -- get bit at given position -- 0100 & 0101 = 0100
        if ((bitMaks & n) == 0) {
            System.out.println("Bit is: 0");
        } else {
            System.out.println("Bit is: 1");
        }

        // -- set bit at given position -- 0100 | 0101 = 0101
        int setBit = bitMaks | n;
        System.out.println(setBit);

        // -- clear bit at given position
        int notBit = ~(bitMaks); // -- 0100 = ~1011
        int clearBit = notBit & n; // -- 1011 & 1010 = 1010
        System.out.println(clearBit);


    }
}
