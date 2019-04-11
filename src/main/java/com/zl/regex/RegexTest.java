package com.zl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tzxx
 * @date 2018/9/5
 */
public class RegexTest {


    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
            System.out.println(matcher.group()+"==");
        }
        return matches;
    }
    public void givenTwoSets_whenMatchesUnion_thenCorrect() {
        int matches = runTest("[1-3 7-9]", "123456789");
        System.out.println(matches == 6);
    }
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a?", "hi");

        System.out.println(matches == 3);
    }
    public void givenCapturingGroup_whenMatches_thenCorrect() {
        int matches = runTest("(\\d\\d)\\2", "121212121212");

        System.out.println(matches);
    }
    public void givenCapturingGroup_whenMatches_thenCorrect3() {
        int matches = runTest("(\\d\\d)\\1", "1213");
        System.out.println(matches);
    }
}
