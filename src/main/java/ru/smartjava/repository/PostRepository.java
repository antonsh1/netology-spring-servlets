package ru.smartjava.repository;

import ru.smartjava.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

// Stub
public interface PostRepository {

    ConcurrentHashMap<Long, Post> repo = new ConcurrentHashMap<>();
    AtomicLong index = new AtomicLong(0);

    public List<Post> all();

    public Optional<Post> getById(long id);

    public Post save(Post post);

    public void removeById(long id);
}
