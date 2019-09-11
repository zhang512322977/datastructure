package org.buptdavid.datastructure.springmvc;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet
{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
       ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(("<html>ok</html>").getBytes());
        outputStream.flush();

       //resp.sendError(200,"hello");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        doPost(req,resp);
    }
}
