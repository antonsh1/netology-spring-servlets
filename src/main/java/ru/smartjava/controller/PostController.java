package ru.smartjava.controller;

import com.google.gson.Gson;
import ru.smartjava.model.Post;
import ru.smartjava.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public class PostController {
    public static final String APPLICATION_JSON = "application/json";
    private final PostService service;
    private final Gson gson = new Gson();

    public PostController(PostService service) {
        this.service = service;
    }

    public void all(HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var data = service.all();
        response.getWriter().print(gson.toJson(data));
    }

    public void getById(long id, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final Optional<Post> data = service.getById(id);
        if (data.isPresent()) {
            response.getWriter().print(gson.toJson(data.get()));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    public void save(Reader body, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final Post post = gson.fromJson(body, Post.class);
        if (post.getId() == 0 || service.getById(post.getId()).isPresent()) {
            final Post data = service.save(post);
            response.getWriter().print(gson.toJson(data));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void removeById(long id, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        Optional<Post> post = service.getById(id);
        if (post.isPresent()) {
            service.removeById(id);
            response.getWriter().print(gson.toJson(post.get()));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
