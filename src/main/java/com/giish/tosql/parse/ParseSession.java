package com.giish.tosql.parse;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * Created by SAM on 2016/5/1.
 */
@Data
public class ParseSession {
    private String objectId;
    private Boolean restricted;
    private String sessionToken;
    private CreatedWith createdWith;
    private ParseSessionUser user;
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updatedAt;
}
