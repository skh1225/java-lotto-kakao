package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
	private final List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public void addRandomLottoTicket(int count) {
		for (int i = 0; i < count; i++) {
			this.lottoTickets.add(LottoTicketGenerator.generateRandomLottoTicket());
		}
	}

	public List<LottoTicket> getLottoTickets() {
		return Collections.unmodifiableList(lottoTickets);
	}
}
