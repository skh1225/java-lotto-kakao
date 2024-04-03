package controller;

import domain.Cash;
import domain.LottoGame;
import domain.LottoNumber;
import domain.LottoTicket;
import domain.LottoTickets;
import domain.LottoWinningTicket;
import ui.LottoView;

public class LottoController {

	public void play() {
		Cash cash = LottoView.getCash();

		int countOfTickets = cash.getTicketCount();
		LottoView.displayPaidTicketCount(countOfTickets);

		LottoTickets lottoTickets = LottoTickets.ofRandom(countOfTickets);
		LottoView.displayLottoTickets(lottoTickets);

		LottoTicket winningTicket = LottoView.getWinningNumbers();
		LottoNumber bonusNumber = LottoView.getBonusNumber();
		LottoWinningTicket lottoWinningNumbers = new LottoWinningTicket(winningTicket, bonusNumber);

		LottoGame lottoGame = new LottoGame(lottoTickets, lottoWinningNumbers);
		LottoView.displayResult(lottoGame.calculateResult());
	}
}
