package ch.scheitlin.alex.utils;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a regular expression and provides functions to:
 * - check whether a String matches the regular expression
 * - extract the specified components of the regular expression
 */
public class RegexMatcher {
    /**
     * The regular expression as a String.
     */
    private String regex;

    /**
     * Creates a new instance of RegexMatcher.
     *
     * @param regex a regular expression
     */
    public RegexMatcher(String regex) {
        this.regex = regex;
    }

    /**
     * Checks whether a String matches the regular expression or not.
     *
     * @param string the String to test
     * @return {@code true} if the String matches the regular expression,
     * {@code false} if the String does not match the regular expression
     */
    public boolean matches(String string) {
        return string.matches(regex);
    }

    /**
     * Matches the pattern to a String and returns the specified components of the String.
     *
     * @param string the String to extract the components from
     * @return the specified components of the String
     * @throws Exception if the String does not match the regular expression
     */
    public String[] extractComponents(String string) throws Exception {
        String[] components = this.extract(string);
        if (components == null) {
            throw new Exception("Could not match the String to the provided pattern.");
        } else {
            return components;
        }
    }

    /**
     * Matches the pattern to a String and returns the specified components of the String.
     *
     * @param string the String to extract the components from
     * @return the specified components of the String or {@code null} if the String does not
     * match the regular expression
     */
    public String[] extractComponentsSilently(String string) {
        return this.extract(string);
    }

    /**
     * Matches the pattern to a String and returns the specified components of the String.
     *
     * @param string the String to extract the components from
     * @return the specified components of the String
     */
    private String[] extract(String string) {
        // match the pattern to the String
        Pattern p = Pattern.compile(this.regex);
        Matcher m = p.matcher(string);

        // check whether the pattern matches the String
        if (!m.matches()) {
            return null;
        }

        // get matched components
        MatchResult result = m.toMatchResult();
        String[] components = new String[result.groupCount()];
        for (int i = 0; i < result.groupCount(); i++) {
            components[i] = result.group(i + 1);
        }

        return components;
    }
}
