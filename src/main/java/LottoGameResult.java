import java.util.HashMap;
import java.util.Map;

public class LottoGameResult {

	private final Map<LottoWinningRank, Integer> rankCounts = new HashMap<>();

	public LottoGameResult() {
		for (LottoWinningRank lottoWinningRank : LottoWinningRank.values()) {
			rankCounts.put(lottoWinningRank, 0);
		}
	}

	public void add(LottoWinningRank lottoWinningRank) {
		rankCounts.put(lottoWinningRank, rankCounts.get(lottoWinningRank) + 1);
	}

	public int getCount(LottoWinningRank lottoWinningRank) {
		return rankCounts.get(lottoWinningRank);
	}
}
