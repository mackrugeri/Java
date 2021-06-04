import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingTest {

    @Test
    void game() {

        Bowling B = new Bowling();
//        int a =  B.Game();
//        assertEquals((Double) null,a);
    }
    @Test
    void check_spare_strick_gutter()
    {
        Bowling B = new Bowling();
        int a = B.check_spare_strick_gutter(10,10);
        assertEquals(1,a);
    }

}