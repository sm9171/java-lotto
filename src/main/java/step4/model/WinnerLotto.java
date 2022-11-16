package step4.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerLotto {
	private final static String DELIMITER = ",";
	private final static String SPACE = " ";
	private final static String NON_SPACE = "";
	private final static int LOTTO_START_NUM = 1;
	private final static int LOTTO_END_NUM = 45;
	private final static int CHK_DUPLICATE_NUM = 6;

	private static Set<Integer> winningNumber;
	private static int bonusNumber;

	public WinnerLotto(String winningNumber, int bonusNumber) {
		WinnerLotto.winningNumber = splitWinningNumber(winningNumber);
		checkWinningNumber();
		WinnerLotto.bonusNumber = bonusNumber;
		checkBonusNumber();
	}

	private Set<Integer> splitWinningNumber(String winningNumber) {
		return Arrays.stream(winningNumber.replaceAll(SPACE, NON_SPACE).split(DELIMITER))
				.map(Integer::parseInt)
				.collect(Collectors.toSet());
	}

	private void checkWinningNumber() {
		winningNumber.stream().mapToInt(number -> number)
				.filter(number -> number < LOTTO_START_NUM || number > LOTTO_END_NUM)
				.forEach(number -> {
					throw new IllegalArgumentException("지난주 당첨 번호가 잘못 입력되었습니다.");
				});

		if (winningNumber.size() != CHK_DUPLICATE_NUM) {
			throw new IllegalArgumentException("지난 주 당첨 번호에 중복된 번호가 들어있습니다.");
		}
	}

	private void checkBonusNumber() {
		if (winningNumber.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호가 지난주 당첨 번호에 있습니다.");
		}

		if (bonusNumber > LOTTO_END_NUM || bonusNumber < LOTTO_START_NUM) {
			throw new IllegalArgumentException("보너스 번호가 입력될 수 있는 범위를 넘었습니다.");
		}
	}

	public Set<Integer> getWinningNumber() {
		return winningNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
