package example;

import org.junit.Assert;
import org.junit.Test;

public class StringUtiltsTest {
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenPassedNull() {
        String actual = null;

        StringUtils.getFirstNotDuplicatedChar(actual);
    }

    @Test
    public void shouldReturnSingleCharacterWhenSingleCharacter() {
        String actual = "a";

        String result = StringUtils.getFirstNotDuplicatedChar(actual);

        String expected ="a";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnFirstCharacterWhenPassedTwoDifferentCharacters() {
        String actual = "ab";

        String result = StringUtils.getFirstNotDuplicatedChar(actual);

        String expected ="a";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnThirdCharacterWhenFirstTwoCharactersAreDoubled() {
        String actual = "aab";

        String result = StringUtils.getFirstNotDuplicatedChar(actual);

        String expected ="b";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnFourthCharacterWhenFirstThreeCharactersAreTripled() {
        String actual = "cccd";

        String result = StringUtils.getFirstNotDuplicatedChar(actual);

        String expected ="d";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldNullForEmptyString() {
        String actual = "";

        String result = StringUtils.getFirstNotDuplicatedChar(actual);

        String expected = null;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnB(){
        String actual = "aaabcccdeeef";

        String result = StringUtils.getFirstNotDuplicatedChar(actual);

        String expected = "b";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnNullForNoNonRepeatingCharactersInValidString(){
        String actual = "abcabcabc";

        String result = StringUtils.getFirstNotDuplicatedChar(actual);

        String expected = null;
        Assert.assertEquals(expected, result);
    }
}
