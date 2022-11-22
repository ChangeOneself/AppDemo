package cn.jwc.app.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @program: AppDemo
 * @description: 请求结果Response
 * @author: Mr.Jiang
 * @create: 2022-11-22 23:20
 **/
@Data
@Builder
public class ResultResponse {
    private int resultCode;
    private String resultMessage;
    private String description;
}
