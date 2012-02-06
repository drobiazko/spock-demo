package returnvalues;

public final class Fruit {

    private final String name;

    private final boolean forbidden;

    public Fruit(String name, boolean forbidden) {
        this.name = name;
        this.forbidden = forbidden;
    }

    public String getName() {
        return name;
    }

    public boolean isForbidden() {
        return forbidden;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", forbidden=" + forbidden +
                '}';
    }
}
