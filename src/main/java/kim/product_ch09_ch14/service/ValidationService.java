package kim.product_ch09_ch14.service;


import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidationService {

    public <T> void  checkvalid(@Valid T validatioTarget){
//        do nothing
    }
}
