package com.webrealx.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.webrealx.service.impl.BookServiceImpl;
import com.webrelax.domain.Book;
import com.webrelax.service.BookService;
import com.webrelax.util.UUIDUtil;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//先判断是否支持文件上传 即 enctype="multipart/form-data"
		boolean flag=ServletFileUpload.isMultipartContent(request);
		if(!flag) {//不支持文件上传
			throw new RuntimeException("无multipart/form-data");
		}
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> fileItems=new ArrayList<FileItem>(0);
		//解决上传表单乱码
		sfu.setHeaderEncoding("utf-8");
		Book book=new Book();
		book.setId(UUIDUtil.getUUID());
		try {
			fileItems=sfu.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()) {
					//普通表单项
					String fieldname=fileItem.getFieldName();//字段名
					String fieldValue=null;
					fieldValue = fileItem.getString("UTF-8");//字段值
					
					switch(fieldname) {
						case "name":book.setName(fieldValue);break;
						case "pnum":book.setPnum(Integer.parseInt(fieldValue));break;
						case "price":book.setPrice(Double.parseDouble(fieldValue));break;
						case "description":book.setDescription(fieldValue);break;
						case "category":book.setCategory(fieldValue);break;
						default:System.out.println("not find book's elments");
					}
					
				}else {
					//上传文件表单项
					InputStream inputStream = fileItem.getInputStream();
					String filename = fileItem.getName();
					//得到文件后缀名
					String extension = FilenameUtils.getExtension(filename);
					if(!extension.equals("jsp")&&!extension.equals("exe")) {
					//	E:\JavaEE_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\ wtpwebapps\FileUpload\ upload
						File dir=new File(this.getServletContext().getRealPath("/upload"));
						if(!dir.exists()) {
							dir.mkdirs();
						}
						if(filename!=null) {//避免出现f:\图片\image\xx.jpg
							filename=FilenameUtils.getName(filename);
						}
						//避免重名
						filename=UUID.randomUUID().toString()+"_"+filename;
						//目录打散
						//根据文件名创建子目录 childDir= /a/b/xxx.jpg
						String childDir=makeChildDirectoryByName(dir, filename);
						book.setImgurl(childDir);
						
						File finalFileDir=new File(dir,childDir);
						fileItem.write(finalFileDir);
						fileItem.delete();
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//		//获取数据
//		Book book=new Book();
//		book.setId(UUIDUtil.getUUID());
//		book.setName(request.getParameter("name"));
//		book.setPrice(new Double(request.getParameter("price")));
//		book.setPnum(new Integer(request.getParameter("pnum")));
//		book.setCategory(request.getParameter("category"));
//		book.setDescription(request.getParameter("description"));
		//写入数据库
		BookService bs=new BookServiceImpl();
		bs.addBook(book);
		//同一个包内不用写斜杠，相对寻址
		request.getRequestDispatcher("BookListServlet").forward(request, response);
	}
	/**@Title: makeChildDirectory
	 * @TODO(根据文件名创建子目录)
	 * @return    参数
	 * @return String    返回类型  a/b/xxx.jpg
	 */
	private String makeChildDirectoryByName(File parent,String child) {
		int hashcode=child.hashCode();// 返回字符转换的32位hashcode码
		//System.out.println("filename's hashcode:"+hashcode);
		String hexString = Integer.toHexString(hashcode);//转换为16进制
	//	System.out.println("hexString:"+hexString);
		String childDir=hexString.charAt(0)+File.separator+hexString.charAt(1);// 例如：a/b目录
		File dir=new File(parent,childDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		return childDir+File.separator+child;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
