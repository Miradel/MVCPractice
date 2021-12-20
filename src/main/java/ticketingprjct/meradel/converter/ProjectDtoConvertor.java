package ticketingprjct.meradel.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ticketingprjct.meradel.dto.ProjectDTO;
import ticketingprjct.meradel.dto.TaskDTO;
import ticketingprjct.meradel.dto.UserDTO;
import ticketingprjct.meradel.service.ProjectService;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConvertor implements Converter<String, ProjectDTO> {

    @Autowired
    ProjectService projectService;


    @Override
    public ProjectDTO convert(String source) {
        return projectService.findById(source);
    }
}
