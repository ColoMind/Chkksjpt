package chkksjpt.colomind.chkksjpt.entity.Dao;

import chkksjpt.colomind.chkksjpt.dbutil.DatabaseHelper;
import chkksjpt.colomind.chkksjpt.entity.JCYD.JCYDEntity;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bj on 2015/11/19.
 */
public class JCYDDao {
    private Dao<JCYDEntity, Integer> JCYDEntityDaoOpe = null;
    private DatabaseHelper databaseHelper = null;
    private Context context;

    public JCYDDao(Context context) {
        try {
            this.context = context;
            databaseHelper = this.getHelper();
            JCYDEntityDaoOpe = databaseHelper.getDao(JCYDEntity.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = DatabaseHelper.getHelper(context);
        }
        return databaseHelper;
    }

    public void close() {
        if (JCYDEntityDaoOpe != null) {
            JCYDEntityDaoOpe = null;
        }
        if (databaseHelper != null) {
            databaseHelper.close();
            databaseHelper = null;
        }
    }

    public void add(JCYDEntity jcydEntity) {
        try {
            JCYDEntityDaoOpe.create(jcydEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JCYDEntity getJCYDEntity(int id) {
        JCYDEntity jcydEntity = null;
        try {
            jcydEntity = JCYDEntityDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jcydEntity;
    }


    public boolean deleteJCYDEntity(int id) {
        try {
            JCYDEntityDaoOpe.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (queryListById(id) != null) {
            return true;
        }
        return false;
    }

    public List<JCYDEntity> queryListById(int Id) {
        try {
            return JCYDEntityDaoOpe.queryBuilder().where().eq("ID", Id).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询当前操作时所有的ID
     *
     * @return
     */
    public List<Integer> QueryIds() {
        List<Integer> listIds = new ArrayList<Integer>();
        List<JCYDEntity> jcydEntities = queryAll();
        if (jcydEntities != null) {
            for (JCYDEntity jcydEntity : jcydEntities) {
                Integer id = jcydEntity.getId();
                try {
                    listIds.add(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return listIds;
    }

    public List<JCYDEntity> queryAll() {
        try {
            return JCYDEntityDaoOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
