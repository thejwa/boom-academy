package team.bahor.controller.finance;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.controller.AbstractController;
import team.bahor.dto.finance.CouponCreateDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.services.finance.CouponServiceImp;

@RestController
@RequestMapping("/coupon/")
public class CouponController extends AbstractController<CouponServiceImp> {

    public CouponController(CouponServiceImp service) {
        super(service);
    }

    @PostMapping("create")
    public ResponseEntity<DataDto<String>> create(@RequestBody CouponCreateDto dto) {
        return new ResponseEntity<>(new DataDto<>(service.create(dto)), HttpStatus.OK);

    }


}
