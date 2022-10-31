package lotto.view;

import static lotto.exception.ExceptionMessage.ERROR_INVALID_BONUS_NUMBER;
import static lotto.exception.ExceptionMessage.ERROR_ZERO_OR_NEGATIVE_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = scanner.nextInt();
        validateInputMoney(input);
        scanner.nextLine();

        return input;
    }

    private static void validateInputMoney(final int input) {
        if (input == 0) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }
    }

    public static String inputWinningLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        validateInputLotto(input);

        return input;
    }

    private static void validateInputLotto(final String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }
    }

    public static LottoNumber inputBonusNumber(final Lotto winningLotto) {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        LottoNumber input = new LottoNumber(scanner.nextInt());
        validateInputBonus(winningLotto, input);

        return input;
    }

    private static void validateInputBonus(final Lotto winningLotto, final LottoNumber input) {
        if (winningLotto.contains(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public static int inputManualLottoQuantity() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int input = scanner.nextInt();
        validateInputQuantity(input);
        scanner.nextLine();

        return input;
    }

    private static void validateInputQuantity(final int input) {
        if (input == 0) {
            throw new IllegalArgumentException(ERROR_ZERO_OR_NEGATIVE_VALUE.getMessage());
        }
    }

    public static List<String> inputManualLottos() {
        List<String> input = new ArrayList<>();

        System.out.println("\n수동으로 구매할 번호를 구매해 주세요.");
        while(scanner.hasNextLine()) {
            String next = scanner.nextLine();
            if (next.isEmpty()) {
                break;
            }
            validateInputLotto(next);
            input.add(next);
        }
        scanner.nextLine();

        return input;
    }
}
