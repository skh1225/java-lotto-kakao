import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoTicketTest {
	@Test
	void 로또_번호_6개로_생성할_수_있다() {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(2);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);

		assertDoesNotThrow(() -> new LottoTicket(List.of(num1, num2, num3, num4, num5, num6)));
	}

	@Test
	void 로또_번호_6개가_아닌_개수로_생성하면_예외를_던진다() {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(2);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);
		LottoNumber num7 = new LottoNumber(7);

		assertAll(
			() -> assertThatThrownBy(() -> new LottoTicket(List.of(num1, num2, num3, num4, num5)))
				.isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> new LottoTicket(List.of(num1, num2, num3, num4, num5, num6, num7)))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 동일한_로또_번호가_존재하면_예외를_던진다() {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(1);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);

		assertThatThrownBy(() -> new LottoTicket(List.of(num1, num2, num3, num4, num5, num6)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또의_가격은_1000원이다() {
		assertThat(LottoTicket.PRICE).isEqualTo(1000);
	}

	@Test
	void 로또에_특정_번호가_포함되었는지_확인할_수_있다() {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(2);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);
		LottoNumber num7 = new LottoNumber(7);

		LottoTicket lottoTicket = new LottoTicket(List.of(num1, num2, num3, num4, num5, num6));

		assertAll(
			() -> assertThat(lottoTicket.contains(num1)).isTrue(),
			() -> assertThat(lottoTicket.contains(num7)).isFalse()
		);
	}
}
