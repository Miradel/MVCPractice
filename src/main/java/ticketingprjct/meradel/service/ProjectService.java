package ticketingprjct.meradel.service;

import ticketingprjct.meradel.dto.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO,String> {

    void complete(ProjectDTO projectDTO);
}
