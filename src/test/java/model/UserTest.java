package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    public User arif;
    public User khafido;
    public ArrayList<History> histories;

    @BeforeEach
    void setUp() {
        arif = new User(1, "arif", 100);
        khafido = new User(2, "khafido", 100);
        histories = new ArrayList<>();
    }

    @Test
    void sendPoint() {
        assertEquals(0, histories.size());
        histories.addAll(arif.sendPoint(khafido, 10));
        assertEquals(2, histories.size());
        assertEquals(90, arif.getPoint());
        assertEquals(110, khafido.getPoint());
    }

    @Test
    void askPoint() {
        assertEquals(0, histories.size());
        histories.addAll(arif.askPoint(khafido, 10));
        assertEquals(2, histories.size());
        assertEquals(110, arif.getPoint());
        assertEquals(90, khafido.getPoint());
    }

    @Test
    void notSendPoint() {
        assertEquals(0, histories.size());
        assertNull(arif.sendPoint(khafido, 110));
        assertEquals(0, histories.size());
        assertEquals(100, arif.getPoint());
        assertEquals(100, khafido.getPoint());
    }

    @Test
    void notAskPoint() {
        assertEquals(0, histories.size());
        assertNull(arif.askPoint(khafido, 110));
        assertEquals(0, histories.size());
        assertEquals(100, arif.getPoint());
        assertEquals(100, khafido.getPoint());
    }

    @Test
    void sendMinusPoint() {
        assertEquals(0, histories.size());
        assertNull(arif.sendPoint(khafido, -10));
        assertEquals(0, histories.size());
        assertEquals(100, arif.getPoint());
        assertEquals(100, khafido.getPoint());
    }

    @Test
    void askMinusPoint() {
        assertEquals(0, histories.size());
        assertNull(arif.askPoint(khafido, -10));
        assertEquals(0, histories.size());
        assertEquals(100, arif.getPoint());
        assertEquals(100, khafido.getPoint());
    }

    @Test
    void compareHistory() {
        User mockArif = new User(1, "arif", 100);
        User mockKhafido = new User(2, "khafido", 100);
        ArrayList<History> mockHistories = mockArif.sendPoint(mockKhafido, 10);

        histories.addAll(arif.sendPoint(khafido, 10));
        assertEquals(mockHistories.toString(), histories.toString());
    }
}