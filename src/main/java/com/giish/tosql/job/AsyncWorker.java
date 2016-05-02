package com.giish.tosql.job;

import com.alibaba.fastjson.JSON;
import com.giish.tosql.controller.ProcessController;
import com.giish.tosql.domain.*;
import com.giish.tosql.parse.*;
import com.giish.tosql.repository.*;
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
    @Value("${parse.MasterKey}")
    private String parseMasterKey;


    @Autowired
    private GiftRepository giftRepository;
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private InstallationRepository installationRepository;

    //@Async
    public void copyUser() {
        String className = "_User";
        Parse parse = new Parse<ParseUser>(this.parseApplicationId, this.parseRESTAPIKey, this.parseMasterKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<ParseUser> list = parse.listAllClazz(ParseUser.class);
        ProcessController.setProcessData(className, "取得資料共" + list.size());
        for (int i = 0; i < list.size(); i++) {
            ParseUser parseUser = list.get(i);
            AuthData authdata = parseUser.getAuthData();
            User user = JSON.parseObject(JSON.toJSONString(parseUser), User.class);
            if(authdata != null && authdata.getAnonymous() != null){
                user.setAuthtype("anonymous");
                user.setAuthid(authdata.getAnonymous().getId());
            }else if(authdata != null && authdata.getFacebook() != null){
                user.setAuthtype("facebook");
                user.setAuthid(authdata.getFacebook().getId());
                user.setAuthaccesstoken(authdata.getFacebook().getAccessToken());
                user.setAuthexpirationdate(authdata.getFacebook().getExpirationDate());
            }
            userRepository.save(user);
            Double percentage = (Double.valueOf((i + 1)) / list.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", list.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + list.size());
    }

    //@Async
    public void copyGift() {
        String className = "Gift";
        Parse parse = new Parse<Gift>(parseApplicationId, parseRESTAPIKey, this.parseMasterKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<Gift> list = parse.listAllClazz(Gift.class);
        ProcessController.setProcessData(className, "取得資料共" + list.size());
        for (int i = 0; i < list.size(); i++) {
            Gift gift = list.get(i);
            giftRepository.save(gift);
            Double percentage = (Double.valueOf((i + 1)) / list.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", list.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + list.size());
    }

    //@Async
    public void copyTrade() {
        String className = "Trade";
        Parse parse = new Parse(parseApplicationId, parseRESTAPIKey, this.parseMasterKey, className);
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
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + tradelist.size());
    }

    @Async
    public void copyFollow(){
        String className = "Follow";
        Parse parse = new Parse(parseApplicationId, parseRESTAPIKey, this.parseMasterKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<Follow> list = parse.listAllClazz(Follow.class);
        ProcessController.setProcessData(className, "取得資料共" + list.size());
        for (int i = 0; i < list.size(); i++) {
            Follow follow = list.get(i);
            followRepository.save(follow);
            Double percentage = (Double.valueOf((i + 1)) / list.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", list.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + list.size());
    }

    @Async
    public void copyComment(){
        String className = "Comment";
        Parse parse = new Parse(parseApplicationId, parseRESTAPIKey, this.parseMasterKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<Comment> list = parse.listAllClazz(Comment.class);
        ProcessController.setProcessData(className, "取得資料共" + list.size());
        for (int i = 0; i < list.size(); i++) {
            Comment comment = list.get(i);
            commentRepository.save(comment);
            Double percentage = (Double.valueOf((i + 1)) / list.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", list.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + list.size());
    }

    @Async
    public void copyNotification(){
        String className = "Notification";
        Parse parse = new Parse(parseApplicationId, parseRESTAPIKey, this.parseMasterKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<Notification> list = parse.listAllClazz(Notification.class);
        ProcessController.setProcessData(className, "取得資料共" + list.size());
        for (int i = 0; i < list.size(); i++) {
            Notification notification = list.get(i);
            notificationRepository.save(notification);
            Double percentage = (Double.valueOf((i + 1)) / list.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", list.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + list.size());
    }


    @Async
    public void copySession() {
        String className = "_Session";
        Parse parse = new Parse<ParseUser>(this.parseApplicationId, this.parseRESTAPIKey, this.parseMasterKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<ParseSession> list = parse.listAllClazz(ParseSession.class);
        ProcessController.setProcessData(className, "取得資料共" + list.size());
        for (int i = 0; i < list.size(); i++) {
            ParseSession parseSession = list.get(i);
            ParseSessionUser user = parseSession.getUser();
            CreatedWith createdWith = parseSession.getCreatedWith();
            Session session = JSON.parseObject(JSON.toJSONString(parseSession), Session.class);
            session.setUserid(user.getObjectId());
            session.setCreatedaction(createdWith.getAction());
            session.setAuthprovider(createdWith.getAuthProvider());
            sessionRepository.save(session);
            Double percentage = (Double.valueOf((i + 1)) / list.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", list.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + list.size());
    }

    @Async
    public void copyInstallation(){
        String className = "_Installation";
        Parse parse = new Parse(parseApplicationId, parseRESTAPIKey, this.parseMasterKey, className);
        ProcessController.startProcess(className);
        ProcessController.setProcessData(className, "開始從Parse抓資料");
        List<Installation> list = parse.listAllClazz(Installation.class);
        ProcessController.setProcessData(className, "取得資料共" + list.size());
        for (int i = 0; i < list.size(); i++) {
            Installation installation = list.get(i);
            installationRepository.save(installation);
            Double percentage = (Double.valueOf((i + 1)) / list.size()) * 100;
            ProcessController.setProcessData(className, String.format("儲存資料中 totle: %d , process: %d , percentage: %.2f %%", list.size(), i + 1, percentage));
        }
        ProcessController.setProcessData(className, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 已經更新" + list.size());
    }




    private String getTime(){
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        isoFormat.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
        String dateStr = isoFormat.format(new Date());
        return dateStr;
    }
}
