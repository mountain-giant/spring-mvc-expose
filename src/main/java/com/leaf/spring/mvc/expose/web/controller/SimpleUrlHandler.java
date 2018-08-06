package com.leaf.spring.mvc.expose.web.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleUrlHandler implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name","SimpleUrlHandler");
        request.setAttribute("age","109");

        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }
}
