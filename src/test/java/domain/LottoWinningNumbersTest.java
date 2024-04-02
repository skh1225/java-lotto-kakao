package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.LottoNumber;
import domain.LottoTicket;
import domain.LottoWinningNumbers;

public class LottoWinningNumbersTest {
	@Test
	void 로또_티켓_하나와_보너스_번호_하나가_당첨_번호를_생성할_수_있다() {
		LottoNumber bonusNumber = new LottoNumber(7);
		LottoTicket winningNumbers = LottoTicket.of(List.of(1, 2, 3, 4, 5, 6));

		assertDoesNotThrow(() -> new LottoWinningNumbers(winningNumbers, bonusNumber));
	}

	@Test
	void 당첨_번호에_보너스_번호가_포함되면_예외를_던진다() {
		LottoNumber bonusNumber = new LottoNumber(6);
		LottoTicket winningNumbers = LottoTicket.of(List.of(1, 2, 3, 4, 5, 6));

		assertThatThrownBy((() -> new LottoWinningNumbers(winningNumbers, bonusNumber)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}