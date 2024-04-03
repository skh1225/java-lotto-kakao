package controller;

import domain.Cash;
import domain.LottoGame;
import domain.LottoNumber;
import domain.LottoTicket;
import domain.LottoTickets;
import domain.LottoWinningNumbers;

public class LottoController {

	public void play() {
		Cash cash = LottoView.getCash();
		LottoView.displayPaidTicketCount(cash.getTicketCount());

		LottoTickets lottoTickets = LottoTickets.ofRandom(cash.getTicketCount());
		LottoView.displayLottoTickets(lottoTickets);

		LottoTicket winningTicket = LottoView.getWinningNumbers();
		LottoNumber bonusNumber = LottoView.getBonusNumber();
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningTicket, bonusNumber);

		LottoGame lottoGame = new LottoGame(lottoTickets, lottoWinningNumbers);
		LottoView.displayResult(lottoGame.calculateResult());
	}
}
