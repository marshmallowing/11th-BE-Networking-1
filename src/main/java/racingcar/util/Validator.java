package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<String> validateCarNames(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 공백일 수 없습니다");
        }

        String[] names = input.split(",");
        List<String> validNames = new ArrayList<>();

        for (String name : names) {
            String trimmedName = name.trim();

            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다");
            }
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
            }
            validNames.add(trimmedName);
        }
        return validNames;
    }

    public static int validateRounds(String input) {
        try {
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
            }
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다");
        }
    }
}


