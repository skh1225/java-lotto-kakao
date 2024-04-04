package controller;

import java.util.ArrayList;
import java.util.List;

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

	private static LottoTickets buyLottoTickets() {
		Cash cash = LottoView.getCash();
		int countOfManualTickets = LottoView.getCountOfManualTickets();
		cash.purchase(LottoTicket.PRICE, countOfManualTickets);
		LottoTickets lottoTickets = LottoView.getManualLottoTickets(countOfManualTickets);

		int countOfRandomTickets = cash.getTicketCount();
		lottoTickets.addRandomLottoTicket(countOfRandomTickets);

		LottoView.displayPaidTicketCount(countOfManualTickets, countOfRandomTickets);
		LottoView.displayLottoTickets(lottoTickets);
		return lottoTickets;
	}

	private static WinningLottoTicket inputLottoWinningTicket() {
		LottoTicket winningTicket = LottoView.getWinningNumbers();
		LottoNumber bonusNumber = LottoView.getBonusNumber();
		return new WinningLottoTicket(winningTicket, bonusNumber);
	}

	private static LottoGameResult runLottoGame(LottoTickets lottoTickets,
		WinningLottoTicket lottoWinningNumbers) {
		LottoGame lottoGame = new LottoGame(lottoTickets, lottoWinningNumbers);
		return lottoGame.calculateResult();
	}

	private static void displayLottoGameResult(LottoGameResult lottoGameResult) {
		LottoView.displayResult(lottoGameResult);
		LottoView.displayYield(lottoGameResult.calculateYield());
	}
}
