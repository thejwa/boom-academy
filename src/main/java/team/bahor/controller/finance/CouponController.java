package team.bahor.controller.finance;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.bahor.controller.AbstractController;
import team.bahor.dto.finance.CouponCreateDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.services.finance.CouponService;

@RestController
@RequestMapping("/coupon/")
public class CouponController extends AbstractController<CouponService> {
    public CouponController(CouponService service) {
        super(service);
    }

    @PostMapping("create")
    public ResponseEntity<DataDto<String>> create(@RequestBody CouponCreateDto dto) {
        return new ResponseEntity<>(new DataDto<>(service.create(dto)), HttpStatus.OK);

    }


}
