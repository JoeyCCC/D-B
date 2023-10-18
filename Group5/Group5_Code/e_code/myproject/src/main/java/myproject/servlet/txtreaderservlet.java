package myproject.servlet;

import myproject.dao.impl.txtreader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/txtreaderservlet")
public class txtreaderservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inputFilePath = "C:\\Users\\jacky\\Desktop\\data.txt";
        String outputImagePath = "C:\\Users\\jacky\\eclipse-workspace\\myproject\\src\\main\\webapp\\map\\path.png";

        txtreader.visualizePath(inputFilePath, outputImagePath);

        response.getWriter().write("Path Visualized Successfully! Image saved at: " + outputImagePath);
    }
}

