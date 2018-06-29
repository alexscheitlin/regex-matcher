# RegEx Matcher

> _An object to simply test whether Strings match a regular expression or not and to extract specified components from the Strings._

## Example Usage:

Define a regular expression a String should match to and use opening and closing parentheses to define the components to extract from the String:
```
String myRegularExpression = "^firstName:(.*), lastName:(.*)$";
```

Define a String to test whether it matches to the regular expression and if so to extract the specified components:

```
String myString = "firstName:Alex, lastName:Scheitlin";
```

Test whether the String matches the regular expression and print its components to the console:

  - Method 1: Normal match throwing an `Exception` in case of a mismatch.
```
RegexMatcher myRegexMatcher = new RegexMatcher(myRegularExpression);
try {
    String[] components = myRegexMatcher.extractComponents(myString);
    System.out.println("First Name: " + components[0]);
    System.out.println("Last Name: " + components[1]);
} catch (Exception ex) {
    System.out.println(ex.getMessage());
}
```

Expected Output:
```
First Name: Alex
Last Name: Scheitlin
```

Silent way


  - Method 2: Silent match returning `null` in case of a mitsmatch.
```
RegexMatcher myRegexMatcher = new RegexMatcher(myRegularExpression);
if (myRegexMatcher.match(myString)) {
    String[] components = myRegexMatcher.extractComponentsSilently(myString);
    System.out.println("First Name: " + components[0]);
    System.out.println("Last Name: " + components[1]);
}
```

Expected Output:
```
First Name: Alex
Last Name: Scheitlin
```