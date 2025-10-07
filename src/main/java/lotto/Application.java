package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoController lc = new LottoController(inputView, outputView);
        lc.run();
    }
}
