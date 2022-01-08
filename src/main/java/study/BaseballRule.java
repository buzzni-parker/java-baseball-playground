package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballRule {
    List<Integer> answer = new ArrayList<>(Arrays.asList(new Integer[3]));

    public BaseballRule() throws Exception {
        List<Integer> number_list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            number_list.add(i);
        }

        Collections.shuffle(number_list);

        int number = 0;
        for (int i=0; i<answer.size(); i++) {
            number += (int) (number_list.get(i)) * (Math.pow(10, i));
        }

        resetAnswer(number);
    }

    public void resetAnswer(int number) throws Exception {
        for (int i=0; i<answer.size(); i++) {
            answer.set(i, 0);
        }
        for (int i=0; i<answer.size(); i++) {
            setAnswer(number % 10, i);
            number /= 10;
        }
    }

    private void setAnswer(int number, int order) throws Exception {
        if (number == 0) {
            throw new Exception("can not use zero");
        }
        if (answer.contains(number)) {
            throw new Exception("number already use");
        }
        if (order >= answer.size()) {
            throw new Exception("out of index");
        }

        answer.set(order, number);
    }

    public int getAnswer() {
        int number = 0;

        for (int i=0; i<answer.size(); i++) {
            number += answer.get(i) * Math.pow(10, i) ;
        }

        return number;
    }

    public Map<String, Integer> guess(int number) {
        boolean[] strike = guessStrike(number);
        boolean[] ball = guessBall(number);

        Integer strike_count = 0;
        Integer ball_count = 0;

        for (int i=0; i<answer.size(); i++) {
            strike_count += (1 & Boolean.hashCode(strike[i]) >> 1);
            ball_count += (1 & Boolean.hashCode(!strike[i] && ball[i]) >> 1);
        }

        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("strike", strike_count);
        result.put("ball", ball_count);

        return result;
    }

    private boolean[] guessStrike(int number) {
        boolean[] strike = new boolean[answer.size()];

        for (int i=0; i<answer.size(); i++) {
            strike[i] = (answer.get(i) == number % 10);
            number /= 10;
        }

        return strike;
    }

    private boolean[] guessBall(int number) {
        boolean[] ball = new boolean[answer.size()];

        for (int i=0; i<answer.size(); i++) {
            ball[i] = answer.contains(number % 10);
            number /= 10;
        }

        return ball;
    }
}
