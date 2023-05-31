package br.com.workshop.workshop.repository;

import br.com.workshop.workshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    Post findOne(String id);
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': {$regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String text);
}
