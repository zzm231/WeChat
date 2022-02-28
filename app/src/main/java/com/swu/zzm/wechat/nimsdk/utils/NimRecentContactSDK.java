package com.swu.zzm.wechat.nimsdk.utils;

import com.netease.nimlib.sdk.InvocationFuture;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.RequestCallbackWrapper;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.MsgServiceObserve;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.RecentContact;

import java.util.List;

public class NimRecentContactSDK {

    /**
     * 获取最近会话列表
     *
     * @param callback 回调监听（回调中的参数即为最近联系人列表）
     */
    public static void queryRecentContacts(RequestCallbackWrapper<List<RecentContact>> callback) {
        NIMClient.getService(MsgService.class).queryRecentContacts()
                .setCallback(callback);
    }

    /**
     * 注册/注销观察者
     *
     * @param messageObserver 观察者对象
     * @param register        注册/注销
     */
    public static void observeRecentContact(Observer<List<RecentContact>> messageObserver, boolean register) {
        //  注册/注销观察者
        NIMClient.getService(MsgServiceObserve.class)
                .observeRecentContact(messageObserver, register);
    }

    /**
     * 获取会话未读数总数
     *
     * @return
     */
    public static int getTotalUnreadCount() {
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        return unreadNum;
    }

    /**
     * 将指定最近联系人的未读数清零(标记已读)。<br>
     * 调用该接口后，会触发{@link MsgServiceObserve#observeRecentContact(Observer, boolean)} 通知
     *
     * @param account     聊天对象帐号
     * @param sessionType 会话类型
     */
    public static void clearUnreadCount(String account, SessionTypeEnum sessionType) {
        NIMClient.getService(MsgService.class).clearUnreadCount(account, sessionType);
    }

    /**
     * 设置当前会话
     * <p>
     * 如果用户在开始聊天时，开发者调用了 setChattingAccount 接口，SDK会自动管理消息的未读数。当收到新消息时，自动将未读数清零
     *
     * @param sessionId
     * @param sessionType
     */
    public static void setChattingAccount(String sessionId, SessionTypeEnum sessionType) {
        NIMClient.getService(MsgService.class).setChattingAccount(sessionId, sessionType);
    }

    /**
     * 移除最近会话列表中的项
     *
     * @param recent
     */
    public static void deleteRecentContact(RecentContact recent) {
        NIMClient.getService(MsgService.class).deleteRecentContact(recent);
    }

    /**
     * 移除最近会话列表中的项，并会触发 MsgServiceObserve#observeRecentContactDeleted 通知
     *
     * @param account
     * @param sessionType
     */
    public static void deleteRecentContactAndNotify(String account, SessionTypeEnum sessionType) {
        NIMClient.getService(MsgService.class).deleteRecentContact2(account, sessionType);
    }

    /**
     * 删除指定最近联系人的漫游消息。
     * 不删除本地消息，但如果在其他端登录，当前时间点该会话已经产生的消息不漫游。
     *
     * @param contactId       最近联系人的ID（好友帐号，群ID等）
     * @param sessionTypeEnum 会话类型
     * @return InvocationFuture 可设置回调函数，监听删除结果。
     */
    public static InvocationFuture<Void> deleteRoamingRecentContact(String contactId, SessionTypeEnum sessionTypeEnum, RequestCallback<Void> callback) {
        InvocationFuture<Void> voidInvocationFuture = NIMClient.getService(MsgService.class)
                .deleteRoamingRecentContact(contactId, sessionTypeEnum);
        voidInvocationFuture.setCallback(callback);
        return voidInvocationFuture;
    }
}
