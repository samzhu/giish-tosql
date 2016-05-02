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
public class Notification implements Serializable {
    @Id
    @Column(name = "objectid")
    private String objectId;
    @Column(name = "giftid")
    private String giftId;
    @Column(name = "isread")
    private Boolean isRead; // API ?

    private String message;
    @Column(name = "notificationtype")
    private Integer notificationType; // 有哪幾種 ?
    @Column(name = "posterid")
    private String posterId; // 送禮方
    @Column(name = "receivedid")
    private String receivedId; // 收禮方
    @Column(name = "senderid")
    private String senderId; // pTVNUQroXG 系統??
    @Column(name = "createdat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd'T'HHmmss.SSS'Z'")
    @Column(name = "updatedat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;
}
