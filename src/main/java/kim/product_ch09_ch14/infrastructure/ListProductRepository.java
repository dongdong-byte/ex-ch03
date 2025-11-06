package kim.product_ch09_ch14.infrastructure;


import kim.product_ch09_ch14.domain.EntityNotFoundException;
import kim.product_ch09_ch14.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

//@Repository-> 이건 DB연결 없이 간단하게 CRUD개념이해용 코드 실무에서는 권장안함
//@Component
@Repository
public class ListProductRepository {

    private List<Product> productList =new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(0L);
//    0부터시작

    public  Product add(Product product){

        product.setId(sequence.incrementAndGet());
        productList.add(product);
        return  product;
    }

    public  Product findById(Long id){
        return productList.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(()->new EntityNotFoundException("Product 를 못찾겠습니다."));
    }
public   List<Product> findAll(){
        return productList;
    }
//    리스트 프로그램에 상품 이름을 포함하는 메서드 추가
    public  List<Product> findByNameContaining(String name){
        return productList.stream()
                .filter(product -> product.containName(name))
                .toList();
    }

    public Product update(Product product) {
        Integer  indexToModify = productList.indexOf(product);
        productList.set(indexToModify, product);
        return product;
    }

    public void delete(Long id) {
        Product product = findById(id);
        productList.remove(product);
    }
}
