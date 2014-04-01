package DB;


import java.sql.SQLException;
import java.util.List;

import user.KuchikomiForm;

public class KuchikomiDAO {
    /**
     * 引数のオブジェクトを元にSELECT処理を行う
     */
	public List<Kuchikomi> findAll(){
		String sql = "select * from kuchikomi";
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, (ResultSetBeanMapping<Kuchikomi>) new KuchikomiMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

    /**
     * 引数のオブジェクトを元にSELECT処理を行う
     * 条件：ログインID
     */
	public List<Kuchikomi> find(KuchikomiForm kuchikomiform){
		String sql = "select * from kuchikomi where loginid = '" + kuchikomiform.getLoginid() + "'";
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, (ResultSetBeanMapping<Kuchikomi>) new KuchikomiMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	/**
     * 引数のオブジェクトを元にSELECT処理を行う
     * 条件：最寄駅
     */
	public List<Kuchikomi> find_station(String station){
		String sql = "select * from kuchikomi where station = '" + station + "'";
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, (ResultSetBeanMapping<Kuchikomi>) new KuchikomiMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

    /**
     * 引数のオブジェクトを元にINSERT処理を行う
     */
	public int create(KuchikomiForm kuchikomiform){
//    	String sql = "INSERT INTO kuchikomi(station, kuchikomi, loginid, addNo)"
   	    	String sql = "INSERT INTO kuchikomi(station, kuchikomi, loginid)"
        		+ " VALUES('"
    			+ kuchikomiform.getStation()
    			+ "','" + kuchikomiform.getKuchikomi()
    			+ "','" + kuchikomiform.getLoginid() + "'"
//    			+ "," + kuchikomiform.getAddNo()
    			+ ")"
    			;
		System.out.println(sql);
		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 引数オブジェクトをもとにdelete処理を行う
	 */
	public int delete(int addno){
    	String sql = "DELETE FROM kuchikomi where addno = " + addno
   			;
		System.out.println(sql);
		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	 /**
     * 引数のオブジェクトを元にSELECT処理を行う(管理者側)
     * 条件：ログインID
     */
	public List<Kuchikomi> find(admin_kuchikomi.KuchikomiForm kuchikomiform){

		String sql = "select * from kuchikomi where loginid = '" + kuchikomiform.getLoginid() + "'";
		try{
			return DBManager.simpleFind(sql, (ResultSetBeanMapping<Kuchikomi>) new KuchikomiMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

}
