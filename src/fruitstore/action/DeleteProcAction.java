package fruitstore.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fruitstore.model.Kinds;
import fruitstore.repository.FruitRepository;



public class DeleteProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));		
		FruitRepository fruitRepository = FruitRepository.getInstance();
			
		int result = fruitRepository.deleteById(id);
		
		if(result ==1) {
			
			List<Kinds> kindsList = fruitRepository.firstPage();
			
			Gson gson = new Gson();
			
			String kindsListJson = gson.toJson(kindsList);
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(kindsListJson);
			
			
		} 
		
	}
	
}