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



public class CountPriceDescProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FruitRepository fruitRepository = FruitRepository.getInstance();
		List<Kinds> kindslist = fruitRepository.countpriceDesc();
		request.setAttribute("kindslist", kindslist);
		
		Gson gson = new Gson();
		String kindslistJson = gson.toJson(kindslist);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(kindslistJson);
	}
	
}