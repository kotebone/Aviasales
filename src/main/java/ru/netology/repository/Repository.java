package ru.netology.repository;

import ru.netology.domain.Offer;

public class Repository {
    private Offer[] offers = new Offer[0];

    public void add(Offer offer) {
        int length = this.offers.length + 1;
        Offer[] temp = new Offer[length];
        System.arraycopy(this.offers, 0, temp, 0, this.offers.length);
        int lastInd = temp.length - 1;
        temp[lastInd] = offer;
        this.offers = temp;
    }

    public Offer[] findAll() {
        return offers;
    }


    public Offer[] removeById(int id) {
        int length = offers.length + 1;
        Offer[] tmp = new Offer[length];
        int index = 0;
        for (Offer offer : offers) {
            if (offer.getId() != id) {
                tmp[index] = offer;
                index++;
            }
        }
        offers = tmp;
        return tmp;
    }
}