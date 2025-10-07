package lotto.Domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if (new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLotto(){
        return numbers;
    }

    public Integer compareLotto(List<Integer> winNums){
        int cnt = 0;
        for (Integer n : numbers){
            if (winNums.contains(n)){
                cnt += 1;
            }
        }
        return cnt;
    }

    public Integer compareBonus(Integer bonusNum){
        if (numbers.contains(bonusNum)){
            return 1;
        }
        return 0;
    }
}
