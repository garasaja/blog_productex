package fruitstore.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruitstore.model.Kinds;
import fruitstore.repository.FruitRepository;



public class FirstProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FruitRepository fruitRepository = FruitRepository.getInstance();
		List<Kinds> kindslist= fruitRepository.firstPage();
		request.setAttribute("kindslist", kindslist);
		//System.out.println("FirstAction : kindslist.size() : " + kindslist.size());
		
		RequestDispatcher dis = request.getRequestDispatcher("/table.jsp");
		dis.forward(request, response);
	}
	
}