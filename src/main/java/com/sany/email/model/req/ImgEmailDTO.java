package com.sany.email.model.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gali
 * 图片邮件
 */
@Data
public class ImgEmailDTO implements Serializable {
    public ImgEmailDTO() {
    }

    /**
     * 图片路径
     */
    private String imgPath;

    /**
     * 资源id
     */
    private String rscId;

    /**
     * 主题
     */
    private String subject;

    /**
     * 图片正文（同样可以使用html）
     */
    private String imgContent;

    /**
     * 收件人
     */
    private String to;
}
