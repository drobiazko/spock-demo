package returnvalues

import spock.lang.Specification

class FruitPickerSpec extends Specification {

    FruitTree tree = Mock()

    def mango = new Fruit("Mango", false)
    def orange = new Fruit("Orange", false)
    def apple = new Fruit("Apple", true)

    def "only allowed fruits"() {
        given:
        def picker = new FruitPicker(tree)

        when:
        def picked = picker.pick()

        then:
        tree.pickFruit(_) >> {ArrayList<Fruit> fruits -> fruits << mango << orange}

        expect:
        [mango, orange] == picked.collect {it}
    }

    def "with forbidden fruits"() {
        given:
        def picker = new FruitPicker(tree)

        when:
        def picked = picker.pick()

        then:
        tree.pickFruit(_) >> {ArrayList<Fruit> fruits -> fruits << mango << apple}

        expect:
        [mango] == picked.collect {it}
    }

    def "with forbidden with captures"() {
        given:
        def picker = new FruitPicker(tree)

        when:
        def picked = picker.pick()

        then:
        1 * tree.pickFruit({Collection<Fruit> fruits ->
            fruits << mango << apple
            fruits
        })

        expect:
        [mango] == picked.collect {it}
    }
}