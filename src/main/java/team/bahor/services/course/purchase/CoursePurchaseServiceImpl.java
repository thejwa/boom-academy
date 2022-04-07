package team.bahor.services.course.purchase;

import org.springframework.stereotype.Service;
import team.bahor.dto.course.purchase.CoursePurchaseCreateDto;
import team.bahor.dto.course.purchase.CoursePurchaseDto;
import team.bahor.dto.course.purchase.CoursePurchaseUpdateDto;
import team.bahor.mappers.course.CoursePurchaseMapper;
import team.bahor.repositories.course.CoursePurchaseRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.course.purchase.CoursePurchaseValidator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CoursePurchaseServiceImpl extends AbstractService<
        CoursePurchaseRepository,
        CoursePurchaseMapper,
        CoursePurchaseValidator> implements CoursePurchaseService {

    protected CoursePurchaseServiceImpl(CoursePurchaseMapper mapper, CoursePurchaseValidator validator, CoursePurchaseRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CoursePurchaseCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CoursePurchaseUpdateDto updateDto) {

    }

    @Override
    public CoursePurchaseDto get(String id) {
        return null;
    }

    @Override
    public List<CoursePurchaseDto> getAll() {
        return null;
    }

    public List<CoursePurchaseDto> getAll(String userId) {
        return null;
    }

}
