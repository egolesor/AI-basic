package ai.linear.regression;

import calculator.model.Line;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LineTest {

    @Test
    public void testTheLineFormula(){
        Double alpha0 = 1d;
        Double alpha1 = 1d;
        Line line = new Line(alpha0, alpha1);

        assertEquals(line.toString().trim(), "y="+alpha0+"x+"+alpha1);
    }
}
