package pl.folkerts.hello;

public class App {
    public static void main(String [] args) {
        var name = "Julie";

        System.out.println(String.format("Hello %s", name));

        int a = 2;
        int b = 4;

        int result = a + b;

        if (result != 6) {
            throw new IllegalStateException("Assertion error");
        }
    }
}
