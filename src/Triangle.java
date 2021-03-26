import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стороны треугольника: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        boolean tmp = compare(a, b, c);
        if (tmp) {
            System.out.println(calc(a, b, c));
        } else {
            System.out.println("Треугольник должен быть правильным!");
        }
    }

    public static boolean compare(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException();
        }
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    public static TriangleType calc(int a, int b, int c) {
        TriangleType result;
        if (a == c && b == c) {
            result = TriangleType.EQUILATERAL;
        } else if (a == b || a == c || b == c) {
            result = TriangleType.ISOSCELES;
        } else {
            result = TriangleType.NON_EQUILATERAL;
        }
        return result;
    }

    public enum TriangleType {

        EQUILATERAL("Треугольник равносторонний"),
        ISOSCELES("Треугольник равнобедренный"),
        NON_EQUILATERAL("Неравносторонний");

        private final String type;

        TriangleType(String type) {
            this.type = type;
        }
    }



}