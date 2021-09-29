package com.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chat.controller.chatService;
import com.chat.model.Chat;
import com.chat.model.inputChat;
import com.google.gson.Gson;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet(urlPatterns = {"/chats/*"}, name = "chatApplication" , description = "Runs in Json")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private chatService service = new chatService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getPathInfo();
		System.out.println(url);
		if(url == null) {
			List<Chat> chats = new ArrayList<>();
			chats = service.getAllChats();
			Gson gson = new Gson();
			String chatJson = gson.toJson(chats);
			PrintWriter printwriter = response.getWriter();
			response.setContentType("Application/Json");
			response.setCharacterEncoding("UTF-8");
			printwriter.write(chatJson);
			for(int i=0;i<chats.size();i++) {
				chats.get(i).setMessageStatus("Recieved");
			}
		}else {
//			List<Chat> chats = new ArrayList<>();
			Chat obj = new Chat();
			int pathurl = Integer.parseInt(url.substring(1, url.length()));
			obj = service.getChat(pathurl);
			Gson gson = new Gson();
			String chatJson = gson.toJson(obj);
			PrintWriter printwriter = response.getWriter();
			response.setContentType("Application/Json");
			response.setCharacterEncoding("UTF-8");
			printwriter.write(chatJson);
//			chats.get(pathurl).setMessage("Read");
//			System.out.println(url.substring(1, url.length()));
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inputChat data = new Gson().fromJson(request.getReader(), inputChat.class);
		Chat obj = new Chat();
		obj = service.addChat(data);
		PrintWriter printwriter = response.getWriter();
		response.setContentType("Application/Json");
		response.setCharacterEncoding("UTF-8");
		printwriter.write("Recieved");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		inputChat data = new Gson().fromJson(request.getReader(), inputChat.class);
		Chat obj = new Chat();
		obj = service.updateChat(data);
		Gson gson = new Gson();
		String chatJson = gson.toJson(obj);
		PrintWriter printwriter = response.getWriter();
		response.setContentType("Application/Json");
		response.setCharacterEncoding("UTF-8");
		printwriter.write(chatJson);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getPathInfo();
		//System.out.println(url);
		Chat obj = new Chat();
		obj = service.removeChat(Integer.parseInt(url.substring(1, url.length())));
		Gson gson = new Gson();
		String chatJson = gson.toJson(obj);
		PrintWriter printwriter = response.getWriter();
		response.setContentType("Application/Json");
		response.setCharacterEncoding("UTF-8");
		printwriter.write(chatJson);
	}

}
