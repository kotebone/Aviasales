
package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {
    private Repository repository = new Repository();
    private final Manager manager = new Manager();
    Offer offer1 = new Offer(1, 10014, "LED", "IKT", 375);
    Offer offer2 = new Offer(2, 1799, "LED", "AMS", 175);
    Offer offer3 = new Offer(3, 9625, "VKO", "LCA", 225);
    Offer offer4 = new Offer(4, 7005, "LED", "AMS", 175);
    Offer offer5 = new Offer(5, 10014, "LED", "AMS", 175);
    Offer offer6 = new Offer(6, 14590, "LED", "AMS", 175);
    Offer offer7 = new Offer(7, 8655, "LED", "AMS", 175);
    Offer offer8 = new Offer(8, 7905, "LED", "AMS", 175);

    @BeforeEach
    public void save() {
        manager.save(offer1);
        manager.save(offer2);
        manager.save(offer3);
        manager.save(offer4);
        manager.save(offer5);
        manager.save(offer6);
        manager.save(offer7);
        manager.save(offer8);
    }

    @Test
    void searchFromTo() {
        Offer[] expected = new Offer[]{offer3};
        Offer[] actual = manager.search("VKO", "LCA");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAndSort() {
        Offer[] expected = new Offer[]{offer2, offer4, offer8, offer7, offer5, offer6};
        Offer[] actual = manager.search("LED", "AMS");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNoResult() {
        Offer[] expected = new Offer[0];
        Offer[] actual = manager.search("no", "no");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSort(){
        Offer[] expected = new Offer[]{offer2, offer4, offer8, offer7, offer5, offer6};
        Offer[] actual = new Offer[]{offer2, offer4, offer5, offer6, offer7, offer8};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);

    }
}