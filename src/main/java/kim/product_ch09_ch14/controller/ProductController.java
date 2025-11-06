package kim.product_ch09_ch14.controller;

import kim.product_ch09_ch14.dto.ProductDto;
import kim.product_ch09_ch14.service.SimpleProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }
//RequestMapping은 동일한 경로로 다른메서드들을 추가할수가 없다
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
        return simpleProductService.add(productDto);
    }

    @GetMapping("/products/{id}")
    public ProductDto findProductById(@PathVariable Long id){
        return simpleProductService.findById(id);
    }
//RequestParam 을 사용해서 products?name=ㅇㄹㄴㄹ 이 가능하다
    @GetMapping("/products")
    public List<ProductDto> findProducts(@RequestParam(required = false) String name){
        if (null == name) {
            return simpleProductService.findAll();
        }
        return simpleProductService.findByNameContaining(name);
    }
//    상품 수정하기
    @PutMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        productDto.setId(id);
        return simpleProductService.update(productDto);
    }
//    상품 삭제하기
    @DeleteMapping("/products/{id}")
    public  void deleteProduct(@PathVariable Long id){
        simpleProductService.delete(id);

    }

}
