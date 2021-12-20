package ticketingprjct.meradel.implementation;

import org.springframework.stereotype.Service;
import ticketingprjct.meradel.dto.ProjectDTO;
import ticketingprjct.meradel.enums.Status;
import ticketingprjct.meradel.service.ProjectService;

import java.time.LocalDate;
import java.util.List;
@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(),object);
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(),object);

    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void delete(ProjectDTO object) {
        super.delete(object);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO projectDTO) {
        projectDTO.setProjectStatus(Status.COMPLETE);
        projectDTO.setEndDate(LocalDate.now());
        super.save(projectDTO.getProjectCode(),projectDTO);
    }
}
