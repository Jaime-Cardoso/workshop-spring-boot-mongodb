package br.com.workshop.workshop.service;

import br.com.workshop.workshop.domain.User;
import br.com.workshop.workshop.dto.UserDTO;
import br.com.workshop.workshop.repository.UserRepository;
import br.com.workshop.workshop.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(String id){
        User user = userRepository.findOne(id);
        if (user == null){
            throw new ObjectNotFoundException("Obejeto não encontrado");
        }
        return user;
    }
    public User insert(User obj){
        return userRepository.insert(obj);
    }
    public User fromDto(UserDTO objeto){
        return new User(objeto.getId(), objeto.getName(), objeto.getEmail());
    }
}
