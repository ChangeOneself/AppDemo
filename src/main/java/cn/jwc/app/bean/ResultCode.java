package cn.jwc.app.bean;

public enum ResultCode {
    SUCCESS(20000),
    FAIL(40001),
    PART_FAIL(40002);

    private final int resultCode;

    private ResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public int getResultCode() {
        return resultCode;
    }
}
