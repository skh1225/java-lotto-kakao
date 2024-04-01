import java.util.Objects;

public class LottoResult {
	private final int sameNumberCount;
	private final boolean hasBonusNumber;

	public LottoResult(int sameNumberCount, boolean hasBonusNumber) {
		this.sameNumberCount = sameNumberCount;
		this.hasBonusNumber = hasBonusNumber;
	}

	public int getSameNumberCount() {
		return sameNumberCount;
	}

	public boolean isHasBonusNumber() {
		return hasBonusNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoResult that = (LottoResult)o;
		return sameNumberCount == that.sameNumberCount && hasBonusNumber == that.hasBonusNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sameNumberCount, hasBonusNumber);
	}
}
