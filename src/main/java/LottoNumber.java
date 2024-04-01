public class LottoNumber {
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private final int value;

	public LottoNumber(int value) {
		validateLottoNumber(value);
		this.value = value;
	}

	private void validateLottoNumber(int value) {
		if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException(String.format("로또 번호는 %d이상 %d이하 여야합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
		}
	}
}
