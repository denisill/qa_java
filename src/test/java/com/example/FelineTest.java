package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineTest(int kittensCount, int expectedKittensCount) {
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

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void eatMeatGetFoodInvokeWithParamPredator() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoParamReturn1() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithTestData() {
        Feline feline = new Feline();
        assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }
}