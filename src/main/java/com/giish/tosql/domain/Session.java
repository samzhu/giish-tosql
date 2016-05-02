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
public class Session implements Serializable {
    @Id
    @Column(name = "objectid")
    private String objectId;

    private Boolean restricted;
    @Column(name = "sessiontoken")
    private String sessionToken;

    private String createdaction; // login or signup
    private String authprovider; // facebook
    private String userid;

    @Column(name = "createdat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    @Column(name = "updatedat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;
}
