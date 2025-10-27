package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Carstest {

    @Test
    void testGetMaxPosition() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));

        pobi.move(4);
        woni.move(4);
        jun.move(4);

        pobi.move(4);
        woni.move(4);

        pobi.move(4);

        assertEquals(3, cars.getMaxPosition());

    }

    @Test
    void testGetOneWinner() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));

        pobi.move(4);
        woni.move(4);
        jun.move(4);

        pobi.move(4);
        woni.move(4);

        pobi.move(4);

        assertEquals(List.of("pobi"), cars.getWinner());
    }

    @Test
    void testGetMultipleWinner() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));

        pobi.move(4);
        woni.move(4);
        jun.move(4);

        pobi.move(4);
        woni.move(4);

        pobi.move(4);
        woni.move(4);

        assertEquals(List.of("pobi", "woni"), cars.getWinner());
    }

    @Test
    void testMaxCarCount() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            carList.add(new Car("car" + i));
        }

        assertThrows(IllegalArgumentException.class, () -> new Cars(carList));
    }

    @Test
    void testUpdateOneWinCount() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));

        pobi.move(4);
        woni.move(4);
        jun.move(4);

        pobi.move(4);
        woni.move(4);

        pobi.move(4);

        cars.updateWinCount();

        assertEquals(1, pobi.getWinCount());
        assertEquals(0, woni.getWinCount());
        assertEquals(0, jun.getWinCount());
    }

    @Test
    void testUpdateMultipleWinCount() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Cars cars = new Cars(List.of(pobi, woni, jun));

        pobi.move(4);
        woni.move(4);
        jun.move(4);

        pobi.move(4);
        woni.move(4);

        pobi.move(4);
        woni.move(4);

        cars.updateWinCount();

        assertEquals(1, pobi.getWinCount());
        assertEquals(1, woni.getWinCount());
        assertEquals(0, jun.getWinCount());
    }

    @Test
    void testMinCarCount() {
        List<Car> carList = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> new Cars(carList));
    }
}



