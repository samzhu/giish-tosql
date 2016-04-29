package com.giish.tosql.job;

import com.alibaba.fastjson.JSON;
import com.giish.tosql.controller.ProcessController;
import com.giish.tosql.domain.Gift;
import com.giish.tosql.domain.Trade;
import com.giish.tosql.domain.User;
import com.giish.tosql.repository.GiftRepository;
import com.giish.tosql.repository.Parse;
import com.giish.tosql.repository.TradeRepository;
import com.giish.tosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by SAM on 2016/4/29.
 */
@Component
public class AsyncWorker {
    @Value("${parse.ApplicationId}")
    private String parseApplicationId;
    @Value("${parse.RESTAPIKey}")
    private String parseRESTAPIKey;

    @Autowired
    private GiftRepository giftRepository;
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private UserRepository userRepository;

    @Async
    public void copyUser() {
        String className = "_User";
        Parse parse = new Parse<User>(this.parseApplicationId, this.parseRESTAPIKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<User> userlist = parse.listAllClazz(User.class);
        ProcessController.setProcessData(className, "取得資料共" + userlist.size());
        for (int i = 0; i < userlist.size(); i++) {
            User user = userlist.get(i);
            userRepository.save(user);
            Double percentage = (Double.valueOf((i + 1)) / userlist.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", userlist.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, String.format("%s 已經更新%d筆", this.getTime(), userlist.size()));
    }

    @Async
    public void copyGift() {
        String className = "Gift";
        Parse parse = new Parse<Gift>(parseApplicationId, parseRESTAPIKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<Gift> giftlist = parse.listAllClazz(Gift.class);
        ProcessController.setProcessData(className, "取得資料共" + giftlist.size());
        for (int i = 0; i < giftlist.size(); i++) {
            Gift gift = giftlist.get(i);
            giftRepository.save(gift);
            Double percentage = (Double.valueOf((i + 1)) / giftlist.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", giftlist.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, String.format("%s 已經更新%d筆", this.getTime(), giftlist.size()));
    }

    @Async
    public void copyTrade() {
        String className = "Trade";
        Parse parse = new Parse(parseApplicationId, parseRESTAPIKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<Trade> tradelist = parse.listAllClazz(Trade.class);
        ProcessController.setProcessData(className, "取得資料共" + tradelist.size());
        for (int i = 0; i < tradelist.size(); i++) {
            Trade trade = tradelist.get(i);
            tradeRepository.save(trade);
            Double percentage = (Double.valueOf((i + 1)) / tradelist.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", tradelist.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, String.format("%s 已經更新%d筆", this.getTime(), tradelist.size()));
    }

    private String getTime() {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        isoFormat.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
        String dateStr = isoFormat.format(new Date());
        return dateStr;
    }
}
