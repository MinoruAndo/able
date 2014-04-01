package DB;

import java.sql.SQLException;
import java.util.List;

import user.UserInfoForm;
import DB.DBManager;

public class UserInfoDAO {
    /**
     * 引数のオブジェクトを元にSELECT処理を行う
     */
	public List<UserInfo> find(UserInfoForm userInfoForm){
		String sql = "select * from userinfo where loginId = '" + userInfoForm.getLoginid() + "' and password = '" + userInfoForm.getPassword() + "'";
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, new UserInfoMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}
    /**
     * 引数のオブジェクトを元にINSERT処理を行う
     */
	public int create(UserInfoForm userInfoForm){
    	String sql = "INSERT INTO userinfo(loginid, mail, adddate, password)"
        		+ " VALUES('"
    			+ userInfoForm.getLoginid()
    			+ "','" + userInfoForm.getMail()
    			+ "',CURRENT_TIMESTAMP"
    			+ ",'" + userInfoForm.getPassword()
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
	public List<UserInfo> find(String loginid){
		String sql = "select * from userinfo where loginId = '" +loginid + "'";
		System.out.println(sql);
		try{
			return DBManager.simpleFind(sql, new UserInfoMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}
    /**
     * 引数のオブジェクトを元にUPDATE処理を行う
     */
	public int update(String loginid, UserInfoForm userInfoForm){
    	String sql = "UPDATE userinfo "
    			+ "SET loginid = '" + userInfoForm.getLoginid() + "',"
    			+ " mail = '" + userInfoForm.getMail() + "',"
    			+ " password = '" + userInfoForm.getPassword() + "'"
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
	 * 引数オブジェクトをもとにdelete処理を行う
	 */
	public int delete(String loginid){
    	String sql = "DELETE FROM userinfo where loginid = '" + loginid + "'"
   			;
		System.out.println(sql);
		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

}
