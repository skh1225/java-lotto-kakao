import java.util.List;

public class LottoGame {

	private final List<LottoTicket> lottoTickets;
	private final LottoWinningNumbers lottoWinningNumbers;

	public LottoGame(List<LottoTicket> lottoTickets, LottoWinningNumbers lottoWinningNumbers) {
		this.lottoTickets = lottoTickets;
		this.lottoWinningNumbers = lottoWinningNumbers;
	}

	public LottoGameResult calculateResult() {
		LottoGameResult result = new LottoGameResult();
		for (LottoTicket lottoTicket : lottoTickets) {
			LottoWinningRank lottoWinningRank = lottoWinningNumbers.calculateResult(lottoTicket);
			result.add(lottoWinningRank);
		}
		return result;
	}
}
