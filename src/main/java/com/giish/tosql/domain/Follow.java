package com.giish.tosql.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SAM on 2016/4/28.
 */
@Data
@Entity
public class Follow implements Serializable {
    @Id
    @Column(name = "objectid")
    private String objectId;
    @Column(name = "giftid")
    private String giftId;
    @Column(name = "posterid")
    private String posterId;
    @Column(name = "followerid")
    private String followerId;
    @Column(name = "createdat")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    @Column(name = "updatedat")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;

    @OneToOne()
    @JoinColumn(name = "followerid", insertable = false, updatable = false)
    private User followeruser;
}
