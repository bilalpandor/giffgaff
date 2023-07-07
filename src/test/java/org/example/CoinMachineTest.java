package org.example;

import org.example.model.Coin;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;

public class CoinMachineTest {


    @Test
    public void canReturnASinglePennyWhenPennyPassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "1";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void canReturnTwoPenceWhenTwoPencePassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "2";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void canReturnFivePenceWhenFivePencePassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "5";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void canReturnTenPenceWhenTenPencePassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "10";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void canReturnTwentyPenceWhenTwentyPencePassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "20";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void canReturnFiftyPenceWhenFiftyPencePassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "50";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void canReturnOnePoundWhenOnePoundPassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "100";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void canReturnTwoPoundWhenTwoPoundPassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "200";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }


    @Test
    public void willThrowExceptionWhenUnsuitableInputPassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "hello";

        //when / then
        assertThrows(NumberFormatException.class, () -> underTest.calculateFewestCoins(inputValue));
    }


    @Test
    public void canReturnAppropriateCoinsWhenPoundSignIsPassed(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "£1";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getValue(), is(100));
    }

    @Test
    public void canReturnAppropriateCoinsWhenThreePoundsWithSignIsPassed(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "£3";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(2));
        assertThat(result.get(0).getValue(), is(100));
        assertThat(result.get(1).getValue(), is(200));
    }

    //TODO: fix failing test
    @Test
    public void canReturnAppropriateCoinsWhenFloatIsPassed(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        float inputValue = 2.60f;

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(1));
    }




    //TODO: fix Failing test
    @Test
    public void canReturnTwoCoinsWhenSixPenceIsPassedIn(){
        //given
        CoinMachine underTest = new CoinMachine();
        underTest.initialiseMachine();
        String inputValue = "6";

        //when
        List<Coin> result = underTest.calculateFewestCoins(inputValue);

        //then
        assertThat(result.size(), is(2));
        assertThat(result.get(0).getValue(), is(5));
        assertThat(result.get(1).getValue(), is(1));
    }



}
