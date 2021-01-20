package com.mvc.project.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mvc.common.util.FileRename;
import com.mvc.member.model.service.MemberService;
import com.mvc.member.model.vo.Member;
import com.mvc.project.model.service.ProjectService;
import com.mvc.project.model.vo.CarryProject;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/project/projectWrite")
public class ProjectWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectWrite() {
    }
    
    // 1.20 승현 projectWrite 호출하는 과정
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/project/projectWrite.jsp").forward(request, response);
	}
	
	// 1.20 승현 projectWrite 에서 값을 받아서 보내주는 과정(수정중...) - string>date형변환 content null값 이유...
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일에 대한 전송이 맞는지 확인 - projectWrite.jsp에서 Encrypt이 들어갔는지 확인하는 작업
		if(!ServletFileUpload.isMultipartContent(request)) {
			// enctype이 multipart/from-data가 아닌 경우 메시지 전송
			request.setAttribute("msg", "시스템에서 [enctype]에러! 관리자에게 문의하세요.");
			request.setAttribute("location", "/board/list");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
			return;
		}
		
		// 파일이 저장될 경로
		String path = getServletContext().getRealPath("/upload/proFile");
		
		// 파일의 사이즈(특정 사이즈까지만 받겠다.) 10mb 설정
		int maxSize = 1024 * 1024 * 10;
		
		// 문자에 대한 인코딩 값 설정
		String encoding = "UTF-8";
		
		// DefaultFileRenamePolicy
		// - 업로드된 파일에 대한 rename 처리
		// - 중복되는 이름 뒤에 0 ~ 9999
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
		
		// 클라이언트 폼 파라미터로 넘어온 값들(파일에 대한 정보x)
		String writer = mr.getParameter("writer");
		String company = mr.getParameter("company");
		String title = mr.getParameter("title");
		int targetAmount = Integer.parseInt(mr.getParameter("targetAmount"));
		
//		String projectEnrolldate = mr.getParameter("projectEnrolldate");
//		String projectEndDate = mr.getParameter("projectEndDate");
		
		String content = mr.getParameter("content");
		
		System.out.println("title : " + title + ", writer : " + writer + ", content : " + content);
		
		// 파일에 대한 정보를 가져올 때
		String fileName = mr.getFilesystemName("upfile");
		String upfileName = mr.getOriginalFileName("upfile");
		String contentType = mr.getContentType("upfile");
		File file = mr.getFile("upfile");
		
		System.out.println("fileName : " + fileName + ", upfileName : " + upfileName + ", contentType : " + contentType + ", file" + file);
//		System.out.println(file.getPath() + " " + file.getName());
		
//		System.out.println(request.getAttribute("title"));
		// 이 값은 null이 나온다. multipart으로 인코딩해서 처리했기 때문에 직접 가지고 올 수 없다.
		
		CarryProject project = new CarryProject();
		Member member = new MemberService().findMemberForPro(writer);
		
		project.setCreateNo(member.getUserNo());
		project.setProjectCompany(company);
		project.setProjectTitle(title);
		project.setTargetAmount(targetAmount);
//		project.setProjectEnrolldate(projectEnrolldate);
//		project.setProjectEnddate(projectEndDate);
		project.setImgRenamedName(fileName);
		
		
//		System.out.println(board);
		
		int result = new ProjectService().saveProject(project);
		String msg = null;
		
		if(result > 0) {
			msg = "게시글 등록 성공";
		} else {
			msg = "게시글 등록 실패";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/project/setReward");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
	}

}
