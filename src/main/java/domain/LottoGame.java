package domain;

public class LottoGame {

	private final LottoTickets lottoTickets;
	private final WinningLottoTicket winningLottoTicket;

	public LottoGame(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
		this.lottoTickets = lottoTickets;
		this.winningLottoTicket = winningLottoTicket;
	}

	public LottoGameResult calculateGameResult() {
		return LottoGameResult.of(winningLottoTicket.calculateResults(this.lottoTickets));
	}
}
