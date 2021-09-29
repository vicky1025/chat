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

import com.chat.controller.ContactService;
import com.chat.model.Contact;
import com.chat.model.inputContact;
//import com.chat.model.inputContact;
import com.google.gson.Gson;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet(urlPatterns = {"/contacts/*"}, name = "Contacts" , description = "Runs in Json")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactService service = new ContactService();

    /**
     * Default constructor. 
     */
    public ContactServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getPathInfo();
		System.out.println(url);
		if(url == null) {
			List<Contact> contacts = new ArrayList<>();
			contacts = service.getAllContacts();
			Gson gson = new Gson();
			String contactJson = gson.toJson(contacts);
			PrintWriter printwriter = response.getWriter();
			response.setContentType("Application/Json");
			response.setCharacterEncoding("UTF-8");
			printwriter.write(contactJson);
				
		}else {
			Contact obj = new Contact();
			obj = service.getContact(Integer.parseInt(url.substring(1, url.length())));
			Gson gson = new Gson();
			String contactJson = gson.toJson(obj);
			PrintWriter printwriter = response.getWriter();
			response.setContentType("Application/Json");
			response.setCharacterEncoding("UTF-8");
			printwriter.write(contactJson);
			System.out.println(url.substring(1, url.length()));
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				inputContact data = new Gson().fromJson(request.getReader(), inputContact.class);
				Contact obj = new Contact();
				obj = service.addContact(data);
				
				PrintWriter printwriter = response.getWriter();
				response.setContentType("Application/Json");
				response.setCharacterEncoding("UTF-8");
				printwriter.write("Recieved");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Contact> contacts = new ArrayList<>();
		inputContact data = new Gson().fromJson(request.getReader(), inputContact.class);
		Contact obj = new Contact();
//		System.out.println(data.getContactId());
		obj = service.updateContact(data);
		Gson gson = new Gson();
		String contactJson = gson.toJson(obj);
		PrintWriter printwriter = response.getWriter();
		response.setContentType("Application/Json");
		response.setCharacterEncoding("UTF-8");
		printwriter.write(contactJson);
//		contacts..setMessageStatus("Read");
		
//		String url = request.getPathInfo();
//		System.out.println(url);
//		Contact update = new Contact();
//		int i = Integer.parseInt(url.substring(1, url.length()));
//		update = service.getContact(Integer.parseInt(url.substring(1, url.length())));
		
//		System.out.println(update);
//		Contact input = new Contact(contacts.size() + 1,data.getPhoneNo() , data.getFirstName(), data.getLastName(),data.getEmail());
//		int temp=contacts.size()+1;
//		return contacts.put(temp,input);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getPathInfo();
		//System.out.println(url);
		Contact obj = new Contact();
		obj = service.removeContact(Integer.parseInt(url.substring(1, url.length())));
		Gson gson = new Gson();
		String contactJson = gson.toJson(obj);
		PrintWriter printwriter = response.getWriter();
		response.setContentType("Application/Json");
		response.setCharacterEncoding("UTF-8");
		printwriter.write(contactJson);
	}

}
