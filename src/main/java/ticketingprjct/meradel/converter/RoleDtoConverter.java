package ticketingprjct.meradel.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ticketingprjct.meradel.dto.RoleDTO;
import ticketingprjct.meradel.service.RoleService;

@Component
@ConfigurationPropertiesBinding
//It automatically run when this annotation is here and convert to role Object according to its string ID
public class RoleDtoConverter implements Converter<String,RoleDTO> {

    @Autowired
    RoleService roleService;

    @Override
    public RoleDTO convert(String source) {

        RoleDTO object = new RoleDTO();
        object = roleService.findById( Long.parseLong(source));

        return object;
    }
}
