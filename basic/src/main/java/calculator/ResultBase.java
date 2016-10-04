package calculator;

public abstract class ResultBase<T> implements Result<T> {
    protected final T resultValue;

    public ResultBase(T resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public T value() {
        return resultValue;
    }
}
