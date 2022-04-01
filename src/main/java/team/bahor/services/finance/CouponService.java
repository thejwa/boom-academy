package team.bahor.services.finance;

import org.springframework.stereotype.Service;
import team.bahor.dto.finance.CouponCreateDto;
import team.bahor.dto.finance.CouponDto;
import team.bahor.dto.finance.CouponUpdateDto;
import team.bahor.mappers.finance.CouponMapper;
import team.bahor.repositories.finance.CouponRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.base.GenericCrudService;
import team.bahor.validators.finance.CouponValidator;

import java.util.List;

@Service

public class CouponService extends AbstractService<CouponRepository, CouponMapper, CouponValidator>
        implements GenericCrudService<
        CouponDto,
        CouponCreateDto,
        CouponUpdateDto,
        String> {
    protected CouponService(CouponMapper mapper, CouponValidator validator, CouponRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CouponCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CouponUpdateDto updateDto) {

    }

    @Override
    public CouponDto get(String id) {
        return null;
    }

    @Override
    public List<CouponDto> getAll() {
        return null;
    }
}
