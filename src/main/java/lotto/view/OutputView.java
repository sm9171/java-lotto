package lotto.view;

import lotto.domain.Amount;
import lotto.domain.AmountEnum;
import lotto.domain.Lotto;
import lotto.domain.MyLottos;

import java.util.HashMap;
import java.util.Map;

public class OutputView {
	public MyLottos printBuyLottos(Integer pay) {
		MyLottos myLottos = MyLottos.rollLottos(pay);

		System.out.println(myLottos.getLottoCount() + "개를 구매했습니다.");

		for (int i = 0; i < myLottos.getLottoCount(); i++) {
			System.out.println(myLottos.getLottos().get(i).getNumbersToString());
		}
		return myLottos;
	}

	public Map<Integer, Integer> printWinnersStatistics(final String winNumber, final MyLottos myLottos) {
		Lotto winLotto = new Lotto(winNumber);
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(3, 0);
		hashMap.put(4, 0);
		hashMap.put(5, 0);
		hashMap.put(6, 0);
		for (int i = 0; i < myLottos.getLottoCount(); i++) {
			long count = myLottos.getLottos().get(i).compareWinNumber(winLotto);
			findWinner(count, hashMap);
		}
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (int i = 3; i <= 6; i++) {
			printWinners(hashMap, i);
		}

		return hashMap;
	}

	public void printTotalReturn(final Map<Integer, Integer> hashMap, final Integer pay) {
		int totalAmount = 0;
		for (int i = 3; i <= 6; i++) {
			totalAmount += Amount.getAmount(i) * hashMap.get(i);
		}
		System.out.println("총 수익률은 " + (double) totalAmount / pay + "입니다.");
	}

	private void printWinners(final Map<Integer, Integer> hashMap, final int i) {
		System.out.println(i + "개 일치 (" + AmountEnum.from(i).getAmount() + "원)- " + hashMap.get(i) + "개");
	}

	private static void findWinner(final long count, final Map<Integer, Integer> hashMap) {
		if (count >= 3) {
			hashMap.put((int) count, hashMap.get((int) count) + 1);
		}
	}
}
