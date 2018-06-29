package ch.scheitlin.alex.utils;

import org.junit.Assert;
import org.junit.Test;

public class RegexMatcherTest {
    private String myRegularExpression = "^firstName:(.*), lastName:(.*)$";
    private RegexMatcher myRegexMatcher = new RegexMatcher(this.myRegularExpression);
    private String myString = "firstName:Alex, lastName:Scheitlin";
    private String myOtherString = "firstName:Alex, last:Scheitlin";

    @Test
    public void match_matchingString() {
        boolean doesMatch = this.myRegexMatcher.match(this.myString);

        Assert.assertTrue(doesMatch);
    }

    @Test
    public void match_nonMatchingString() {
        boolean doesMatch = this.myRegexMatcher.match(this.myOtherString);

        Assert.assertFalse(doesMatch);
    }

    @Test
    public void extractComponents_matchingString() {
        try {
            this.myRegexMatcher.extractComponents(this.myString);
        } catch (Exception ex) {
            Assert.fail("Should not have thrown an expetion.");
        }
    }

    @Test
    public void extractComponents_nonMatchingString() {
        try {
            this.myRegexMatcher.extractComponents(this.myOtherString);
            Assert.fail("Should have thrown an expetion.");
        } catch (Exception ex) {}
    }

    @Test
    public void extractComponentsSilently_matchingString() {
        String[] components = this.myRegexMatcher.extractComponentsSilently(this.myString);

        Assert.assertNotNull(components);
        Assert.assertEquals(components[0], "Alex");
        Assert.assertEquals(components[1], "Scheitlin");
    }

    @Test
    public void extractComponentsSilently_nonMatchingString() {
        String[] components = this.myRegexMatcher.extractComponentsSilently(this.myOtherString);

        Assert.assertNull(components);
    }
}