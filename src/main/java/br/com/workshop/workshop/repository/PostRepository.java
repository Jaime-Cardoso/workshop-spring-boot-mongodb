package br.com.workshop.workshop.repository;

import br.com.workshop.workshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    Post findOne(String id);
}
