package lotto.view;

import lotto.domain.MyLottos;

public class LottoManager {
	private final InputView inputView;
	private final OutputView outputView;

	public LottoManager(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Integer pay = inputView.inputPay();
		int manuallyCount = inputView.inputNumberOfLottosToPurchaseManually();
		MyLottos manuallyLottos = inputView.inputManualLottoNumbers(manuallyCount);
		MyLottos myLottos = outputView.printBuyLottos(pay, manuallyLottos);
		String winNumber = inputView.getWinNumber();
		String bonusNumber = inputView.getBonusNumber();
		outputView.printWinnersStatistics(winNumber, myLottos, bonusNumber);
	}
}
