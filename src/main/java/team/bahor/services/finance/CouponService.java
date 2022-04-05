package team.bahor.services.finance;

import org.springframework.stereotype.Service;
import team.bahor.dto.finance.CouponCreateDto;
import team.bahor.dto.finance.CouponDto;
import team.bahor.dto.finance.CouponUpdateDto;
import team.bahor.entity.finance.Coupon;
import team.bahor.mappers.finance.CouponMapper;
import team.bahor.repositories.finance.CouponRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.base.GenericCrudService;
import team.bahor.validators.finance.CouponValidator;

import java.util.List;
import java.util.Optional;

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

        validator.thenAfter(createDto.getDueDate());

        Coupon coupon = mapper.fromCreateDto(createDto);

        return repository.save(coupon).getId();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CouponUpdateDto updateDto) {

    }

    @Override
    public CouponDto get(String id) {

        Optional<Coupon> couponOptional = repository.findById(id);
        Coupon coupon = couponOptional.get();

        return mapper.toDto(coupon);
    }

    @Override
    public List<CouponDto> getAll() {
        return null;
    }
}
