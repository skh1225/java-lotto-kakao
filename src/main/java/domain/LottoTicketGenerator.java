package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator {
	public static LottoTicket generateRandomLottoTicket() {
		List<LottoNumber> shuffledNumbers = getShuffledNumbers();
		return new LottoTicket(shuffledNumbers.subList(0, LottoTicket.LOTTO_NUMBER_COUNT));
	}

	public static LottoTickets generateRandomLottoTickets(int countOfTickets) {
		List<LottoTicket> lottoTickets = new ArrayList<>();

		for (int i = 0; i < countOfTickets; i++) {
			lottoTickets.add(LottoTicketGenerator.generateRandomLottoTicket());
		}

		return new LottoTickets(lottoTickets);
	}

	private static List<LottoNumber> getShuffledNumbers() {
		List<LottoNumber> shuffledNumbers = new ArrayList<>(LottoNumber.values());
		Collections.shuffle(shuffledNumbers);
		return shuffledNumbers;
	}
}
