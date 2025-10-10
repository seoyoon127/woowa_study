package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateNumRange(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if (new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException("[ERROR] 한 개의 로또에 중복된 번호가 있어선 안 됩니다.");
        }
    }

    private void validateNumRange(List<Integer> numbers){
        for (Integer num : numbers){
            if (num < 1 || num > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        return mutableNumbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public Integer compareWinNums(List<Integer> winNums){
        int count = 0;
        for (Integer num : numbers){
            if (winNums.contains(num)){
                count += 1;
            }
        }
        return count;
    }

    public Integer compareBonusNum(Integer bonusNum){
        if (numbers.contains(bonusNum)){
            return 1;
        }
        return 0;
    }
}
