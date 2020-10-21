package org.todo;

import org.todo.model.Todo;
import org.todo.model.TodoList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet("/")
public class TodoListServlet extends HttpServlet {
    private final TodoList todos = new TodoList();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("todos", createTodoView());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String date = request.getParameter("date");
        LocalDate dueDate = null;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            dueDate = LocalDate.parse( date );
        } catch (DateTimeParseException e) {

        }

        todos.addTodo(new Todo(title, category.isEmpty() ? null : category, dueDate));

        request.setAttribute("todos", createTodoView());
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
    
    private String createTodoView() {
        StringBuilder view = new StringBuilder("");
        List<Todo> todos = this.todos.getTodos();
        for (Todo td : todos) {
            view.append("<hr>");
            addNewHtmlLine(view, "h3", td.getTitle());
            if(td.getCategory() != null) {
                addNewHtmlLine(view, "p", "Category: " + td.getCategory());
            }
            if(td.getDueDate() != null) {
                addNewHtmlLine(view, "p", "Due Date: " + td.getDueDate().toString());
            }
        }
        return view.toString();
    }

    private void addNewHtmlLine(StringBuilder html, String tag, String value) {
        String line = "<tag>value</tag>";
        line = line.replaceAll("tag", tag);
        line = line.replace("value", value);
        html.append(line);
    }
}
