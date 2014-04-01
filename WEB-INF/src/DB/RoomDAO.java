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


		//SQL文作成
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

		//photoがnullで登録できるようになっている
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
		//photoがnullなら、nullを登録する
		System.out.println("sql発行直前getPhoto" + room.getPhoto());
		if (path.equals("")) {
			sql +=  null + ",'"
					+ room.getStation() + "'"
					+ ")" ;
			System.out.println("○"+  room.getPhoto());
		}
		else {
			System.out.println("●"+ room.getPhoto());
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

		//物件コード
		if (search.getCode() != 0) {

			if (str.equals("")) {
				str += "code = "+ search.getCode();
			}
			else {
				str += " and code = "+ search.getCode();
			}
		}

		//物件名
		if (search.getName().equals("")) {

		}else {

			if (str.equals("")) {
				str += " name like '%"+ search.getName()+"%'";
			}
			else {
				str += " and  name like '%"+ search.getName()+"%'";
			}

		}

		//物件説明
		if (search.getText().equals("")) {


		}else {
			if (str.equals("")) {
				str += "text like '%"+ search.getText()+"%'";
			}
			else {
				str += " and text like '%"+ search.getText()+"%'";
			}
		}

		//入居可能人数
		if (search.getPeople() == 0 ) {


		}else {
			if (str.equals("")) {
				str += "people >= "+ search.getPeople();
			}
			else {
				str += " and people >= "+ search.getPeople();
			}
		}

		//家賃下限
		if (search.getPricemin() == 0) {

		}else {
			if (str.equals("")) {
				str += "price >= "+ search.getPricemin();
			}
			else {
				str += " and price >= "+ search.getPricemin();
			}
		}

		//家賃上限
		//上限を空欄にすると0入力になるので変更
		if (search.getPricemax() <= + search.getPricemin()) {


		}else {
			if (str.equals("")) {
				str += "price <= "+ search.getPricemax();
			}
			else {
				str += " and price <= "+ search.getPricemax();
			}
		}

		//ペット
		if (str.equals("")) {
			str += "pet = "+ search.isPet();
		}
		else {
			str += " and pet = "+ search.isPet();
		}

		//住所
		if (search.getAddress().equals("")) {

		}else {
			if (str.equals("")) {
				str += "address like '%"+ search.getAddress()+"%'";
			}
			else {
				str += " and address like '%"+ search.getAddress()+"%'";
			}
		}

		//最寄駅
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

	//削除確認処理
	public List<Room> DeleteCheck(int code) {

		//引数の主キーのデータを検索するSQL文の生成
		String sql = "select * from room where code = " + code;

		try{
			return DBManager.simpleFind(sql, new RoomMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	//削除処理
	public int Delete(int code) {

		//引数の主キーのデータを削除するSQL文の生成
		String sql = "delete from room where code = " + code;

		System.out.println(sql);

		try{
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	//Update後の検索処理
	public List<Room> UpdateCheck(int code) {

		//hiddenで渡した主キーのデータを検索するSQL文の生成
		String sql = "select * from room where code = " + code;

		try{
			return DBManager.simpleFind(sql, new RoomMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	//Update処理
	//引数は(hiddenで受けた主キー,更新内容)
	public int Update(int code, UpdateForm updateForm) {

		//主キーのデータを更新するSQL文の生成
		String sql = "update room set";
		String str = "";


		//物件名
		if (updateForm.getName().equals("")) {

		}else {

			if (str.equals("")) {
				str += " name = '"+ updateForm.getName()+"'";
			}
			else {
				str += " ,  name = '"+ updateForm.getName()+"'";
			}

		}

		//物件説明
		if (updateForm.getText().equals("")) {

		}else {
			if (str.equals("")) {
				str += " text = '"+ updateForm.getText()+"'";
			}
			else {
				str += " , text = '"+ updateForm.getText()+"'";
			}
		}

		//入居可能人数
		if (updateForm.getPeople() == 0 ) {

		}else {
			if (str.equals("")) {
				str += " people = "+ updateForm.getPeople();
			}
			else {
				str += " , people = "+ updateForm.getPeople();
			}
		}



		//家賃
		if (updateForm.getPrice() == 0) {

		}else {
			if (str.equals("")) {
				str += " price = "+ updateForm.getPrice();
			}
			else {
				str += " , price = "+ updateForm.getPrice();
			}
		}



		//ペット
		if (str.equals("")) {
			str += " pet = "+ updateForm.isPet();
		}
		else {
			str += " , pet = "+ updateForm.isPet();
		}


		//住所
		if (updateForm.getAddress().equals("")) {

		}else {
			if (str.equals("")) {
				str += " address = '"+ updateForm.getAddress()+"'";
			}
			else {
				str += " , address = '"+ updateForm.getAddress()+"'";
			}
		}

		//写真
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

		//最寄駅
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
