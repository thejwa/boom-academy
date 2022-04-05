package team.bahor.services.finance;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.bahor.dto.finance.CouponCreateDto;
import team.bahor.dto.finance.CouponDto;
import team.bahor.dto.finance.CouponUpdateDto;
import team.bahor.entity.finance.Coupon;
import team.bahor.mappers.finance.CouponMapper;
import team.bahor.repositories.finance.CouponRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.finance.CouponValidator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class CouponServiceImp extends AbstractService<CouponRepository, CouponMapper, CouponValidator>
        implements CouponService {
    protected CouponServiceImp(@Qualifier("couponMapperImpl") CouponMapper mapper, CouponValidator validator, CouponRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CouponCreateDto createDto) {

        validator.validOnCreate(createDto);
        Coupon coupon = mapper.fromCreateDto(createDto);
        coupon.setId(UUID.randomUUID().toString().replace("-", ""));
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
