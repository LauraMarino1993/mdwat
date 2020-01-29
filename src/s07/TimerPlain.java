package s07;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s07/timerPlain")// se uno mi chiama nella mia webapp la risorsa s07/timerplain...è associata a questo indirizzo
public class TimerPlain extends HttpServlet { //timerplain è una servlet
    private static final long serialVersionUID = 1L;

    @Override //verrà eseguito il seguente codice
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//doGet riceve come parametri richiesta e risposta
            throws ServletException, IOException {//throws: potrebbe lanciare eccezioni di questo tipo
        response.setContentType("text/plain");// ti sto mandando come risposta un text/plain, un testo semplice
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {//la response si presenta come un writer, come fosse un file, su cui posso usare println
            writer.println(LocalTime.now());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//implementa il comando post di http. 
            throws ServletException, IOException { 
        doGet(request, response);//se qualcuno chiama doPost, rimanda al metodo doGet
    }
}
