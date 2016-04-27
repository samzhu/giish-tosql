package com.giish.tosql.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.giish.tosql.domain.Gift;
import com.giish.tosql.domain.Trade;
import com.giish.tosql.repository.GiftRepository;
import com.giish.tosql.repository.Parse;
import com.giish.tosql.repository.TradeRepository;
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

    @Scheduled(fixedRate = 5 * 60 * 1000, initialDelay = 1 * 1000)
    public void job(){
        Parse parse = new Parse(parseApplicationId, parseRESTAPIKey, "Gift");
        JSONArray jsonArray = parse.listAll();
        List<Gift> giftlist = JSON.parseArray(jsonArray.toJSONString(), Gift.class);
        for(Gift gift :giftlist){
            //System.out.println(gift.getGiftReceiveCondition());
            giftRepository.save(gift);
        }
        parse = new Parse(parseApplicationId, parseRESTAPIKey, "Trade");
        jsonArray = parse.listAll();
        List<Trade> tradelist = JSON.parseArray(jsonArray.toJSONString(), Trade.class);
        for(Trade trade :tradelist){
            //System.out.println(gift.getGiftReceiveCondition());
            tradeRepository.save(trade);
        }
        System.out.println("結束");
    }
}
