package ua.lviv.iot.algo.part1.Lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class BotanicGardenTest {

    @Test
    void hasOrchard() {
        BotanicGarden testClass = new BotanicGarden(1, 2, 3, 4);

        assertFalse(testClass.hasOrchard());
    }

    @Test
    void hasVegetableGarden() {
        BotanicGarden testClass = new BotanicGarden(1, 2, 3, 4);

        assertTrue(testClass.hasVegetableGarden());
    }

    @Test
    void setNumberOfFruitTrees() {
        BotanicGarden testClass = new BotanicGarden(1, 2, 3, 4);
        testClass.setNumberOfFruitTrees(2);

        assertEquals(2, testClass.getNumberOfFruitTrees());
    }

    @Test
    public void testToString() {
        ToStringVerifier.forClass(BotanicGarden.class).verify();
    }
}