package br.com.workshop.workshop.config;

import br.com.workshop.workshop.domain.Post;
import br.com.workshop.workshop.domain.User;
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

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São paulo abraços", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
