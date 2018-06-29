# RegEx Matcher

> _An object to simply test whether Strings match a regular expression or not and to extract specified components from the Strings._

```
// define a regular expression a String should match to and use opening and closing
// parentheses to define the components to extract from the String
String regularExpression = "^firstName:(.*), lastName:(.*)$";

// define a String to test whether it matches to the regular expression and if so to
// extract the specified components
String myString = "firstName:Alex, lastName:Scheitlin";

// test whether the String matches the regular expression and print its components
// to the console
RegexMatcher myRegexMatcher = new RegexMatcher(regularExpression);
if (myRegexMatcher.match(myString)) {
    try {
        String[] components = myRegexMatcher.extractComponents(myString);
        System.out.println("First Name: " + components[0]);
        System.out.println("Last Name: " + components[1]);
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}

// silent way
// check before matching
if (myRegexMatcher.match(myString)) {
    String[] components = myRegexMatcher.extractComponentsSilently(myString);
    System.out.println("First Name: " + components[0]);
    System.out.println("Last Name: " + components[1]);
}
```