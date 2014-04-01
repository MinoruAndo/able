package DB;


import java.sql.SQLException;
import java.util.List;

import user.KuchikomiForm;

public class KuchikomiDAO {
    /**
     * �����̃I�u�W�F�N�g������SELECT�������s��
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
     * �����̃I�u�W�F�N�g������SELECT�������s��
     * �����F���O�C��ID
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
     * �����̃I�u�W�F�N�g������SELECT�������s��
     * �����F�Ŋ�w
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
     * �����̃I�u�W�F�N�g������INSERT�������s��
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
	 * �����I�u�W�F�N�g�����Ƃ�delete�������s��
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
     * �����̃I�u�W�F�N�g������SELECT�������s��(�Ǘ��ґ�)
     * �����F���O�C��ID
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
