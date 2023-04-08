package ua.lviv.iot.algo.part1.Lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UniversityGardenTest {

    @org.junit.jupiter.api.Test
    public void hasOrchard() {
        UniversityGarden testClass = new UniversityGarden(11,12,13);

        assertFalse(testClass.hasOrchard());
    }

    @org.junit.jupiter.api.Test
    public void hasVegetableGarden() {
        UniversityGarden testClass = new UniversityGarden(11,12,13);

        assertFalse(testClass.hasVegetableGarden());
    }

    @org.junit.jupiter.api.Test
    public void setNumberOfSculptures() {
        UniversityGarden testClass = new UniversityGarden(11,12,13);
        testClass.setNumberOfSculptures(10);

        assertEquals(10,testClass.getNumberOfSculptures());
    }

    @Test
    public void testToString()
    {
        ToStringVerifier.forClass(UniversityGarden.class).verify();
    }
}