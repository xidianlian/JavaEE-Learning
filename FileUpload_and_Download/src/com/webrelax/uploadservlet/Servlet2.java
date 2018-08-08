package com.webrelax.uploadservlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * 使用apache commons jar包获取上传文件
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//先判断是否支持文件上传 即 enctype="multipart/form-data"
		boolean flag=ServletFileUpload.isMultipartContent(request);
		if(!flag) {//不支持文件上传
			throw new RuntimeException("无multipart/form-data");
		}
		//1.创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//2.创建一个ServletFileUpload核心对象
		ServletFileUpload sfu=new ServletFileUpload(factory);
		// 指定临时文件的存储目录,用于观察
		//factory.setRepository(new File("f:\\"));
		//解决上传表单乱码
		sfu.setHeaderEncoding("utf-8");
		//3.解析request对象，并得到一个表单项的集合(List)
		try {
			//限制上传文件的大小 3M
			sfu.setFileSizeMax(1024*1024*3);
			List<FileItem> fileItems=sfu.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()) {
					//普通表单项
					processFormItem(fileItem);
				}else{
					//上传表单项
					processUplodaItem(fileItem);
				}
			}
		}catch(FileUploadBase.FileSizeLimitExceededException e) {
			System.out.println("文件过大，不能超过3M");
		}catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**@Title: processFormItem
	 * @TODO(普通表单项)
	 * @param fileItem    参数
	 * @return void    返回类型
	 */
	private void processFormItem(FileItem fileItem) {
		String fieldname=fileItem.getFieldName();//字段名
		String fieldValue=null;
		try {
			fieldValue = fileItem.getString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//字段值
		
		System.out.println(fieldname+" : "+fieldValue);
	}
	
	/**@Title: processUplodaItem
	 * @TODO(上传表单项)
	 * @param fileItem    参数
	 * @return void    返回类型
	 */
	private void processUplodaItem(FileItem fileItem) {
		//得到上传文件名
		String filename=fileItem.getName();//a.txt f:\图片\image\xx.jpg
		if("".equals(filename))return;
		try {
			//得到文件输入流
			InputStream inputStream = fileItem.getInputStream();
			//创建文件存盘路径,服务器路径，如下，或者再tomcatwork目录下
			//E:\JavaEE_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FileUpload\ upload
			//A、保证服务器安全：保存路径写在/WEB-INF下，防止客户端读取该文件（如果上传一个包含指令的jsp文件，服务器执行该指令就出问题了）
			String realPath=this.getServletContext().getRealPath("/WEB-INF/upload");
			System.out.println(realPath);
			File dir=new File(realPath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			//不同浏览器会将filename解析为f:\图片\image\xx.jpg(IE) 或者xx.jsp，这样导致...\ upload\f:\图片\image\xx.jpg
			//处理文件名
			
			/*方法1
			lastIndexOf返回值可能为-1，那么+1就刚好为字符串首字母
			File.separator是 与系统有关的默认名称分隔符,"\","/"，liunx下也好用
			filename=filename.substring(filename.lastIndexOf(File.separator)+1)；
			*/
			/*方法2*/
			if(filename!=null) {
				filename=FilenameUtils.getName(filename);
			}
			//B、避免重名
			filename=UUID.randomUUID().toString()+"_"+filename;
			System.out.println("filename:"+filename);
			//C、目录打散
			//根据文件名创建子目录
			dir=makeChildDirectoryByName(dir, filename);
			//根据当前日期创建子目录
			//dir=makeChildDirectoryByDate(dir);
			
			
			//dir目录下创建一个文件
			File file =new File(dir,filename);
			//通过输出流，保存到磁盘
			
			/*方法1
			FileOutputStream fos=new FileOutputStream(file);
			int len=0;
			byte[] b=new byte[1024];
			while((len=inputStream.read(b))!=-1) {
				fos.write(b, 0, len);
			}
			fos.close();
			inputStream.close();
			//由于默认缓存大小为10kb，见DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD
			//会创建一个临时文件，这样就导致保存了两个同样大小的文件，浪费存储空间.
			fileItem.delete();//删除临时文件
			*/
			/*方法2*/
			fileItem.write(file);
			fileItem.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**@Title: makeChildDirectoryByDate
	 * @TODO(根据日期创建子目录))
	 * @param dir
	 * @return    参数
	 * @return File    返回类型
	 */
	private File makeChildDirectoryByDate(File parent) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date());
		File dir=new File(parent,date);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}
	/**@Title: makeChildDirectory
	 * @TODO(根据文件名创建子目录)
	 * @return    参数
	 * @return File    返回类型
	 */
	private File makeChildDirectoryByName(File parent,String child) {
		int hashcode=child.hashCode();// 返回字符转换的32位hashcode码
		System.out.println("filename's hashcode:"+hashcode);
		String hexString = Integer.toHexString(hashcode);//转换为16进制
		System.out.println("hexString:"+hexString);
		String childDir=hexString.charAt(0)+File.separator+hexString.charAt(1);// 例如：a/b目录
		File dir=new File(parent,childDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
