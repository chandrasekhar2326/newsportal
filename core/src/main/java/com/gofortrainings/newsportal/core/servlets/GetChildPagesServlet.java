package com.gofortrainings.newsportal.core.servlets;

import com.gofortrainings.newsportal.core.services.ChildPagesService;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.List;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/getChildPages",
                "sling.servlet.methods=GET"
        }
)
public class GetChildPagesServlet extends SlingAllMethodsServlet {

    @Reference
    private ChildPagesService childPagesService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        List<String> childPages = childPagesService.getChildPages();
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(childPages));
    }
}
