package DB;

import java.sql.SQLException;
import java.util.List;

import admin_adminmanager.AdminCreateForm;
import admin_adminmanager.AdminUpdateForm;
import DB.DBManager;

public class AdminCreateDAO {
    /**
     * 引数のオブジェクトを元にSELECT処理を行う
     */
	public List<AdminCreate> find(AdminCreateForm adminCreateForm){
		String sql = "select * from admin where loginId = '" + adminCreateForm.getLoginid() + "'";
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, new AdminCreateMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	/**
     * 引数のオブジェクトを元に社員番号の重複を行う
     */
	public List<AdminCreate> findStaff(int staffNo){
		String sql = "select * from admin where staffid = " + staffNo;
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, new AdminCreateMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

    /**
     * 引数のオブジェクトを元にINSERT処理を行う
     */
	public int create(AdminCreateForm adminCreateForm){
    	String sql = "INSERT INTO admin(loginid, staffid, adddate, password)"
        		+ " VALUES('"
    			+ adminCreateForm.getLoginid()
    			+ "','" + adminCreateForm.getStaffNo()
    			+ "',CURRENT_TIMESTAMP"
    			+ ",'" + adminCreateForm.getPassword()
    			+ "')"
    			;
		System.out.println(sql);
		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}
	/**
	 * セッション情報内のloginidをもとにデータベースにアクセス
	 */
	public List<AdminCreate> find(String loginid){
		String sql = "select * from admin where loginId = '" +loginid + "'";
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, new AdminCreateMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}
    /**
     * 引数のオブジェクトを元にUPDATE処理を行う
     */
	public int update(String loginid, AdminUpdateForm adminUpdateForm){
    	String sql = "UPDATE admin "
    			+ "SET loginid = '" + adminUpdateForm.getLoginid() + "',"
    			+ " password = '" + adminUpdateForm.getPassword() + "'"
    			+ " where loginid = '" + loginid + "'"
    			;
		System.out.println(sql);
		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}
	/**
	 * loginidをもとにdelete処理を行う
	 */
	public int delete(String loginid){
    	String sql = "DELETE FROM admin where loginid = '" + loginid + "'"
   			;
		System.out.println(sql);
		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	public List<AdminCreate> findAll() {
		String sql = "select * from admin";

		try {
			return DBManager.simpleFind(sql, new AdminCreateMapping());
		}catch(SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
