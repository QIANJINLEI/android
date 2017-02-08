package com.network;

import java.util.Iterator;

/**
 * Created by wb-qjl256634 on 2017/2/3.
 */

public class NetStart {
    private Type.WXCommuType commuType;
    private int commuStrength;
    private WeekHashSet listeners;
    private final Object Lock;

    public NetStart() {
        this.commuType = Type.WXCommuType.commu_null;
        this.listeners = new WeekHashSet();
        this.Lock = new Object();
    }

    public void setCommuType(Type.WXCommuType commuType) {
        this.commuType = commuType;
        Object var2 = this.Lock;
        synchronized(this.Lock) {
            Iterator it = this.listeners.iterator();

            while(it.hasNext()) {
                NetStart.INetStartChangeListener listener = (NetStart.INetStartChangeListener)it.next();
                if(listener != null) {
                    listener.onNetWorkChange();
                }
            }

        }
    }

    public boolean isSame(Type.WXCommuType commuType) {
        return this.commuType.equals(commuType);
    }

    public boolean isNetWorkNull() {
        return Type.WXCommuType.commu_null.equals(this.commuType);
    }

    public boolean isWifiNetWork() {
        return Type.WXCommuType.commu_wifi.equals(this.commuType);
    }

    public int getCommuStrength() {
        return this.commuStrength;
    }

    public void setCommuStrength(int commuStrength) {
        this.commuStrength = commuStrength;
    }

    public void addNetWorkChangeListener(NetStart.INetStartChangeListener listener) {
        Object var2 = this.Lock;
        synchronized(this.Lock) {
            this.listeners.add(listener);
        }
    }

    public void removeNetWorkChangeListener(NetStart.INetStartChangeListener listener) {
        Object var2 = this.Lock;
        synchronized(this.Lock) {
            this.listeners.remove(listener);
        }
    }

    public interface INetStartChangeListener {
        void onNetWorkChange();
    }
}
