import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	void 로또_번호는_1이상_45이하여야합니다() {
		assertAll(
			() -> assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new LottoNumber(0)),
			() -> assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new LottoNumber(46))
		);
	}
}
