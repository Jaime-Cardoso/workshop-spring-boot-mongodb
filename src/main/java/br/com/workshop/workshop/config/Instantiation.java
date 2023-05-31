package br.com.workshop.workshop.config;

import br.com.workshop.workshop.domain.Post;
import br.com.workshop.workshop.domain.User;
import br.com.workshop.workshop.dto.AuthorDTO;
import br.com.workshop.workshop.dto.CommetDTO;
import br.com.workshop.workshop.repository.PostRepository;
import br.com.workshop.workshop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    private UserRepository userRepository;

    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GNT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São paulo abraços",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(maria));

        CommetDTO c1 = new CommetDTO("Boa viagem mano",sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommetDTO c2 = new CommetDTO("Aproveite",sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommetDTO c3 = new CommetDTO("Tenha um ótimo dia",sdf.parse("23/03/2018"), new AuthorDTO(alex));
        post1.getCommetDTOS().addAll(Arrays.asList(c1, c2));
        post2.getCommetDTOS().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
