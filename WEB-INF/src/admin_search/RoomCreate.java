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

		// �A�N�V�����t�H�[�����L���X�g����
		RoomCreateForm roomCreateForm = (RoomCreateForm)form;

		// �t�H�[���Ŏw�肳�ꂽ�t�@�C�����擾
		FormFile formFile = roomCreateForm.getPhoto();

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

			String check = "C:\\eclipse\\workspace\\able\\" + fileName;


			System.out.println(realPath+check);

			if(realPath == check) {
				System.out.println("�d��");
				realPath = null;
				check = null;

				HttpSession session = request.getSession();
				session.removeAttribute("admin_search_RoomCreate");
				session.removeAttribute("photopath");
				return mapping.findForward("error");
			}

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

			return mapping.findForward("success");
		}

		// �t�@�C�����擾�ł��Ȃ������ꍇ
		return mapping.findForward("failure");
	}

	//�ʐ^�t�@�C�����������\�b�h
	public void delete(RoomCreateForm form){

//		RoomCreateForm roomcreateform = (RoomCreateForm)form;
		File pic = new File("C:/eclipse/workspace/able/" + form.getPhoto());

		if (pic.exists()){
		    System.out.println(pic.getPath() + " : �摜�͑��݂��܂��B�폜���܂��B");
			pic.delete();
		}else{
		    System.out.println(pic.getPath() + " : �摜�͑��݂��܂���");
		}
	}
}
