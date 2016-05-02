package com.giish.tosql.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SAM on 2016/4/25.
 */
@Data
@Entity
public class Trade implements Serializable {
    @Id
    @Column(name = "objectid")
    private String objectId;
    @Column(name = "giftid")
    private String giftId;
    @Column(name = "posterid")
    private String posterId;
    @Column(name = "tradetouserid")
    private String tradeToUserId;
    @Column(name = "createdat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    @Column(name = "updatedat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;

    @OneToOne()
    @JoinColumn(name = "giftid", insertable = false, updatable = false)
    private Gift gift;

    @OneToOne()
    @JoinColumn(name = "posterid", insertable = false, updatable = false)
    private User posteruser;

    @OneToOne()
    @JoinColumn(name = "tradetouserid", insertable = false, updatable = false)
    private User tradeToUser;


}
