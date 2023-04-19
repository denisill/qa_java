package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTestWithParameterized {

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineTestWithParameterized(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {1, 1},
                {5, 5},
                {10, 10}
        };
    }

    @Test
    public void getKittensWithTestData() {
        Feline feline = new Feline();
        assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }
}