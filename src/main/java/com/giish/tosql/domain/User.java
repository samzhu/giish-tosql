package com.giish.tosql.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * parse API有兩種用法
 * https://api.parse.com/1/users?limit=100&skip=100&order=-createdAt
 * https://api.parse.com/1/classes/_User?limit=100&skip=100&order=-createdAt
 *
 * Created by SAM on 2016/4/28.
 */
@Data
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @Column(name = "objectid")
    private String objectId;

    @Column(name = "email")
    private String email;

    // 使用者的大頭照
    @Column(name = "userphotourl")
    private String userPhotoUrl;
    // ?
    //@Column(name = "imageurl")
    //private String imageUrl;
    // ?
    //@Column(name = "userimage")
    //private String userImage;

    // 臺北市
    @Column(name = "city")
    private String city;
    // 新北市 or 未設定....
    @Column(name = "area")
    private String area;

    // 自我介紹
    @Column(name = "intro")
    private String intro;
    // 送出計數器
    @Column(name = "sendgiftcount")
    private Integer sendGiftCount;
    // 收禮計數器
    @Column(name = "receivedgiftcount")
    private Integer receivedGiftCount;

    // xLvZjlNuG6x1EqeHuzGHs0kOZ or email or 電話 ?
    @Column(name = "username")
    private String username;
    // 自行輸入的姓名
    @Column(name = "accountname")
    private String accountName;

    private String authtype;
    private String authid;
    private String authaccesstoken;
    private Date authexpirationdate;

    @Column(name = "createdat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    @Column(name = "updatedat")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;

    @OneToMany()
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    public List<Gift> gifts;


}
