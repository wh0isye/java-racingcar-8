package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Racingtest {

    @Test
    void testOneRound() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));
        Racing racing = new Racing(cars, 1);

        racing.raceOneRound();
        racing.endOneRound();

        assertEquals(0, pobi.getPosition());
        assertEquals(0, woni.getPosition());
        assertEquals(0, jun.getPosition());
    }

    @Test
    void testGetMaxWin() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));
        Racing racing = new Racing(cars, 3);

        pobi.addWin();
        pobi.addWin();

        woni.addWin();

        assertEquals(2, racing.getMaxWin());
    }

    @Test
    void testGetOneFinalWinner() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));
        Racing racing = new Racing(cars, 6);

        pobi.addWin();
        pobi.addWin();
        pobi.addWin();

        woni.addWin();
        woni.addWin();

        jun.addWin();

        assertEquals(List.of("pobi"), racing.getFinalWinner());
    }

    @Test
    void testGetMultipleFinalWinner() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));
        Racing racing = new Racing(cars, 5);

        pobi.addWin();
        pobi.addWin();

        woni.addWin();
        woni.addWin();

        jun.addWin();

        assertEquals(List.of("pobi", "woni"), racing.getFinalWinner());
    }

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