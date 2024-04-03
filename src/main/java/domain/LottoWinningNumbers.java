package domain;

public class LottoWinningNumbers {

	private final LottoTicket winningNumbers;
	private final LottoNumber bonusNumber;

	public LottoWinningNumbers(LottoTicket winningNumbers, LottoNumber bonusNumber) {
		validateDuplicateBonusNumber(winningNumbers, bonusNumber);
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	private void validateDuplicateBonusNumber(LottoTicket winningNumbers, LottoNumber bonusNumber) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(String.format("보너스 번호는 당첨 번호에 포함되선 안됩니다. LottoTicket: %s, bonusNumber: %s", winningNumbers, bonusNumber));
		}
	}

	public LottoWinningRank calculateResult(LottoTicket lottoTicket) {
		return LottoWinningRank.calculateRank(lottoTicket.countSameNumbers(winningNumbers), lottoTicket.contains(bonusNumber));
	}
}
