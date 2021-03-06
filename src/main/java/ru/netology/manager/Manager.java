package ru.netology.manager;

import ru.netology.domain.Offer;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {
    Repository repository = new Repository();
    private String from;
    private String to;

    public void save(Offer offer) {
        repository.add(offer);
    }

    public Offer[] search(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.findAll()) {
            if (offer.getDepartureAirport().equals(from.toUpperCase()) && offer.getArrivalAirport().equals(to.toUpperCase())) {
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}