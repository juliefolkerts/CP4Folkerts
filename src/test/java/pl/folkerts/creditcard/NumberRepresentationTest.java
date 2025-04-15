package pl.folkerts.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumberRepresentationTest {
    @Test
    void doubleRepresentation() {
        double a = 0.02;
        double b = 0.03;

        System.out.println("Result:");
        System.out.println(b - a);
    }

    @Test
    void bigDecimalRepresentation() {
        BigDecimal a = new BigDecimal("0.02");
        BigDecimal b = new BigDecimal("0.03");

        System.out.println("Result:");
        System.out.println(b.subtract(a));
    }
}
