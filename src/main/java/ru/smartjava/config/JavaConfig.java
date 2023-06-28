package ru.smartjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smartjava.controller.PostController;
import ru.smartjava.repository.PostRepository;
import ru.smartjava.repository.PostRepositoryImpl;
import ru.smartjava.service.PostService;

@Configuration
public class JavaConfig {

    @Bean
    public PostController PostController(PostService service) {
        return new PostController(service);
    }

    @Bean
    public PostService PostService(PostRepository repository) {
        return new PostService(repository);
    }

    @Bean
    public PostRepository PostRepository() {
        return new PostRepositoryImpl();
    }

}
