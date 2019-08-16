package converter.word;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Class to validate the NumberToWordConverter class methods
 */
public class NumberToWordConverterTest {

    @Test
    public void whenZeroGiven_thenReturnEmptyString() {
        assertEquals("", NumberToWordConverter.convert_to_words(0));
    }


    @Test
    public void whenGivenNumberInNegative_thenReturnWords() {
        String expectedResult
                = "Minus Three Thousand";

        assertEquals(
                expectedResult,
                NumberToWordConverter.convert_to_words(-3000));
    }

    @Test
    public void whenGivenNumberInMillions_thenReturnWords() {
        String expectedResult
                = "Nine Million";

        assertEquals(
                expectedResult,
                NumberToWordConverter.convert_to_words(9000000));
    }

    @Test
    public void whenGivenNumberInHundredMillions_thenReturnWords() {
        String expectedResult
                = "Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine";

        assertEquals(
                expectedResult,
                NumberToWordConverter.convert_to_words((999999999)));
    }

    @Test
    public void whenGivenNumberInOneHundredMillions_thenReturnWords() {
        String expectedResult
                = "One Hundred Thousand";

        assertEquals(
                expectedResult,
                NumberToWordConverter.convert_to_words((100000)));
    }

}
