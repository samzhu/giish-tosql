package com.giish.tosql.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SAM on 2016/5/1.
 */
@Data
@Entity
public class Installation implements Serializable {
    @Id
    private String objectid;
    private String gcmsenderid;
    private String devicetoken; // 5aba2895c19417ec1b12dc706688f3f7b04cbd3b2f06ade2560fc9556bb19fa9
    private String localeidentifier; // zh-TW
    private Integer badge;
    private String parseversion; // 1.13.0
    private String clientid; // 同userId
    private String userid;
    private String appidentifier; // com.gfg.giish or com.gfg.giish-dev
    private String appname; // 給你 or Giish_Dev
    private String devicetype; // ios
    private String installationid; // ?? 438746c0-5807-4c6d-ac12-2d87880ab306
    private String appversion; // 282
    private String timezone; // Asia/Taipei or America/Los_Angeles
    @Column(name = "createdat")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdat;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd'T'HHmmss.SSS'Z'")
    @Column(name = "updatedat")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedat;
}
