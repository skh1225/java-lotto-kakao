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
}
