package lotto.Domain;

import java.util.List;

public class Result {
    private Integer fifth;
    private Integer fourth;
    private Integer third;
    private Integer second;
    private Integer first;
    private String profit;

    public Result() {
        this.fifth = 0;
        this.fourth = 0;
        this.third = 0;
        this.second = 0;
        this.first = 0;
        this.profit = "";
    }

    public static Result of(List<Lotto> lottoList, List<Integer> winNums, Integer bonusNum){
        Result result = new Result();
        for (Lotto lotto : lottoList){
            int correct = lotto.compareLotto(winNums);
            int correctB = lotto.compareBonus(bonusNum);
            result.setGrade(correct, correctB);
        }
        result.setProfit(lottoList.size());
        return result;
    }

    public List<Integer> getResultList(){
        return List.of(fifth, fourth, third, second, first);
    }

    private void setGrade(Integer correct, Integer correctB){
        int correctTotal = correct + correctB;
        if (correctTotal == 6){
            if (correctB == 0){
                first += 1;
            }
            else second += 1;
        }
        else if (correctTotal == 5){
            third += 1;
        }
        else if (correctTotal == 4){
            fourth += 1;
        }
        else if (correctTotal == 3){
            fifth += 1;
        }
    }

    private void setProfit(Integer size){
        int profit_cost = first * 2000000000 + second * 30000000 + third * 1500000 + fourth * 50000 + fifth * 5000;
        profit = String.format("%.1f", (double) profit_cost / size);
    }

    public String getProfit(){
        return profit;
    }
}
