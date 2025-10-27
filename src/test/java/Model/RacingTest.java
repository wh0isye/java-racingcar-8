package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Racingtest {

    @Test
    void testMaxRound() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));

        assertThrows(IllegalArgumentException.class, () -> new Racing(cars, 101));
    }

    @Test
    void testMinRound() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));

        assertThrows(IllegalArgumentException.class, () -> new Racing(cars, 0));
    }
}