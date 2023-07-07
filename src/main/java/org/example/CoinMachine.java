package org.example;

import org.example.model.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinMachine {

    List<Coin> internalCoins = new ArrayList<>();

    public void initialiseMachine() {
        Coin penny = new Coin(1);
        internalCoins.add(penny);

        Coin twoPence = new Coin(2);
        internalCoins.add(twoPence);

        Coin fivePence = new Coin(5);
        internalCoins.add(fivePence);

        Coin tenPence = new Coin(10);
        internalCoins.add(tenPence);

        Coin twentyPence = new Coin(20);
        internalCoins.add(twentyPence);

        Coin fiftyPence = new Coin(50);
        internalCoins.add(fiftyPence);

        Coin oneHundredPence = new Coin(100);
        internalCoins.add(oneHundredPence);

        Coin twoHundredPence = new Coin(200);
        internalCoins.add(twoHundredPence);
    }


    public List<Coin> calculateFewestCoins(Float input) {
        //extract string out of float
        String rawInput = input.toString();


        return calculateFewestCoins(input.toString());
    }

    public List<Coin> calculateFewestCoins(String input) {
        List<Coin> coinsToReturn = new ArrayList<>();
        Integer inputValue;

        if (input.startsWith("£")) {
            inputValue = Integer.parseInt(input.substring(1) + "00");
        } else {
            inputValue = Integer.parseInt(input);
        }


        if (internalCoins.stream()
                .anyMatch(coin -> coin.getValue().equals(inputValue))) {
            Coin coin = new Coin(inputValue);
            coinsToReturn.add(coin);
            return coinsToReturn;
        } else {

            Coin coin = findClosestMatchingCoin(inputValue);
            coinsToReturn.add(coin);

            while (coin.getValue() <= inputValue) {
                Coin subsequentCoin = findClosestMatchingCoin(inputValue - coin.getValue());
                coinsToReturn.add(subsequentCoin);
            }
        }

        return coinsToReturn;
    }

    private Coin findClosestMatchingCoin(Integer inputValue) {
        //loop through internalCoins list to fnd value smaller than or equal to inputvalue
        //when found, create coin and add to return list
        //minus the input value by the value found to find remaining coins
        Integer coinValue = inputValue;

        return internalCoins.stream()
                .sorted()
                .filter(coin -> coin.getValue() <= coinValue)
                .findFirst()
                .orElseThrow(() -> new IndexOutOfBoundsException());

//        coinsToReturn.add(coinOfSmallerOrEqualValue);
//
//        coinValue = coinValue- coinOfSmallerOrEqualValue.getValue();
    }
}
