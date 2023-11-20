

class CommandLineCalculator {
    public static void main(String[] args) {
        int characters = args.length;
        if (characters < 3) {
            System.out.println("You did not type in a calculation!");
        } else if (characters % 2 == 0) {
            System.out.println("Invalid number of command line parameters.");
        } else {
            Calculator counter = new Calculator();
            counter.count(args);
        }
    }
}

class Calculator {
    int count(String[] args) {
        int result = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length - 1; i += 2) {
            String operator = args[i];
            int operand = Integer.parseInt(args[i + 1]);
            if (operator.equals("+")) {
                result += operand;
            } else if (operator.equals("-")) {
                result -= operand;
            }
        }

        return result;
    }
}