package com.giish.tosql.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.giish.tosql.domain.Gift;
import com.giish.tosql.domain.Trade;
import com.giish.tosql.domain.User;
import com.giish.tosql.repository.GiftRepository;
import com.giish.tosql.repository.Parse;
import com.giish.tosql.repository.TradeRepository;
import com.giish.tosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by SAM on 2016/4/27.
 */
@Component
public class JobCopyDataToSQL {

    @Value("${parse.ApplicationId}")
    private String parseApplicationId;
    @Value("${parse.RESTAPIKey}")
    private String parseRESTAPIKey;

    @Autowired
    private GiftRepository giftRepository;
    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private AsyncWorker worker;

    @Autowired
    private UserRepository userRepository;

    @Scheduled(fixedRate = 30 * 60 * 1000, initialDelay = 1 * 1000)
    public void job() {

        worker.copyUser();
        worker.copyGift();
        worker.copyTrade();
        worker.copyFollow();
        worker.copyComment();
        worker.copyNotification();
        worker.copySession();
        worker.copyInstallation();


    }
}
