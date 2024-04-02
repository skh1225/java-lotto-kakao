import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@ParameterizedTest
	@CsvSource({
		"1, 2, 3, 4, 5, 6, 6",
		"4, 2, 3, 1, 5, 8, 5",
		"9, 8, 1, 2, 3, 4, 4"})
	void 두_로또_번호_사이의_동일한_번호의_갯수를_반환할_수_있다(int number1, int number2, int number3, int number4, int number5, int number6, int matchCount) {
		LottoNumber num1 = new LottoNumber(1);
		LottoNumber num2 = new LottoNumber(2);
		LottoNumber num3 = new LottoNumber(3);
		LottoNumber num4 = new LottoNumber(4);
		LottoNumber num5 = new LottoNumber(5);
		LottoNumber num6 = new LottoNumber(6);
		LottoTicket lottoTicket1 = new LottoTicket(List.of(num1, num2, num3, num4, num5, num6));

		LottoTicket lottoTicket2 = new LottoTicket(List.of(new LottoNumber(number1), new LottoNumber(number2), new LottoNumber(number3), new LottoNumber(number4), new LottoNumber(number5), new LottoNumber(number6)));

		assertThat(lottoTicket1.countSameNumbers(lottoTicket2)).isEqualTo(matchCount);
	}
}
