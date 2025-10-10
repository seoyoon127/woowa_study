package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView iv = new InputView();
        OutputView ov = new OutputView();

        LottoController lc = new LottoController(iv,ov);
        lc.run();
    }
}
