package controller;

import domain.Cash;
import domain.LottoGame;
import domain.LottoGameResult;
import domain.LottoNumber;
import domain.LottoTicket;
import domain.LottoTickets;
import domain.WinningLottoTicket;
import ui.LottoView;

public class LottoController {

	public void play() {
		LottoTickets lottoTickets = buyLottoTickets();

		WinningLottoTicket lottoWinningNumbers = inputLottoWinningTicket();

		LottoGameResult lottoGameResult = runLottoGame(lottoTickets, lottoWinningNumbers);

		displayLottoGameResult(lottoGameResult);
	}

	private static void displayLottoGameResult(LottoGameResult lottoGameResult) {
		LottoView.displayResult(lottoGameResult);
		LottoView.displayYield(lottoGameResult.calculateYield());
	}

	private static LottoGameResult runLottoGame(LottoTickets lottoTickets,
		WinningLottoTicket lottoWinningNumbers) {
		LottoGame lottoGame = new LottoGame(lottoTickets, lottoWinningNumbers);
		LottoGameResult lottoGameResult = lottoGame.calculateResult();
		return lottoGameResult;
	}

	private static WinningLottoTicket inputLottoWinningTicket() {
		LottoTicket winningTicket = LottoView.getWinningNumbers();
		LottoNumber bonusNumber = LottoView.getBonusNumber();
		return new WinningLottoTicket(winningTicket, bonusNumber);
	}

	private static LottoTickets buyLottoTickets() {
		Cash cash = LottoView.getCash();
		int countOfTickets = cash.getTicketCount();
		LottoView.displayPaidTicketCount(countOfTickets);

		LottoTickets lottoTickets = LottoTickets.ofRandom(countOfTickets);
		LottoView.displayLottoTickets(lottoTickets);
		return lottoTickets;
	}
}
