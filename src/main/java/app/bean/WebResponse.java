package app.bean;

import org.springframework.stereotype.Component;

@Component
public class WebResponse {
    private ResponseCode resultCode;
    private String description;
    private String resultUri;

    public ResponseCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResponseCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResultUri() {
        return resultUri;
    }

    public void setResultUri(String resultUri) {
        this.resultUri = resultUri;
    }
}
