package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class BaseballRuleTest {
    BaseballRule baseball_rule;

    @BeforeEach
    public void setUp() throws Exception {
        baseball_rule = new BaseballRule();
        baseball_rule.resetAnswer(123);
    }

    @Test
    public void guess() {
        assertEquals(dummyResult(3, 0), baseball_rule.guess(123));
        assertEquals(dummyResult(0, 0), baseball_rule.guess(456));
        assertEquals(dummyResult(1, 1), baseball_rule.guess(152));
    }
    
    @Test
    public void getAnswer() {
        assertEquals(123, baseball_rule.getAnswer());
    }

    @AfterEach
    public void tearDown() {
        baseball_rule = null;
    }

    private Map<String, Integer> dummyResult(int strike_count, int ball_count) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("strike", strike_count);
        result.put("ball", ball_count);
        return result;
    }
}
