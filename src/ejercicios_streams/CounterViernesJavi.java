package ejercicios_streams;

public class CounterViernesJavi {

	private int value = 0;
	private int maxValue = 100_000;
	private String model = "N-COUNTER";

	public int getValue() {
		return value;
	}

	public CounterViernesJavi() {
	}

	public CounterViernesJavi(int maxValue) {
		// this (maxValue, "N-COUNTER");
		this.maxValue = maxValue < 10 ? 10 : maxValue;
	}

	public CounterViernesJavi(int maxValue, String model) {
		this.maxValue = maxValue < 10 ? 10 : maxValue;
		this.model = model;
	}

	// constructor copia
	public CounterViernesJavi(CounterViernesJavi counter) {
		value = counter.value;
		maxValue = counter.maxValue;
		model = counter.model;
	}

	@Override
	public String toString() {
		return String.format("CONTADOR: %nModelo: %s %nValor %d de %d %n", model, value, maxValue);
	}

	public boolean increment() {
		return increment(1);
	}

	public boolean increment(int n) {
		if (n <= 0)
			return false;

		if (value + n <= maxValue) {
			value += n;
			return true;
		}
		return false;
	}

	public boolean reset() {
		if (value == maxValue) {
			value = 0;
			return true;
		}
		return false;
	}

}
