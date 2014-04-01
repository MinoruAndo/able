package DB;

import java.sql.SQLException;
import java.util.List;

import admin_adminmanager.AdminCreateForm;
import admin_adminmanager.AdminUpdateForm;
import DB.DBManager;

public class AdminCreateDAO {
    /**
     * �����̃I�u�W�F�N�g������SELECT�������s��
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
     * �����̃I�u�W�F�N�g�����ɎЈ��ԍ��̏d�����s��
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
     * �����̃I�u�W�F�N�g������INSERT�������s��
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
	 * �Z�b�V����������loginid�����ƂɃf�[�^�x�[�X�ɃA�N�Z�X
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
     * �����̃I�u�W�F�N�g������UPDATE�������s��
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
	 * loginid�����Ƃ�delete�������s��
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
