package com.network;

/**
 * Created by wb-qjl256634 on 2017/2/3.
 */

public interface Type {
    public static enum WxOrderStatus {
        illegal(0),
        enabled(1),
        paid(2),
        shipped(3),
        success(4),
        closed(5);

        private final int state;

        private WxOrderStatus(int state) {
            this.state = state;
        }

        public static Type.WxOrderStatus valueOf(int state) {
            switch(state) {
                case 1:
                    return enabled;
                case 2:
                    return paid;
                case 3:
                    return shipped;
                case 4:
                    return success;
                case 5:
                    return closed;
                default:
                    return illegal;
            }
        }

        public int getValue() {
            return this.state;
        }
    }

    public static enum MsgCollectionType {
        Biz_WW_P2P(1),
        Biz_WX_P2P(3),
        Biz_PAMSG_P2P(4),
        Biz_WX_OTHER(0);

        private final int type;

        private MsgCollectionType(int type) {
            this.type = type;
        }

        public static Type.MsgCollectionType valueOf(int type) {
            switch(type) {
                case 1:
                    return Biz_WW_P2P;
                case 2:
                default:
                    return Biz_WX_OTHER;
                case 3:
                    return Biz_WX_P2P;
                case 4:
                    return Biz_PAMSG_P2P;
            }
        }

        public int getValue() {
            return this.type;
        }
    }

    public static enum WXEnvType {
        daily(1),
        online(0),
        pre(2),
        test(3),
        onlineReallot(4),
        dailyReallot(5),
        sandbox(6);

        private final int type;

        private WXEnvType(int type) {
            this.type = type;
        }

        public static Type.WXEnvType valueOf(int type) {
            switch(type) {
                case 0:
                    return online;
                case 1:
                    return daily;
                case 2:
                    return pre;
                case 3:
                    return test;
                case 4:
                    return onlineReallot;
                case 5:
                    return dailyReallot;
                case 6:
                    return sandbox;
                default:
                    throw new RuntimeException("bad WXEnvType type:" + type);
            }
        }

        public int getValue() {
            return this.type;
        }
    }

    public static enum WXPluginMsgType {
        plugin_msg(0),
        operation_off_msg(8),
        operation_msg(1),
        operation_special_msg(6),
        system_msg(2),
        template_msg(3);

        private final int type;

        private WXPluginMsgType(int type) {
            this.type = type;
        }

        public static Type.WXPluginMsgType valueOf(int type) {
            switch(type) {
                case 0:
                    return plugin_msg;
                case 1:
                    return operation_msg;
                case 2:
                    return system_msg;
                case 3:
                    return template_msg;
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    throw new RuntimeException("bad WXSysEventType type:" + type);
                case 8:
                    return operation_off_msg;
            }
        }

        public int getValue() {
            return this.type;
        }
    }

    public static enum WxContactOperate {
        chgnick_name(1),
        move_contact(2),
        chg_importance(4);

        private final int type;

        private WxContactOperate(int type) {
            this.type = type;
        }

        public static Type.WxContactOperate valueOf(int type) {
            switch(type) {
                case 1:
                    return chgnick_name;
                case 2:
                    return move_contact;
                case 3:
                default:
                    throw new RuntimeException("bad WXSysEventType type:" + type);
                case 4:
                    return chg_importance;
            }
        }

        public int getValue() {
            return this.type;
        }
    }

    public static enum WXSysEventType {
        service_conn(0),
        net_state(1),
        net_strength(2),
        account_login(3),
        account_logout(4),
        service_state(5);

        private final int type;

        private WXSysEventType(int type) {
            this.type = type;
        }

        public static Type.WXSysEventType valueOf(int type) {
            switch(type) {
                case 0:
                    return service_conn;
                case 1:
                    return net_state;
                case 2:
                    return net_strength;
                case 3:
                    return account_login;
                case 4:
                    return account_logout;
                case 5:
                    return service_state;
                default:
                    throw new RuntimeException("bad WXSysEventType type:" + type);
            }
        }

        public int getValue() {
            return this.type;
        }
    }

    public static enum WXCommuType {
        commu_null(0),
        commu_wifi(1),
        commu_net(2),
        commu_wap(3),
        commu_unknown(4);

        private final int type;

        private WXCommuType(int type) {
            this.type = type;
        }

        public static Type.WXCommuType valueOf(int type) {
            switch(type) {
                case 0:
                    return commu_null;
                case 1:
                    return commu_wifi;
                case 2:
                    return commu_net;
                case 3:
                    return commu_wap;
                case 4:
                    return commu_unknown;
                default:
                    throw new RuntimeException("bad WXCommuType type:" + type);
            }
        }

        public int getValue() {
            return this.type;
        }
    }

    public static enum WXInitState {
        idle(0),
        success(1);

        private final int state;

        private WXInitState(int state) {
            this.state = state;
        }

        public static Type.WXInitState valueOf(int state) {
            switch(state) {
                case 0:
                    return idle;
                case 1:
                    return success;
                default:
                    throw new RuntimeException("bad WxInitState state:" + state);
            }
        }

        public int getValue() {
            return this.state;
        }
    }

    public static enum WXLoginState {
        idle(0),
        logining(2),
        success(3),
        fail(4),
        disconnect_user(5),
        disconnect_sys(6),
        fail_old_version(7),
        logout(8);

        private final int state;

        private WXLoginState(int state) {
            this.state = state;
        }

        public static Type.WXLoginState valueOf(int state) {
            switch(state) {
                case 0:
                    return idle;
                case 1:
                    return success;
                case 2:
                    return logining;
                case 3:
                    return fail;
                case 4:
                    return fail;
                case 5:
                    return disconnect_user;
                case 6:
                    return disconnect_sys;
                case 7:
                    return fail_old_version;
                case 8:
                    return idle;
                default:
                    throw new RuntimeException("bad WxLoginState state:" + state);
            }
        }

        public int getValue() {
            return this.state;
        }
    }

    public static enum WXDevType {
        iphone((byte)80),
        ipad((byte)81),
        androidphone((byte)82),
        androidpad((byte)83),
        winphone((byte)84),
        winpad((byte)85);

        private final byte value;

        private WXDevType(byte type) {
            this.value = type;
        }

        public static Type.WXDevType valueOf(int state) {
            switch(state) {
                case 80:
                    return iphone;
                case 81:
                    return ipad;
                case 82:
                    return androidphone;
                case 83:
                    return androidpad;
                case 84:
                    return winphone;
                case 85:
                    return winpad;
                default:
                    throw new RuntimeException("bad WXDevType value:" + state);
            }
        }

        public byte getValue() {
            return this.value;
        }
    }

    public static enum WXTribeMsgType {
        normal(1),
        audio(2),
        geo(8),
        image(16),
        custom(17),
        sysAdd2Tribe(3),
        sysQuitTribe(5),
        sysManagerChanged(7),
        sysDelManager(8),
        sysDelMember(9),
        sysCloseTribe(12),
        sysTribeInfoChanged(14),
        shareTransparent(203),
        atMsgAck(208),
        sysAskJoinTribe(212),
        sysRefuseJoin(35),
        sysRefuseJoinSpam(101),
        sysRefuseAsk(98),
        updateMemberNick(15),
        syncAtMsgReadAck(213),
        tribeTemplateMsg(211);

        private final int value;

        private WXTribeMsgType(int state) {
            this.value = state;
        }

        public static Type.WXTribeMsgType valueOf(int state) {
            switch(state) {
                case 1:
                    return normal;
                case 2:
                    return audio;
                case 3:
                    return sysAdd2Tribe;
                case 5:
                    return sysQuitTribe;
                case 7:
                    return sysManagerChanged;
                case 8:
                    return geo;
                case 9:
                    return sysDelMember;
                case 12:
                    return sysCloseTribe;
                case 14:
                    return sysTribeInfoChanged;
                case 15:
                    return updateMemberNick;
                case 16:
                    return image;
                case 17:
                    return custom;
                case 35:
                    return sysRefuseJoin;
                case 98:
                    return sysRefuseAsk;
                case 101:
                    return sysRefuseJoinSpam;
                case 203:
                    return shareTransparent;
                case 208:
                    return atMsgAck;
                case 211:
                    return tribeTemplateMsg;
                case 212:
                    return sysAskJoinTribe;
                case 213:
                    return syncAtMsgReadAck;
                default:
                    throw new RuntimeException("bad WXTribeMsgType value:" + state);
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static enum WXTribeOperation {
        getTribeList,
        getTribeInfo,
        getTribeBulletin,
        getMembers,
        sendTribeMsg,
        onInviteTribe,
        inviteTribe,
        sysMsg,
        tribeMsg,
        tribeKill,
        tribeAck,
        PCOnlineStatusNotify,
        quitTribe,
        atReadAck,
        updateMemberNick,
        updateInfo,
        examAskJoinTribe,
        getMySelfInfoInTribe,
        create,
        expel,
        closeTribe,
        setMemberLevel,
        getMemberNick,
        join,
        invite;

        private WXTribeOperation() {
        }
    }

    public static class TribeType {
        public static final int Normal_Tribe = 0;
        public static final int Chatting_Group = 1;
        public static final int Enterprise_Tribe = 2;
        public static final int Project_Tribe = 3;

        public TribeType() {
        }
    }

    public static enum WXLatentContactType {
        clearGPSData(3),
        sns(8),
        lbsNeighbour(9),
        lbsOneKey(10);

        private final int value;

        private WXLatentContactType(int state) {
            this.value = state;
        }

        static Type.WXLatentContactType valueOf(int state) {
            switch(state) {
                case 3:
                    return clearGPSData;
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    throw new RuntimeException("bad WXLatentContactType value:" + state);
                case 8:
                    return sns;
                case 9:
                    return lbsNeighbour;
                case 10:
                    return lbsOneKey;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static enum WXInpuState {
        inputStop(0),
        inputText(1),
        inputAudio(2),
        inputPicture(4),
        inputVideo(3);

        private final int value;

        private WXInpuState(int state) {
            this.value = state;
        }

        public static Type.WXInpuState valueOf(int state) {
            switch(state) {
                case 0:
                    return inputStop;
                case 1:
                    return inputText;
                case 2:
                    return inputAudio;
                case 3:
                    return inputVideo;
                case 4:
                    return inputPicture;
                default:
                    throw new RuntimeException("bad input state:" + state);
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static enum WXMsgState {
        sent(1),
        received(2),
        read(4);

        private final int value;

        private WXMsgState(int state) {
            this.value = state;
        }

        public static Type.WXMsgState valueOf(int state) {
            switch(state) {
                case 1:
                    return sent;
                case 2:
                    return received;
                case 3:
                default:
                    throw new RuntimeException("bad msg state:" + state);
                case 4:
                    return read;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static enum WXAppTokenType {
        cloudSync((byte)20),
        onceToken((byte)1),
        webToken((byte)2),
        qnToken((byte)22),
        signToken((byte)10),
        mtopSid((byte)31),
        h5AutoSid((byte)23),
        ssoToken((byte)32),
        wantuToken((byte)35),
        wantuTranscodeToken((byte)36),
        videoChatToken((byte)37);

        private byte value;

        private WXAppTokenType(byte type) {
            this.value = type;
        }

        static Type.WXAppTokenType valueOf(byte type) {
            switch(type) {
                case 1:
                    return onceToken;
                case 2:
                    return webToken;
                case 10:
                    return signToken;
                case 20:
                    return cloudSync;
                case 22:
                    return qnToken;
                case 31:
                    return mtopSid;
                case 32:
                    return ssoToken;
                case 35:
                    return wantuToken;
                case 36:
                    return wantuTranscodeToken;
                case 55:
                    return videoChatToken;
                default:
                    throw new RuntimeException("bad app token type:" + type);
            }
        }

        public byte getValue() {
            return this.value;
        }
    }

    public static enum WXOnlineState {
        offline((byte)0),
        online((byte)1),
        stealth((byte)2);

        private final byte state;

        private WXOnlineState(byte state) {
            this.state = state;
        }

        public static Type.WXOnlineState valueOf(byte value) {
            return value == 2?stealth:(value == 1?online:(value == 0?offline:online));
        }

        public byte getValue() {
            return this.state;
        }
    }

    public static enum WXAddContactType {
        normal((byte)0),
        needVerify((byte)1),
        doubleWayNeedVerify((byte)17),
        /** @deprecated */
        chated((byte)2),
        answerQuestion((byte)16);

        private final byte value;

        private WXAddContactType(byte value) {
            this.value = value;
        }

        static Type.WXAddContactType valueOf(int value) {
            switch(value) {
                case 0:
                    return normal;
                case 1:
                    return needVerify;
                case 2:
                    return chated;
                case 16:
                    return answerQuestion;
                case 17:
                    return doubleWayNeedVerify;
                default:
                    throw new RuntimeException("bad add contact type:" + value);
            }
        }

        public byte getValue() {
            return this.value;
        }
    }

    public static enum WXPwdType {
        password(0),
        token(1),
        trust_token(2),
        havana_token(3),
        freeopenim(64),
        openid(66),
        freeopenimtoken(64),
        annoy(67),
        auth(128),
        ssoToken(129),
        openimid(130),
        openimToken(131);

        private final int value;

        private WXPwdType(int state) {
            this.value = state;
        }

        public static Type.WXPwdType valueOf(int state) {
            switch(state) {
                case 0:
                    return password;
                case 1:
                    return token;
                case 2:
                    return trust_token;
                case 3:
                    return havana_token;
                case 64:
                    return freeopenim;
                case 65:
                    return freeopenimtoken;
                case 66:
                    return openid;
                case 67:
                    return annoy;
                case 128:
                    return auth;
                case 129:
                    return ssoToken;
                case 130:
                    return openimid;
                case 131:
                    return openimToken;
                default:
                    throw new RuntimeException("bad WXPwdType value:" + state);
            }
        }

        public int getValue() {
            return this.value;
        }
    }
}
