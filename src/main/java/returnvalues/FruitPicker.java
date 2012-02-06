package returnvalues;

import java.util.ArrayList;
import java.util.Collection;

public class FruitPicker {

    private final FruitTree tree;

    public FruitPicker(FruitTree tree) {
        this.tree = tree;
    }

    public Collection<Fruit> pick() {
        final ArrayList<Fruit> picked = new ArrayList<Fruit>();

        tree.pickFruit(picked);

        final ArrayList<Fruit> fruits = new ArrayList<Fruit>();

        for (Fruit fruit : picked) {

            if (!fruit.isForbidden()) {

                fruits.add(fruit);
            }
        }

        return fruits;
    }
}
