import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningNumbersTest {
	@Test
	void 로또_티켓_하나와_보너스_번호_하나가_당첨_번호를_생성할_수_있다() {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(2);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);
		LottoNumber bonusNumber = new LottoNumber(7);
		LottoTicket winningNumbers = new LottoTicket(List.of(num1, num2, num3, num4, num5, num6));

		assertDoesNotThrow(() -> new LottoWinningNumbers(winningNumbers, bonusNumber));
	}

	@Test
	void 당첨_번호에_보너스_번호가_포함되면_예외를_던진다() {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(2);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);
		LottoNumber bonusNumber = new LottoNumber(6);
		LottoTicket winningNumbers = new LottoTicket(List.of(num1, num2, num3, num4, num5, num6));

		assertThatThrownBy((() -> new LottoWinningNumbers(winningNumbers, bonusNumber)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource({
		"1, 2, 3, 4, 5, 6, 7, 6, false",
		"4, 2, 3, 1, 5, 8, 6, 5, true",
		"9, 8, 1, 2, 3, 4, 6, 4, true"})
	void 로또와_당첨_번호_사이의_동일한_수의_개수를_계산할_수_있다(int number1, int number2, int number3, int number4, int number5, int number6, int bonusNumber, int sameNumberCount, boolean hasBonusNumber) {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(2);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);
		LottoTicket lottoTicket = new LottoTicket(List.of(num1, num2, num3, num4, num5, num6));

		LottoNumber bonusNum = new LottoNumber(bonusNumber);
		LottoTicket winningNumbers = new LottoTicket(List.of(new LottoNumber(number1), new LottoNumber(number2), new LottoNumber(number3), new LottoNumber(number4), new LottoNumber(number5), new LottoNumber(number6)));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNum);

		assertThat(lottoWinningNumbers.calculateResult(lottoTicket)).isEqualTo(new LottoResult(sameNumberCount, hasBonusNumber));
	}
}
