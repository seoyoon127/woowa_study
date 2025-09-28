package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNum {
    private List<Integer> computer;

    public ComputerNum() {
        computer = new ArrayList<>();
    }

    public void setComputerNum(){
        while(computer.size() < 3){
            Integer randomNum = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNum)){
                computer.add(randomNum);
            }
        }
    }

    public Integer getIndexOfNum(int num){
        return computer.indexOf(num);
    }
}
