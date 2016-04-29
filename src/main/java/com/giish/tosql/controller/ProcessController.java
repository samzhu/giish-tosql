package com.giish.tosql.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

/**
 * Created by SAM on 2016/4/29.
 */
@RestController
@RequestMapping(value = "/api")
public class ProcessController {
    private static Hashtable<String, String> processSet = new Hashtable();
    private static Hashtable<String, Integer> processCount = new Hashtable();

    public static void startProcess(String processName) {
        if (processCount.get(processName) == null) {
            processCount.put(processName, 1);
        } else {
            Integer count = processCount.get(processName);
            processCount.put(processName, count + 1);
        }
    }

    public static void setProcessData(String processName, String processData) {
        processSet.put(processName, processData);
    }

    @RequestMapping("/process")
    public Hashtable message() {
        Hashtable<String, String> result = new Hashtable();
        processSet.forEach((k, v) -> {
            Integer count = processCount.get(k);
            if (count != null) {
                result.put(k, String.format("第 %d 次執行, %s", count, v));
            } else {
                result.put(k, v);
            }
        });
        return result;
    }
}
