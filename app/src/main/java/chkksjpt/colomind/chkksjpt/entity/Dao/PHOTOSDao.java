package chkksjpt.colomind.chkksjpt.entity.Dao;

import android.content.Context;


import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chkksjpt.colomind.chkksjpt.dbutil.DatabaseHelper;
import chkksjpt.colomind.chkksjpt.entity.PHOTOSEntity;

/**
 * Created by bj on 2015/7/28.
 */
public class PHOTOSDao {
    private Dao<PHOTOSEntity, Integer> PHOTOSEntityDaoOpe=null;
    private DatabaseHelper databaseHelper=null;
    private Context context;

    public PHOTOSDao(Context context){
        try{
            this.context=context;
            databaseHelper = this.getHelper();
            PHOTOSEntityDaoOpe = databaseHelper.getDao(PHOTOSEntity.class);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = DatabaseHelper.getHelper(context);
        }
        return databaseHelper;
    }

    public void close(){
        if(PHOTOSEntityDaoOpe!=null){
            PHOTOSEntityDaoOpe=null;
        }
        if (databaseHelper != null) {
            databaseHelper.close();
            databaseHelper = null;
        }
    }

    public void add(PHOTOSEntity photosEntity){
        try{
            PHOTOSEntityDaoOpe.create(photosEntity);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public PHOTOSEntity getPHOTOSEntity(int id){
        PHOTOSEntity photosEntity = null;
        try{
            photosEntity = PHOTOSEntityDaoOpe.queryForId(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return photosEntity;
    }


    public boolean deletePHOTOS(int id)
    {
        try {
            PHOTOSEntityDaoOpe.deleteById(id);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if (queryListById(id)!=null) {
            return true;
        }
        return false;
    }

    public List<PHOTOSEntity> queryListById(int Id){
        try{
            return PHOTOSEntityDaoOpe.queryBuilder().where().eq("idd", Id).query();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询当前操作时所有的ID
     * @return
     */
    public  List<Integer> QueryIds()
    {
        List<Integer> listIds=new ArrayList<Integer>();
        List<PHOTOSEntity> photosEntities=queryAll();
        if (photosEntities!=null) {
            for (PHOTOSEntity photosEntity : photosEntities) {
                Integer id = photosEntity.getIdd();
                try
                {
                    listIds.add(id);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return  listIds;
    }

    public List<PHOTOSEntity> queryAll(){
        try{
            return PHOTOSEntityDaoOpe.queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
