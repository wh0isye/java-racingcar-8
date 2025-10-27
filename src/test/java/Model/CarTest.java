package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Cartest {

    @Test
    void testMoveForward() {
        Car car = new Car("pobi");
        car.move(4);

        assertEquals(1, car.getPosition());
    }

    @Test
    void testNotMoveForward() {
        Car car = new Car("pobi");
        car.move(3);

        assertEquals(0, car.getPosition());
    }

    @Test
    void testNameLength() {
        assertThrows(IllegalArgumentException.class, () -> new Car("aaaaaa"));
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }
}
