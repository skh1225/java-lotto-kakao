import domain.Cash;
import domain.LottoGame;
import domain.LottoNumber;
import domain.LottoTicket;
import domain.LottoTickets;
import domain.LottoWinningNumbers;

public class LottoController {
	private final LottoView view;

	public LottoController(LottoView view) {
		this.view = view;
	}

	public void play() {
		Cash cash = view.getCash();
		view.displayPaidTicketCount(cash.getTicketCount());

		LottoTickets lottoTickets = LottoTickets.ofRandom(cash.getTicketCount());
		view.displayLottoTickets(lottoTickets);

		LottoTicket winningTicket = view.getWinningNumbers();
		LottoNumber bonusNumber = view.getBonusNumber();
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningTicket, bonusNumber);

		LottoGame lottoGame = new LottoGame(lottoTickets, lottoWinningNumbers);
		view.displayResult(lottoGame.calculateResult());
	}
}
