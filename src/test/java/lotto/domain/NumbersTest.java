package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumbersTest {
	private Numbers numbers;

	@BeforeEach
	void init() {
		List<Number> numberValues = Stream.of(1, 2, 3, 4, 5, 6)
			.map(Number::new)
			.collect(Collectors.toList());
		numbers = new Numbers(numberValues);
	}

	@DisplayName(value = "숫자를 포함하는지 반환")
	@CsvSource(value = {"1,true", "3,true", "7,false", "0,false"})
	@ParameterizedTest
	void containsNumber(int number, boolean expect) {
		boolean result = numbers.containsNumber(number);
		assertThat(result).isEqualTo(expect);
	}
}
