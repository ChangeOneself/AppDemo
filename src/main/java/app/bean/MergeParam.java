package app.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

public class MergeParam implements Serializable {
    private String xmlName;
    private String local;
    private List<CsvDownLoadParam> csvFile;

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<CsvDownLoadParam> getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(List<CsvDownLoadParam> csvFile) {
        this.csvFile = csvFile;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
