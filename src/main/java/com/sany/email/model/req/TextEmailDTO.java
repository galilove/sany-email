package com.sany.email.model.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gali
 * 文本邮件信息
 */
@Data
public class TextEmailDTO implements Serializable {

    public TextEmailDTO(){

    }
    /**
     * 收件人
     */
    @NotNull
    private String to;

    /**
     * 邮件内容
     */
    @NotNull
    private String content;

    /**
     * 主题
     */
    @NotNull
    private String subject;


}
