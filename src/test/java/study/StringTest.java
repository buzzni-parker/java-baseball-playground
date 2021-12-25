package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual1 = "1,2".split(",");
        assertThat(actual1).contains("1","2");

        String[] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";

        Integer start_index = actual.indexOf("(");
        Integer end_index = actual.lastIndexOf(")");

        String sub_actual = actual.substring(start_index+1, end_index);
        assertThat(sub_actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException test using charAt")
    void charAt() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> { 
            "abc".charAt(4);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
