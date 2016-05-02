package com.giish.tosql.parse;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ParseUser {

    private AuthData authData;

    private String sessionToken;

    private String objectId;
    private String email;
    private String userPhotoUrl;
    private String city;
    private String intro;
    private Integer sendGiftCount;
    private Integer receivedGiftCount;
    //username
    //Fb登入時會自動產生的字串，email註冊的話會是email，有驗證手機會是手機號碼
    //這個欄位的東西配上password 就可以登入這個帳號
    private String username;
    private String accountName;
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;
}
