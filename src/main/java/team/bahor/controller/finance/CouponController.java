package team.bahor.controller.finance;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import team.bahor.controller.AbstractController;
import team.bahor.dto.finance.CouponCreateDto;
import team.bahor.dto.finance.CouponDto;
import team.bahor.dto.finance.CouponUpdateDto;
import team.bahor.dto.responce.AppErrorDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.services.finance.CouponService;

import javax.validation.Valid;

@RestController
@RequestMapping("/coupon/")
public class CouponController extends AbstractController<CouponService> {
    public CouponController(CouponService service) {
        super(service);
    }

    @PostMapping("create")
    public ResponseEntity<DataDto<String>> create(@Valid @RequestBody CouponCreateDto dto, BindingResult result, WebRequest request) {
        if (result.hasErrors()) {
            //TODO hibernate validation erorrlarini chiroyli formatda handle qilish kerak
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto("error", "hibernate validation error, path:" + CouponCreateDto.class.getName())), HttpStatus.OK);

        }
        return new ResponseEntity<>(new DataDto<>(service.create(dto)), HttpStatus.OK);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<DataDto<CouponDto>> get(@PathVariable String id) {
        return new ResponseEntity<>(new DataDto<>(service.get(id)), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<DataDto<String>> update(@PathVariable String id, @RequestBody CouponUpdateDto dto) {
        dto.setId(id);
        service.update(dto);
        return new ResponseEntity<>(new DataDto<>("Updated"), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<DataDto<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new DataDto<>("deleted"), HttpStatus.OK);
    }


}
