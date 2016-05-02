package com.giish.tosql.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by SAM on 2016/4/20.
 */
@Data
@Entity
public class Gift implements Serializable {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "objectid")
    private String objectId;
    // 城市 ex:台北
    @Column(name = "giftcity")
    private String giftCity;
    // 區域 ex:士林區
    @Column(name = "giftdistrict")
    private String giftDistrict;
    // 名稱
    @Column(name = "giftname")
    private String giftName;
    // 描述
    @Column(name = "giftdescription")
    private String giftDescription;
    // 領取條件
    @Column(name = "giftreceivecondition")
    private String giftReceiveCondition;
    // 大圖 url
    @Column(name = "giftimage")
    private String giftImage;
    // 小圖 url
    @Column(name = "giftsmallimage")
    private String giftSmallImage;
    // 追蹤人數
    @Column(name = "giftlikecount")
    private Integer giftlikeCount;
    // 不知
    @Column(name = "isremoved")
    private Boolean isRemoved;
    // 不知
    @Column(name = "issoldout")
    private Boolean isSoldOut;
    // 緯度
    @Column(name = "giftlatitude")
    private Double giftLatitude;
    // 經度
    @Column(name = "giftlongitude")
    private Double giftLongitude;
    //private Location location;
    // 送禮者
    @Column(name = "userid")
    private String userId;
    //private Poster poster;
    // 時間
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd'T'HHmmss.SSS'Z'")
    @Column(name = "createdat")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd'T'HHmmss.SSS'Z'")
    @Column(name = "updatedat")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User posteruser;

    @OneToMany()
    @JoinColumn(name = "giftid", insertable = false, updatable = false)
    public List<Follow> follows;

    @OneToMany()
    @JoinColumn(name = "giftid", insertable = false, updatable = false)
    public List<Comment> comments;

    @OneToMany()
    @JoinColumn(name = "giftid", insertable = false, updatable = false)
    public List<Trade> trades;
}
