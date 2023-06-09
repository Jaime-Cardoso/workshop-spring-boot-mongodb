package br.com.workshop.workshop.service;

import br.com.workshop.workshop.domain.Post;
import br.com.workshop.workshop.repository.PostRepository;
import br.com.workshop.workshop.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Post user = postRepository.findOne(id);
        if (user == null) {
            throw new ObjectNotFoundException("Obejeto não encontrado");
        }
        return user;
    }
    public List<Post> findbuTitle(String text){
        return postRepository.searchTitle(text);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text,minDate,maxDate);
    }
}
