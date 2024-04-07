package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
	private final List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = new ArrayList<>(lottoTickets);
	}

	public LottoTickets plus(LottoTickets lottoTicketsToAdd) {
		List<LottoTicket> addedLottoTickets = new ArrayList<>(this.lottoTickets);

		addedLottoTickets.addAll(lottoTicketsToAdd.getLottoTickets());

		return new LottoTickets(addedLottoTickets);
	}

	public List<LottoTicket> getLottoTickets() {
		return Collections.unmodifiableList(lottoTickets);
	}
}
