package com.wyu.goods.servlet;

import com.wyu.bean.Goods;
import com.wyu.service.GoodsService;
import com.wyu.service.impl.GoodsServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@WebServlet("/addGoods")
public class AddGoods extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Goods goods = new Goods();
		GoodsService service = new GoodsServiceImpl();
		Map<String, String[]> map = new HashMap<String,String[]>();
		//1.��������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2.����������
		ServletFileUpload upload = new ServletFileUpload(factory);
		//3.�õ�����
		try {
			List<FileItem> items = upload.parseRequest(req);
			for(FileItem item : items){
				if(item.isFormField()){
					//��ȡ����
					String name = item.getFieldName();
					//��ȡֵ
					String value = item.getString("utf-8");
					map.put(name, new String[]{value});
				}else{
					//1.�����洢���ļ���
					String uploadPath ="C:\\Users\\Administrator\\Desktop\\code\\shangcheng\\WebContent\\image";
				//	String uploadPath = "C:\\Users\\Administrator\\Desktop\\shangcheng\\WebContent\\image\\";
					File storePath = new File(uploadPath);
					if(!storePath.exists()){
						storePath.mkdirs();
					}
					//2.��ȡ�ļ��ϴ���
					String fileName = item.getName();
					if(fileName!=null){
						fileName = FilenameUtils.getName(fileName);
					}
					//3.��ɢ���� �� Ŀ¼
					fileName = UUID.randomUUID()+"_"+fileName;
					String path = makeDir(storePath,fileName);
					fileName = path + File.separator + fileName;
					File file = new File(storePath,fileName);
					item.write(file);

					map.put(item.getFieldName(), new String[]{fileName});
				}
			}
			//��map���� ���뵽 goods ������
			BeanUtils.populate(goods, map);
			boolean b = service.addGoods(goods);
			if(b){
				req.getRequestDispatcher("getGoodsList").forward(req, resp);
			}else{
				System.out.println("û���ȥ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String makeDir(File storePath, String fileName) {
		int code = fileName.hashCode();
		fileName = Integer.toHexString(code);
		String str = fileName.charAt(0)+File.separator+fileName.charAt(1);
		File file = new File(storePath,str);
		if(!file.exists()){
			file.mkdirs();
		}
		return str;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
