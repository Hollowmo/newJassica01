package com.jassica.jassica.utils;


import com.jassica.jassica.Database.DaoMaster;
import com.jassica.jassica.Database.DaoSession;
import com.jassica.jassica.Database.DbBean;
import com.jassica.jassica.Database.DbBeanDao;
import com.jassica.jassica.Database.MyApp;

import java.util.List;

public class DbUtils {
    private static DbUtils mDbUtils;
    private final DbBeanDao mDbBeanDao;

    public DbUtils(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "info.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mDbBeanDao = daoSession.getDbBeanDao();
    }

    public static DbUtils getmDbUtils() {
        if(mDbUtils==null){
            synchronized (DbUtils.class){
                if(mDbUtils==null){
                    mDbUtils = new DbUtils();
                }
            }
        }
        return mDbUtils;
    }
    public List<DbBean> query(){
        return mDbBeanDao.queryBuilder().list();
    }
    public void delete(DbBean dbBean){
        if(has(dbBean)){
            mDbBeanDao.delete(dbBean);
        }
    }
    public void insert(List<DbBean> dbBean){
        List<DbBean> list = mDbBeanDao.queryBuilder().list();
        if(list.size()==0){
            mDbBeanDao.insertInTx(dbBean);
        }
    }
    public boolean has(DbBean dbBean){
        List<DbBean> list = mDbBeanDao.queryBuilder().where(DbBeanDao.Properties.Author.eq(dbBean.getAuthor())).list();
        if(list!=null&&list.size()>0){
            return true;
        }else{
            return false;
        }
    }
}
