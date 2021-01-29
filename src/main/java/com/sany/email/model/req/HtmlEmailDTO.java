package com.sany.email.model.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author SANY
 * html格式邮件
 */
@Data
public class HtmlEmailDTO implements Serializable {

    public HtmlEmailDTO() {
    }

    /**
     * 收件人
     */
    @NotNull
    private String to;
    /**
     * html格式的内容
     */
    @NotNull
    private String htmlContent;

    /**
     * 主题
     */
    @NotNull
    private String subject;
}
