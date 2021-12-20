package ticketingprjct.meradel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ticketingprjct.meradel.entity.Role;
import ticketingprjct.meradel.enums.Gender;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    /*

    DTO ==> Data Transfer Object

    DTO and entity are two different Pojo , Dto worked with controller and Entity works with DataBase, there is Mapper in the middle to help
    connect these two.

    Some fields(userCreated time and updated time) only need to show in Database and not it controller, so that we need these two pojo
     */
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;

}
