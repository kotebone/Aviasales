
package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {
    private final Manager manager = new Manager();
    Offer offer1 = new Offer(1, 10014, "LED", "IKT", 375);
    Offer offer2 = new Offer(2, 1799, "LED", "SVO", 95);
    Offer offer3 = new Offer(3, 9625, "VKO", "LCA", 225);
    Offer offer4 = new Offer(4, 7005, "LED", "SVO", 95);

    @BeforeEach
    public void save() {
        manager.save(offer1);
        manager.save(offer2);
        manager.save(offer3);
        manager.save(offer4);
    }

    @Test
    void searchFromTo(){
        Offer[] expected = new Offer[]{offer3};
        Offer[] actual = manager.search("VKO", "LCA");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchFromOnly(){
        Offer[] expected = new Offer[]{offer3};
        Offer[] actual = manager.search("VKO", " ");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchToOnly(){
        Offer[] expected = new Offer[]{offer1};
        Offer[] actual = manager.search(" ", "IKT");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAll(){
        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.search(" ", " ");
        assertArrayEquals(expected, actual);
    }
}