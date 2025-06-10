package ru.netology.springservletcrud.repository;

import ru.netology.springservletcrud.model.Post;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepository {
  private final Map<Long, Post> posts = new ConcurrentHashMap<>();
  private final AtomicLong counter = new AtomicLong();

  public List<Post> all() {
    return new ArrayList<>(posts.values());
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(posts.get(id));
  }

  public Post save(Post post) {
    if (post.getId() == 0) {
      post.setId(counter.incrementAndGet());
    }
    posts.put(post.getId(), post);
    return post;
  }

  public void removeById(long id) {
    posts.remove(id);
  }
}
