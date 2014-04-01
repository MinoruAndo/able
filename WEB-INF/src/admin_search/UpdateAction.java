package admin_search;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import DB.Room;
import DB.RoomDAO;

public class UpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

System.out.println("UpdateAction");
		RoomDAO dao = new RoomDAO();


		//jspからsubmitされたnameを取得する
		String update = null;
		String check = null;
		String confirm = null;
		String back = null;

		update = request.getParameter("update");
		check = request.getParameter("check");
		confirm = request.getParameter("confirm");
		back = request.getParameter("back");


		//取得したnameを条件分岐して処理を選択

		//confirmがnullじゃなければ
		if(confirm != null) {


			SearchForm searchForm =(SearchForm)form;
			//物件詳細表示
			List<Room> list = dao.UpdateCheck(searchForm.getCode());

			request.setAttribute("list", list);
			return mapping.findForward("confirm");
		}
		//checkがnullじゃなければ
		else if(check != null) {
			//更新内容を取得
			UpdateForm updateForm = (UpdateForm)form;

			// フォームで指定されたファイルを取得
			FormFile formFile = updateForm.getPhoto();

			// ファイルが存在していればレスポンスに出力する
			if(formFile != null && formFile.getFileSize() != 0) {
				// ファイル名を取得する
				String fileName = formFile.getFileName();
				System.out.println("fileName■" + fileName);

				// JSPでファイルを参照する時のパスをスコープに登録する
				request.setAttribute("filePath", "/" + fileName);

				// ファイルを出力する物理パスの取得
				ServletContext application = request.getSession().getServletContext();
				String realPath = application.getRealPath("/") + fileName;
				System.out.println("realPath■" + realPath);

				// ファイルの出力ストリーム取得
				// (バイナリデータを出力するため)
				OutputStream output = new FileOutputStream(realPath);

				System.out.println("output■" + output);
				// アップロードされたファイルの入力ストリーム取得
				InputStream input = formFile.getInputStream();

				System.out.println("input■" + input);
				// バッファの設定
				byte[] buf = new byte[8192];
				int len;

				int i = 1;
				// ファイルを読み込んでデータをレスポンスに出力する
				// バッファを使って256バイトごとに読み書きする
				while((len = input.read(buf)) != -1) {
					System.out.println("FileUploadAndWriteAction ■" + (i++) + ":" + len);
					output.write(buf, 0, len);
				}
				//System.out.println(realPath);
				HttpSession session = request.getSession();
				session.setAttribute("photopath", fileName);
				// ストリームのクローズ
				input.close();
				output.close();

				// アップロードされたファイルの内容を破棄する
				formFile.destroy();




		}
			//hiddenで送られてきた物件コードを使ってデータを検索してlistに格納
			int code = Integer.parseInt(request.getParameter("code"));
			List<Room> list = dao.UpdateCheck(code);

			request.setAttribute("updateForm", updateForm);
			request.setAttribute("list", list);
			return mapping.findForward("check");
			}

		else if(update != null) {
			UpdateForm updateForm = (UpdateForm)form;



			//hiddenで送られてきた物件コードをcodeに格納
			int code = Integer.parseInt(request.getParameter("code"));
			List<Room> hoge = dao.DeleteCheck(code);
			Room room = hoge.get(0);
			File pic = new File("C:/eclipse/workspace/able/" + room.getPhoto());
			pic.delete();


			//物件内容更新処理
			int count = dao.Update(code, updateForm);

			//更新したあとのデータをshowに格納
			List<Room> show = dao.UpdateCheck(code);

			request.setAttribute("show", show);
			return mapping.findForward("update");
		}
		else if(back != null) {


			SearchForm searchForm =(SearchForm)form;
			//物件詳細表示
			List<Room> list = dao.UpdateCheck(searchForm.getCode());

			request.setAttribute("list", list);
			return mapping.findForward("confirm");
		}

		return mapping.findForward("update");

	}

	public void delete(UpdateForm updateform){

//		RoomCreateForm roomcreateform = (RoomCreateForm)form;
		File pic = new File("C:/eclipse/workspace/able/" + updateform.getPhoto());

		if (pic.exists()){
		    System.out.println(pic.getPath() + " : 画像は存在します。削除します。");
			pic.delete();
		}else{
		    System.out.println(pic.getPath() + " : 画像は存在しません");
		}
	}

}

