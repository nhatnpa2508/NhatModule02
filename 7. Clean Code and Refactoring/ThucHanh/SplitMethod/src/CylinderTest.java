import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CylinderTest {
/*    @Test*/
    @DisplayName("Testing getVolume(0, 0)")
    double testGetVolume0And0() {
        int radius = 0;
        int height = 0;
        double expected = 0;

        double result = Cylinder.getVolume(radius, height);
        assertEquals(expected, result);
        return result;
    }

/*    @Test*/
    @DisplayName("Testing getVolume(1, 2)")
    double testGetVolume1And2() {
        int radius = 1;
        int height = 2;
        double expected = 18.84955592153876;

        double result = Cylinder.getVolume(radius, height);
        assertEquals(expected, result);
        return result;
    }

    public static void main(String[] args) {
        CylinderTest cylinder = new CylinderTest();
        System.out.println(cylinder.testGetVolume0And0());
        System.out.println(cylinder.testGetVolume1And2());
    }
}
