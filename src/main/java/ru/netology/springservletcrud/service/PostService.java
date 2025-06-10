package ru.netology.springservletcrud.service;

import org.springframework.stereotype.Service;
import ru.netology.springservletcrud.exception.NotFoundException;
import ru.netology.springservletcrud.model.Post;
import ru.netology.springservletcrud.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(() -> new NotFoundException("Post not found"));
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
