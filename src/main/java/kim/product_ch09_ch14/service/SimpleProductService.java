package kim.product_ch09_ch14.service;

import kim.product_ch09_ch14.domain.Product;
import kim.product_ch09_ch14.dto.ProductDto;
import kim.product_ch09_ch14.infrastructure.DatabaseProductRepository;
import kim.product_ch09_ch14.infrastructure.ListProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {
    private  ValidationService validationService;
    private ModelMapper modelMapper;
private DatabaseProductRepository databaseProductRepository;
    private ListProductRepository listProductRepository;

    @Autowired
    SimpleProductService(DatabaseProductRepository databaseProductRepository, ModelMapper modelMapper
    , ValidationService validationService) {
        this.databaseProductRepository = databaseProductRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto) {
//        1.productDto를 Product로 변환
        Product product = modelMapper.map(productDto, Product.class);
        validationService.checkvalid(product);
//        리포지토리를 호출하는 코드
        Product savedProduct = databaseProductRepository.add(product);
//        2. Product를 productDto로 변환
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

//       Dto를 반환하는 코드
        return savedProductDto;
    }

    public ProductDto findById(Long id) {
        Product product = databaseProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> productList = databaseProductRepository.findAll();
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtoList;
    }
    
    public List<ProductDto> findByNameContaining(String name) {
        List<Product> productList = databaseProductRepository.findByNameContaining(name);
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtoList;
    }

    public ProductDto update(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = databaseProductRepository.update(product);
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);
        return savedProductDto;
    }

    public void delete(Long id) {

        databaseProductRepository.delete(id);

    }
}
