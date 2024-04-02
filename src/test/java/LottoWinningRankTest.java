import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningRankTest {
	@ParameterizedTest
	@CsvSource({
		"6, LOTTO_FIRST_PRIZE",
		"5, LOTTO_THIRD_PRIZE",
		"4, LOTTO_FOURTH_PRIZE",
		"3, LOTTO_FIFTH_PRIZE",
		"2, LOTTO_LOSE",
		"1, LOTTO_LOSE",
		"0, LOTTO_LOSE",
	})
	void 보너스_번호가_불일치하는_경우_로또_순위를_계산(int matchCount, LottoWinningRank lottoWinningRank) {
		assertThat(LottoWinningRank.calculateRank(matchCount, false)).isEqualTo(lottoWinningRank);
	}

	@ParameterizedTest
	@CsvSource({
		"6, LOTTO_FIRST_PRIZE",
		"5, LOTTO_SECOND_PRIZE",
		"4, LOTTO_FOURTH_PRIZE",
		"3, LOTTO_FIFTH_PRIZE",
		"2, LOTTO_LOSE",
		"1, LOTTO_LOSE",
		"0, LOTTO_LOSE",
	})
	void 보너스_번호가_일치하는_경우_로또_순위를_계산(int matchCount, LottoWinningRank lottoWinningRank) {
		assertThat(LottoWinningRank.calculateRank(matchCount, true)).isEqualTo(lottoWinningRank);
	}
}
