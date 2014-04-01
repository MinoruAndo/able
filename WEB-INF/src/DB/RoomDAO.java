package DB;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import admin_search.RoomCreateForm;
import admin_search.UserDelForm;
import admin_search.SearchForm;
import admin_search.UpdateForm;
import DB.*;

public class RoomDAO {
	public int create(RoomCreateForm room, String path){


		//SQL���쐬
//		String sql = "insert into room(code,name,text,people,price,pet,address,photo,station)"
//				+ "values("
//				+ room.getCode()+ ",'"
//				+ room.getName() + "','"
//				+ room.getText() + "',"
//				+ room.getPeople() + ","
//				+ room.getPrice() + ","
//				+ room.isPet() + ",'"
//				+ room.getAddress() + "','"
//				+ room.getPhoto() + "','"
//				+ room.getStation() + "'"
//				+ ")" ;

		//photo��null�œo�^�ł���悤�ɂȂ��Ă���
		String sql = "insert into room(code,name,text,people,price,pet,address,photo,station)"
				+ "values("
				+ room.getCode()+ ",'"
				+ room.getName() + "','"
				+ room.getText() + "',"
				+ room.getPeople() + ","
				+ room.getPrice() + ","
				+ room.isPet() + ",'"
				+ room.getAddress() + "',"
				;
		//photo��null�Ȃ�Anull��o�^����
		System.out.println("sql���s���OgetPhoto" + room.getPhoto());
		if (path.equals("")) {
			sql +=  null + ",'"
					+ room.getStation() + "'"
					+ ")" ;
			System.out.println("��"+  room.getPhoto());
		}
		else {
			System.out.println("��"+ room.getPhoto());
			sql +=  "'" + path + "','"
					+ room.getStation() + "'"
					+ ")" ;
		}

		System.out.println(sql);
		try{

			return DBManager.simpleUpdate(sql);
//			return DBManager.simpleFind(sql, new RoomMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}


	public List<Room> findAll(SearchForm search) throws Exception {


//		String sql = "select * from room where code = "+ search.getCode()+
//										" and name = '"+ search.getName()+"'"
//									    + " and text = '"+ search.getText()+"'"
//									    +" and people ="+ search.getPeople()+
//									    " and price between "+ search.getPricemin()+
//									    " and "+ search.getPricemax()+
//									    " and pet = "+ search.isPet()+
//									    " and address = '"+ search.getAddress()+"'"
//									   +" and photo = '"+ search.getPhoto()+"'"
//									   +" and station = '"+ search.getStation() + "'";

		String sql = "select * from room where ";
		String str = "";

		//�����R�[�h
		if (search.getCode() != 0) {

			if (str.equals("")) {
				str += "code = "+ search.getCode();
			}
			else {
				str += " and code = "+ search.getCode();
			}
		}

		//������
		if (search.getName().equals("")) {

		}else {

			if (str.equals("")) {
				str += " name like '%"+ search.getName()+"%'";
			}
			else {
				str += " and  name like '%"+ search.getName()+"%'";
			}

		}

		//��������
		if (search.getText().equals("")) {


		}else {
			if (str.equals("")) {
				str += "text like '%"+ search.getText()+"%'";
			}
			else {
				str += " and text like '%"+ search.getText()+"%'";
			}
		}

		//�����\�l��
		if (search.getPeople() == 0 ) {


		}else {
			if (str.equals("")) {
				str += "people >= "+ search.getPeople();
			}
			else {
				str += " and people >= "+ search.getPeople();
			}
		}

		//�ƒ�����
		if (search.getPricemin() == 0) {

		}else {
			if (str.equals("")) {
				str += "price >= "+ search.getPricemin();
			}
			else {
				str += " and price >= "+ search.getPricemin();
			}
		}

		//�ƒ����
		//������󗓂ɂ����0���͂ɂȂ�̂ŕύX
		if (search.getPricemax() <= + search.getPricemin()) {


		}else {
			if (str.equals("")) {
				str += "price <= "+ search.getPricemax();
			}
			else {
				str += " and price <= "+ search.getPricemax();
			}
		}

		//�y�b�g
		if (str.equals("")) {
			str += "pet = "+ search.isPet();
		}
		else {
			str += " and pet = "+ search.isPet();
		}

		//�Z��
		if (search.getAddress().equals("")) {

		}else {
			if (str.equals("")) {
				str += "address like '%"+ search.getAddress()+"%'";
			}
			else {
				str += " and address like '%"+ search.getAddress()+"%'";
			}
		}

		//�Ŋ�w
		if (search.getStation().equals("")) {


		}else {
			if (str.equals("")) {
				str += "station like '%"+ search.getStation()+"%'";
			}
			else {
				str += " and station like '%"+ search.getStation()+"%'";
			}
		}

		sql += str;
		System.out.println(sql);


		try{
			return DBManager.simpleFind(sql, new RoomMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	//�폜�m�F����
	public List<Room> DeleteCheck(int code) {

		//�����̎�L�[�̃f�[�^����������SQL���̐���
		String sql = "select * from room where code = " + code;

		try{
			return DBManager.simpleFind(sql, new RoomMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	//�폜����
	public int Delete(int code) {

		//�����̎�L�[�̃f�[�^���폜����SQL���̐���
		String sql = "delete from room where code = " + code;

		System.out.println(sql);

		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	//Update��̌�������
	public List<Room> UpdateCheck(int code) {

		//hidden�œn������L�[�̃f�[�^����������SQL���̐���
		String sql = "select * from room where code = " + code;

		try{
			return DBManager.simpleFind(sql, new RoomMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	//Update����
	//������(hidden�Ŏ󂯂���L�[,�X�V���e)
	public int Update(int code, UpdateForm updateForm) {

		//��L�[�̃f�[�^���X�V����SQL���̐���
		String sql = "update room set";
		String str = "";


		//������
		if (updateForm.getName().equals("")) {

		}else {

			if (str.equals("")) {
				str += " name = '"+ updateForm.getName()+"'";
			}
			else {
				str += " ,  name = '"+ updateForm.getName()+"'";
			}

		}

		//��������
		if (updateForm.getText().equals("")) {

		}else {
			if (str.equals("")) {
				str += " text = '"+ updateForm.getText()+"'";
			}
			else {
				str += " , text = '"+ updateForm.getText()+"'";
			}
		}

		//�����\�l��
		if (updateForm.getPeople() == 0 ) {

		}else {
			if (str.equals("")) {
				str += " people = "+ updateForm.getPeople();
			}
			else {
				str += " , people = "+ updateForm.getPeople();
			}
		}



		//�ƒ�
		if (updateForm.getPrice() == 0) {

		}else {
			if (str.equals("")) {
				str += " price = "+ updateForm.getPrice();
			}
			else {
				str += " , price = "+ updateForm.getPrice();
			}
		}



		//�y�b�g
		if (str.equals("")) {
			str += " pet = "+ updateForm.isPet();
		}
		else {
			str += " , pet = "+ updateForm.isPet();
		}


		//�Z��
		if (updateForm.getAddress().equals("")) {

		}else {
			if (str.equals("")) {
				str += " address = '"+ updateForm.getAddress()+"'";
			}
			else {
				str += " , address = '"+ updateForm.getAddress()+"'";
			}
		}

		//�ʐ^
		if (updateForm.getPhoto().toString().equals("")) {
			System.out.println("photodesu" + updateForm.getPhoto());
		}else {
			if (str.equals("")) {

				str += " photo = '"+ updateForm.getPhoto()+"'";
			}
			else {
				System.out.println("photodesu" + updateForm.getPhoto());
				str += " , photo = '"+ updateForm.getPhoto()+"'";
			}
		}

		//�Ŋ�w
		if (updateForm.getStation().equals("")) {

		}else {
			if (str.equals("")) {
				str += "station = '"+ updateForm.getStation()+"'";
			}
			else {
				str += " , station = '"+ updateForm.getStation()+"'";
			}
		}

		sql += str + " where code = " + code;
		System.out.println("update" + sql);

		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

}
