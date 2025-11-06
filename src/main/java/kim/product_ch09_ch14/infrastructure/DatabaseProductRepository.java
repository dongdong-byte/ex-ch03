package kim.product_ch09_ch14.infrastructure;

import kim.product_ch09_ch14.domain.EntityNotFoundException;
import kim.product_ch09_ch14.domain.Product;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DatabaseProductRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    public DatabaseProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Product add(Product product){
//        이해 보다는 나중에 복붙, 라이브러리로 작성해야한다
//KeyHolder 가 있어야지 값을 받아올수 있다.
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(product);
        namedParameterJdbcTemplate.update("INSERT INTO product (name,price,amount) VALUES (:name, :price, :amount)",
                namedParameter,keyHolder);
        Long generatedId = keyHolder.getKey().longValue();
        product.setId(generatedId);
        return product;
    }

    public Product findById(Long id){
        SqlParameterSource namedParameter = new MapSqlParameterSource("id",id);
        List<Product> products = namedParameterJdbcTemplate.query("SELECT * FROM product WHERE id = :id",
                namedParameter,
                new BeanPropertyRowMapper<>(Product.class));
        
        if (products.isEmpty()) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
        
        return products.get(0);
    }
    
    public List<Product> findAll(){
        List<Product> products =namedParameterJdbcTemplate.query(
                "SELECT * FROM product", new BeanPropertyRowMapper<>(Product.class));

        return products;
    }
    
    public List<Product> findByNameContaining(String name){

        SqlParameterSource namedParameter = new MapSqlParameterSource("name", "%" + name + "%");
        List<Product> products = namedParameterJdbcTemplate.query(
                "SELECT * FROM product WHERE name LIKE :name",
                namedParameter,
                new BeanPropertyRowMapper<>(Product.class));

        return products;
    }

    public Product update(Product product) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(product);
        namedParameterJdbcTemplate.update(
                "UPDATE product SET name = :name , price = :price ,amount = :amount WHERE id = :id",
                namedParameter);

        return product;

    }

    public void delete(Long id) {
        SqlParameterSource namedParameter = new MapSqlParameterSource("id",id);
        namedParameterJdbcTemplate.update(
                "delete from product WHERE id = :id",
                namedParameter);



    }
}