package ticketingprjct.meradel.converter;

import com.sun.tools.javac.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ticketingprjct.meradel.dto.UserDTO;
import ticketingprjct.meradel.service.UserService;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConvertor implements Converter<String, UserDTO> {

/*

Because of this error, we need to use this converter

Cannot convert value of type 'java.lang.String' to required type 'ticketingprjct.meradel.dto.UserDTO'
for property 'assignedManager': no matching editors or conversion strategy found]
 */


    @Autowired
    UserService userService;


    @Override
    public UserDTO convert(String id) {
        return userService.findById(id);
    }
}
