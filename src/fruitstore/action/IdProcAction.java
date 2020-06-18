package fruitstore.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fruitstore.model.Kinds;
import fruitstore.repository.FruitRepository;



public class IdProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FruitRepository fruitRepository = FruitRepository.getInstance();
		List<Kinds> kindslist= fruitRepository.firstPage();
		// request.setAttribute("kindslist", kindslist);
		//System.out.println("FirstAction : kindslist.size() : " + kindslist.size());
		
		// RequestDispatcher dis = request.getRequestDispatcher("/table.jsp");
		// dis.forward(request, response);
		
		Gson gson = new Gson();
		String kindslistJson = gson.toJson(kindslist);
		
		System.out.println("IdProcAction : execute() : kindslistJson :" + kindslistJson);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(kindslistJson);
	}
	
}