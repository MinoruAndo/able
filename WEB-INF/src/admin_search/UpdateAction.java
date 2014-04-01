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


		//jsp����submit���ꂽname���擾����
		String update = null;
		String check = null;
		String confirm = null;
		String back = null;

		update = request.getParameter("update");
		check = request.getParameter("check");
		confirm = request.getParameter("confirm");
		back = request.getParameter("back");


		//�擾����name���������򂵂ď�����I��

		//confirm��null����Ȃ����
		if(confirm != null) {


			SearchForm searchForm =(SearchForm)form;
			//�����ڍו\��
			List<Room> list = dao.UpdateCheck(searchForm.getCode());

			request.setAttribute("list", list);
			return mapping.findForward("confirm");
		}
		//check��null����Ȃ����
		else if(check != null) {
			//�X�V���e���擾
			UpdateForm updateForm = (UpdateForm)form;

			// �t�H�[���Ŏw�肳�ꂽ�t�@�C�����擾
			FormFile formFile = updateForm.getPhoto();

			// �t�@�C�������݂��Ă���΃��X�|���X�ɏo�͂���
			if(formFile != null && formFile.getFileSize() != 0) {
				// �t�@�C�������擾����
				String fileName = formFile.getFileName();
				System.out.println("fileName��" + fileName);

				// JSP�Ńt�@�C�����Q�Ƃ��鎞�̃p�X���X�R�[�v�ɓo�^����
				request.setAttribute("filePath", "/" + fileName);

				// �t�@�C�����o�͂��镨���p�X�̎擾
				ServletContext application = request.getSession().getServletContext();
				String realPath = application.getRealPath("/") + fileName;
				System.out.println("realPath��" + realPath);

				// �t�@�C���̏o�̓X�g���[���擾
				// (�o�C�i���f�[�^���o�͂��邽��)
				OutputStream output = new FileOutputStream(realPath);

				System.out.println("output��" + output);
				// �A�b�v���[�h���ꂽ�t�@�C���̓��̓X�g���[���擾
				InputStream input = formFile.getInputStream();

				System.out.println("input��" + input);
				// �o�b�t�@�̐ݒ�
				byte[] buf = new byte[8192];
				int len;

				int i = 1;
				// �t�@�C����ǂݍ���Ńf�[�^�����X�|���X�ɏo�͂���
				// �o�b�t�@���g����256�o�C�g���Ƃɓǂݏ�������
				while((len = input.read(buf)) != -1) {
					System.out.println("FileUploadAndWriteAction ��" + (i++) + ":" + len);
					output.write(buf, 0, len);
				}
				//System.out.println(realPath);
				HttpSession session = request.getSession();
				session.setAttribute("photopath", fileName);
				// �X�g���[���̃N���[�Y
				input.close();
				output.close();

				// �A�b�v���[�h���ꂽ�t�@�C���̓��e��j������
				formFile.destroy();




		}
			//hidden�ő����Ă��������R�[�h���g���ăf�[�^����������list�Ɋi�[
			int code = Integer.parseInt(request.getParameter("code"));
			List<Room> list = dao.UpdateCheck(code);

			request.setAttribute("updateForm", updateForm);
			request.setAttribute("list", list);
			return mapping.findForward("check");
			}

		else if(update != null) {
			UpdateForm updateForm = (UpdateForm)form;



			//hidden�ő����Ă��������R�[�h��code�Ɋi�[
			int code = Integer.parseInt(request.getParameter("code"));
			List<Room> hoge = dao.DeleteCheck(code);
			Room room = hoge.get(0);
			File pic = new File("C:/eclipse/workspace/able/" + room.getPhoto());
			pic.delete();


			//�������e�X�V����
			int count = dao.Update(code, updateForm);

			//�X�V�������Ƃ̃f�[�^��show�Ɋi�[
			List<Room> show = dao.UpdateCheck(code);

			request.setAttribute("show", show);
			return mapping.findForward("update");
		}
		else if(back != null) {


			SearchForm searchForm =(SearchForm)form;
			//�����ڍו\��
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
		    System.out.println(pic.getPath() + " : �摜�͑��݂��܂��B�폜���܂��B");
			pic.delete();
		}else{
		    System.out.println(pic.getPath() + " : �摜�͑��݂��܂���");
		}
	}

}

