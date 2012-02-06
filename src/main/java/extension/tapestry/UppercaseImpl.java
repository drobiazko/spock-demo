package extension.tapestry;

public class UppercaseImpl implements Uppercase {
    public String transform(String input) {
        return input.toUpperCase();
    }
}
