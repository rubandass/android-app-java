package jhonr1.bit.famouspaintingquiz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for the important methods
 */
public class QuestionsTest {
    public Questions questions;

    @Before
    public void setUp() throws Exception {
        questions = new Questions(R.drawable.adam_sistine, "Andy Warhol", "Michelangelo", "Vincent Van Gogh", "Rene Magritte", "Michelangelo","Information");
    }

    @Test
    public void getCorrectAns1Test() {
        questions.setOption1("Michelangelo");
        assertEquals("Michelangelo", questions.getOption1());
    }

    @Test
    public void setCorrectAns2Test() {
        questions.setOption2("Andy Warhol");
        assertEquals("Andy Warhol", questions.getOption1());
    }

    @Test
    public void setCorrectAns3Test() {
        assertNotEquals("Ruban", questions.getOption1());
    }

    @Test
    public void setCorrectAns4Test() {
        questions.setOption2("Dass");
        assertNotEquals("Dass", questions.getOption1());
    }

    @Test
    public void toStringTest() {
        assertEquals("option1='Andy Warhol', option2='Michelangelo', option3='Vincent Van Gogh', option4='Rene Magritte', correctAns='Michelangelo'", questions.toString());
    }

    @Test
    public void setCorrectAns() {
        questions.setOption2("Andy Warhol");
        assertEquals("Andy Warhol", questions.getOption1());
    }
}