package pdm.ipbeja.pt.work.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pdm.ipbeja.pt.work.data.entity.HistoricLog;

@Dao
public interface HistoricLogDao {

    @Insert
    long insert(HistoricLog historicLog);

    @Query("select * from historicLog")
    List<HistoricLog>getAllHistoricLogs(); ///procura todos os registos da db

    @Query("select * from historicLog where dayLog = :dayLog")
    HistoricLog getDailyLog(long dayLog);

    @Query("UPDATE historicLog SET status = :status WHERE idLog = :id AND idMeds = :idMeds")
    void updateStatus(long id, String status, long idMeds);

}
