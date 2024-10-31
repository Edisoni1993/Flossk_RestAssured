package tests.hamcrest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestIntro {

    @Test
    public void numbersTest(){

        assertThat(1 + 3, is(4));
        assertThat(4+3, is(equalTo(7)));
        matchesRegex("Test");

        int num = 10+2;

        assertThat(num, is(not(11)));
    }

    @Test
    public void stringTest(){

        String word = "wooden spoon";
        String str = " ";

        assertThat(word, is("wooden spoon"));
        assertThat(word, startsWith("woo"));
        assertThat(word, endsWithIgnoringCase("OON"));
        assertThat(word, containsString("den"));
        assertThat(word, containsStringIgnoringCase("SPOO"));
    }

    @Test
    public void listsTest(){

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<String> words = Arrays.asList("java", "selenium", "git", "api");

        assertThat(nums, hasSize(4));
        assertThat(words, hasSize(4));

        assertThat(nums, hasItem(2));
        assertThat(words, hasItems("java", "git"));
        assertThat(nums, containsInAnyOrder(1, 4, 3, 2));

        assertThat(nums, everyItem(lessThan(5)));
        assertThat(words, everyItem(not(blankString())));
    }
}
