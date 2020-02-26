package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.*;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

@WebServlet(
    urlPatterns = "/servlet2"
)
public class SampleServlet2 extends HttpServlet{
    static final long serialVersionUID = 35L;
	List<Todo> todolist = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
	    
		try{
			if (todo!=null){
				int ID = Integer.parseInt(id);
				Todo todo = Service.getTodo(ID);
				todolist.add(todo);
				responseWriter.write(Service.todosToHTMLTable(todolist));
				responseWriter.flush();
				resp.setStatus(HttpServletResponse.SC_OK);
			}else{
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				
			}
		}catch (NumberFormatException | IOException e){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}catch (MalformedURLException e){
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
        //resp.setStatus(HttpServletResponse.SC_OK);
        //responseWriter.write("id: " + id );
        
   }
}
