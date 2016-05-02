package com.giish.tosql.parse;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * Created by SAM on 2016/4/30.
 */
@Data
public class Facebook {
    private String id;
    @JSONField(name = "access_token")
    private String accessToken;

    //2016-05-12T19:38:40.195Z
    @JSONField(name = "expiration_date", format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date expirationDate;

}
