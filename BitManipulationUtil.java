package checkers;

class BitManipulationUtil {
    // Set a specific bit in a given integer
    public static int setBit(int number, int bitPosition) {
        return number | (1 << bitPosition);
    }

    // Clear a specific bit in a given integer
    public static int clearBit(int number, int bitPosition) {
        return number & ~(1 << bitPosition);
    }

    // Toggle a specific bit in a given integer
    public static int toggleBit(int number, int bitPosition) {
        return number ^ (1 << bitPosition);
    }

    // Get the value of a specific bit in a given integer
    public static boolean getBit(int number, int bitPosition) {
        return (number & (1 << bitPosition)) != 0;
    }

    // Perform addition
    public static int add(int a, int b) {
        return a + b;
    }

    // Perform subtraction
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Perform multiplication
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Perform division
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Convert from decimal to binary string
    public static String toBinaryString(int number) {
        return Integer.toBinaryString(number);
    }

    // Convert from decimal to hexadecimal string
    public static String toHexString(int number) {
        return Integer.toHexString(number);
    }

    // Convert from binary string to decimal
    public static int fromBinaryString(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }

    // Convert from hexadecimal string to decimal
    public static int fromHexString(String hexString) {
        return Integer.parseInt(hexString, 16);
    }
}
