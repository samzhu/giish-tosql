package com.giish.tosql.domain;

import lombok.Data;

/**
 * Created by SAM on 2016/4/28.
 */
@Data
public class Follow {
    private String createdAt;
    private String followerId;
    private String giftId;
    private String objectId;
    private String posterId;
    private String updatedAt;
}
