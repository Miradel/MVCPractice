package ticketingprjct.meradel.implementation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ticketingprjct.meradel.dto.UserDTO;
import ticketingprjct.meradel.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {


    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public UserDTO save(UserDTO object) {
        return super.save( object.getUserName(),object );
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(),object);
    }

    @Override
    public void deleteById(String userName) {
        super.deleteById(userName);
    }

    @Override
    public void delete(UserDTO object) {
        super.delete(object);
    }

    @Override
    public UserDTO findById(String userName) {
        return super.findById(userName);
    }


    @Override
    public List<UserDTO> findManagers() {

        return  super.findAll().stream().filter( user -> user.getRole().getId() == 2 ).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployee() {

        return super.findAll().stream().filter( userDTO -> userDTO.getRole().getId() == 3 ).collect(Collectors.toList());
    }
}
