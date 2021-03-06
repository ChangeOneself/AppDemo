package app.bean;

public enum ResponseCode {
    NOTHING(),SUCCESS(20000),FAILURE(40001),PART_SUCCESS("part success",40002);

    private String description;

    private int code;

    private ResponseCode(){
    }

    // 在枚举类中构造方法都是private的
    private ResponseCode(int code){
        this.code = code;
    }

    private ResponseCode(String description,int code){
        this.description = description;
        this.code = code;
    }

    public int getResponseCode(){
        return code;
    }

    public String getResponseDescription(){
        return description;
    }
}
