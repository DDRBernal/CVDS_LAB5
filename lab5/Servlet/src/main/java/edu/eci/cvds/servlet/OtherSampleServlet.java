package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/HolaServlet"
)
public class OtherSampleServlet extends HttpServlet{
    static final long serialVersionUID = 35L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
        try{
            int id = Integer.parseInt(name);
            Todo todo = Service.getTodo(id);
            if(todo!= null) resp.setStatus(HttpServletResponse.SC_NOT_FOUND); 
            ArrayList<Todo> todoList = new ArrayList<>(); todoList.add(todo);
            responseWriter.write(Service.todosToHTMLTable(todoList));
            responseWriter.flush();           
            resp.setStatus(HttpServletResponse.SC_OK);
        }catch (MalformedURLException ex){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        catch(NumberFormatException | IOException ex){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }       
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optId = Optional.ofNullable(req.getParameter("ID"));
        String id_S = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
        try{
            int id = Integer.parseInt(id_S);
            Todo todo = Service.getTodo(id);
            if(todo!= null) resp.setStatus(HttpServletResponse.SC_NOT_FOUND); 
            ArrayList<Todo> todoList = new ArrayList<>(); todoList.add(todo);
            responseWriter.write(Service.todosToHTMLTable(todoList));
            responseWriter.flush();           
            resp.setStatus(HttpServletResponse.SC_OK);
        }catch (MalformedURLException ex){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        catch(NumberFormatException | IOException ex){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }       
    }
}