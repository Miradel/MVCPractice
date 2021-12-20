package ticketingprjct.meradel.service;

import ticketingprjct.meradel.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {


    List<UserDTO> findManagers();
    List<UserDTO> findEmployee();

    /*
     Service is based on business logic like :

     save
     DeleteUser
     Edit User

     */

//    UserDTO save(UserDTO user);
//    UserDTO findByID(String userName);
//    List<UserDTO> findAll();
//    void delete(UserDTO user);
//    void deleteByID(String userName);


}
