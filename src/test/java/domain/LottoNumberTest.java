package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	void 로또_번호는_1이상_45이하여야합니다() {
		assertAll(
			() -> assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> LottoNumber.of(0)),
			() -> assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> LottoNumber.of(46))
		);
	}

	@Test
	void 가능한_모든_로또_번호_리스트_반환() {
		assertThat(LottoNumber.values().size()).isEqualTo(45);
	}
}
