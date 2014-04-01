package admin_search;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class RoomCreate extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームをキャストする
		RoomCreateForm roomCreateForm = (RoomCreateForm)form;

		// フォームで指定されたファイルを取得
		FormFile formFile = roomCreateForm.getPhoto();

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

			String check = "C:\\eclipse\\workspace\\able\\" + fileName;


			System.out.println(realPath+check);

			if(realPath == check) {
				System.out.println("重複");
				realPath = null;
				check = null;

				HttpSession session = request.getSession();
				session.removeAttribute("admin_search_RoomCreate");
				session.removeAttribute("photopath");
				return mapping.findForward("error");
			}

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

			return mapping.findForward("success");
		}

		// ファイルが取得できなかった場合
		return mapping.findForward("failure");
	}

	//写真ファイルを消すメソッド
	public void delete(RoomCreateForm form){

//		RoomCreateForm roomcreateform = (RoomCreateForm)form;
		File pic = new File("C:/eclipse/workspace/able/" + form.getPhoto());

		if (pic.exists()){
		    System.out.println(pic.getPath() + " : 画像は存在します。削除します。");
			pic.delete();
		}else{
		    System.out.println(pic.getPath() + " : 画像は存在しません");
		}
	}
}
