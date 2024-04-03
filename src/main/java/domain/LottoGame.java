package domain;

public class LottoGame {

	private final LottoTickets lottoTickets;
	private final WinningLottoTicket lottoWinningNumbers;

	public LottoGame(LottoTickets lottoTickets, WinningLottoTicket lottoWinningNumbers) {
		this.lottoTickets = lottoTickets;
		this.lottoWinningNumbers = lottoWinningNumbers;
	}

	public LottoGameResult calculateResult() {
		LottoGameResult result = new LottoGameResult();
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			LottoWinningRank lottoWinningRank = lottoWinningNumbers.calculateResult(lottoTicket);
			result.add(lottoWinningRank);
		}
		return result;
	}
}
