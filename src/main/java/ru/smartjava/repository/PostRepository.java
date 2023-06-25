package ru.smartjava.repository;

import ru.smartjava.model.Post;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// Stub
public class PostRepository {

  ConcurrentHashMap<Long,Post> repo = new ConcurrentHashMap<>();
  public List<Post> all() {
    return (List<Post>) repo.values();
//    return Collections.emptyList();
  }

  public Optional<Post> getById(long id) {
    if(repo.containsKey(id)) {
      return Optional.ofNullable(repo.get(id));
    } else {
      return Optional.empty();
    }
  }

  public Post save(Post post) {
    return post;
  }

  public void removeById(long id) {
  }
}
