package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator {
	public static LottoTicket generateRandomLottoTicket() {
		List<LottoNumber> shuffledNumbers = getShuffledNumbers();
		return new LottoTicket(shuffledNumbers.subList(0, LottoTicket.LOTTO_NUMBER_COUNT));
	}

	private static List<LottoNumber> getShuffledNumbers() {
		List<LottoNumber> shuffledNumbers = new ArrayList<>(LottoNumber.values());
		Collections.shuffle(shuffledNumbers);
		return shuffledNumbers;
	}
}
