package study;

import java.util.Map;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) throws Exception {
        int command = 0;

        do {
            BaseballRule baseball_rule = new BaseballRule();
            BaseballGame.play(baseball_rule);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            command = BaseballGame.inputNumber();
        } while (command == 1);

    }

    public static void play(BaseballRule baseball_rule) throws Exception {
        Integer guess_number = 0;
        Map<String, Integer> guess_result;

        do{
            System.out.print("숫자를 입력해 주세요 : ");
            guess_number = BaseballGame.inputNumber();
            guess_result = baseball_rule.guess(guess_number);
            BaseballGame.print(guess_result);
        } while(!guess_result.get("strike").equals(3));
    }

    public static int inputNumber() {
        String input_string = null;

        try {
            Scanner scanner = new Scanner(System.in);
            input_string = scanner.nextLine();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(input_string);
    }

    public static void print(Map<String, Integer> result) {
        if (result.get("ball") > 0){
            System.out.printf("%d볼 ", result.get("ball"));
        }
        if (result.get("strike") > 0){
            System.out.printf("%d스트라이크 ", result.get("strike"));
        }
        if (result.get("ball") == 0 && result.get("strike") == 0){
            System.out.print("낫싱");
        }
        System.out.println("");
        if (result.get("strike").equals(3)){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
