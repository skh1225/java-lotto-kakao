import java.util.List;

public class LottoTicket {
	private static final int LOTTO_NUMBER_COUNT = 6;
	public static final int PRICE = 1000;

	private final List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		validateSize(lottoNumbers);
		validateDuplicate(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	private void validateSize(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(String.format("로또 번호는 %d개 입니다.", LOTTO_NUMBER_COUNT));
		}
	}

	private void validateDuplicate(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}
}