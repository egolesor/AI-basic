package calculator.model;

public abstract class ResultBase<RESULT_TYPE> implements Result<RESULT_TYPE> {
    protected final RESULT_TYPE resultValue;

    public ResultBase(RESULT_TYPE resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public RESULT_TYPE value() {
        return resultValue;
    }
}
