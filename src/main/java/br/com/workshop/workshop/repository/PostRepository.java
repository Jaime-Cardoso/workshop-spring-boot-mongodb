package br.com.workshop.workshop.repository;

import br.com.workshop.workshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    Post findOne(String id);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
