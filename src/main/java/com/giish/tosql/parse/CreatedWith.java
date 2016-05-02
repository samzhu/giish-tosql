package com.giish.tosql.parse;

import lombok.Data;

/**
 * Created by SAM on 2016/5/1.
 */
@Data
public class CreatedWith {
    private String action; // login or signup
    private String authProvider; // facebook
}
