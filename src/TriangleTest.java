import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

class TriangleTest {

    @ParameterizedTest
    @DisplayName("Тестируем метод compare, что результат будет true,  Эквивалентное разбиение")
    @MethodSource("provide1")
        // запись в параметрической форме
    void testCompare(int a, int b, int c, boolean result) {
        Assertions.assertEquals(result, Triangle.compare(a, b, c));
    }

    private static List<Arguments> provide1() {
        return Arrays.asList(
                // набор для первого числа
                Arguments.of(15, 20, 30, true),
                Arguments.of(10, 20, 30, false),
                // набор для второго числа
                Arguments.of(20, 25, 35, true),
                Arguments.of(20, 60, 35, false),
                // набор для третьего числа
                Arguments.of(15, 20, 30, true),
                Arguments.of(15, 20, 5, false)
        );
    }

    @ParameterizedTest
    @DisplayName("Тестируем метод calc, Граничные значения")
    @MethodSource("provide2")
    void testCalc1(int a, int b, int c, Triangle.TriangleType result) {
        Assertions.assertEquals(result, Triangle.calc(a, b, c));
    }

    private static List<Arguments> provide2() {
        return Arrays.asList(
                // стартовый набор
                Arguments.of(10, 10, 10, Triangle.TriangleType.EQUILATERAL),
                // набор для первого числа
                Arguments.of(9, 10, 10, Triangle.TriangleType.ISOSCELES),
                Arguments.of(11, 10, 10, Triangle.TriangleType.ISOSCELES),
                // набор для второго числа
                Arguments.of(10, 9, 10, Triangle.TriangleType.ISOSCELES),
                Arguments.of(10, 11, 10, Triangle.TriangleType.ISOSCELES),
                // набор для третьего числа
                Arguments.of(10, 10, 9, Triangle.TriangleType.ISOSCELES),
                Arguments.of(10, 10, 11, Triangle.TriangleType.ISOSCELES),

                Arguments.of(9, 10, 11, Triangle.TriangleType.NON_EQUILATERAL),
                Arguments.of(10, 9, 11, Triangle.TriangleType.NON_EQUILATERAL),
                Arguments.of(10, 11, 9, Triangle.TriangleType.NON_EQUILATERAL)
        );
    }

    @Test
    @DisplayName("Тестируем метод compare, Предположение об ошибке")
    void testCompare2() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  Triangle.compare(-1, 2, 2));
    }
}

