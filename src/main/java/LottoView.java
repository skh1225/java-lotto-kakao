import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoView {

	private static final Scanner scanner = new Scanner(System.in);

	public Cash getCash() {
		System.out.println("구입금액을 입력해 주세요.");
		return new Cash(Integer.parseInt(scanner.nextLine()));
	}

	public void displayPaidTicketCount(int ticketCount) {
		System.out.printf("%d개를 구매했습니다.%n", ticketCount);
	}

	public void displayLottoTickets(LottoTickets lottoTickets) {
		StringBuilder builder = new StringBuilder();
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			builder.append(lottoTicket.toString());
			builder.append("\n");
		}
		System.out.println(builder);
	}

	public LottoTicket getWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String line = scanner.nextLine();
		List<Integer> numberStrings = Stream.of(line.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toUnmodifiableList());
		return LottoTicket.of(numberStrings);
	}

	public LottoNumber getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return new LottoNumber(Integer.parseInt(scanner.nextLine()));
	}

	public void displayResult(LottoGameResult lottoGameResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		StringBuilder builder = new StringBuilder();
		for (LottoWinningRank lottoWinningRank : LottoWinningRank.values()) {
			if (lottoWinningRank == LottoWinningRank.LOSE) {
				continue;
			}

			builder.append(String.format("%d개 일치 ", lottoWinningRank.getMatchCount()));

			if (lottoWinningRank.requireBonusNumber()) {
				builder.deleteCharAt(builder.length() - 1);
				builder.append(", 보너스 볼 일치");
			}

			builder.append(String.format("(%d원) - %d개", lottoWinningRank.getPrize(), lottoGameResult.getCount(lottoWinningRank)));
			builder.append("\n");
		}

		builder.append(String.format("총 수익률은 %.2f입니다.", lottoGameResult.calculateYield()));

		if (lottoGameResult.calculateYield() < 1.0) {
			builder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}

		System.out.println(builder);
	}
}