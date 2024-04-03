package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningLottoTicketTest {
	@Test
	void 로또_티켓_하나와_보너스_번호_하나가_당첨_번호를_생성할_수_있다() {
		LottoNumber bonusNumber = LottoNumber.of(7);
		LottoTicket winningLottoTicket = LottoTicket.of(List.of(1, 2, 3, 4, 5, 6));

		assertDoesNotThrow(() -> new WinningLottoTicket(winningLottoTicket, bonusNumber));
	}

	@Test
	void 당첨_번호에_보너스_번호가_포함되면_예외를_던진다() {
		LottoNumber bonusNumber = LottoNumber.of(6);
		LottoTicket winningLottoTicket = LottoTicket.of(List.of(1, 2, 3, 4, 5, 6));

		assertThatThrownBy((() -> new WinningLottoTicket(winningLottoTicket, bonusNumber)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
