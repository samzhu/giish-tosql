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
public class Comment implements Serializable {
    @Id
    @Column(name = "objectid")
    private String objectId;
    @Column(name = "giftid")
    private String giftId;
    @Column(name = "giftname")
    private String giftName;
    @Column(name = "isinvitedtrading")
    private Boolean isInvitedTrading; // false ??
    @Column(name = "posterid")
    private String posterId;
    @Column(name = "posteraccountname")
    private String posterAccountName;
    @Column(name = "commentposterid")
    private String commentPosterId;
    @Column(name = "senderaccountname")
    private String senderAccountName; // 留言者名稱 ??
    private Integer type; // 1 ??
    private String content; // 請問可以郵寄嗎？
    @Column(name = "createdat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd'T'HHmmss.SSS'Z'")
    @Column(name = "updatedat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;
}
