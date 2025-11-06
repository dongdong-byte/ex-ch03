package kim.product_ch09_ch14.domain;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
//@Entity
public class Product {



//@Id
//기본 prmary key 지정

//@GeneratedValue(strategy = GenerationType.IDENTITY)
//ID 자동생성방식을 Db에 위임
    private Long id;
    @Size(min = 1, max = 100)
    private String name;

    @Max(1000000)
    @Min(0)
    private Integer price;

    @Max(9999)
    @Min(0)
    private Integer amount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public void setId(Long id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }


    public boolean sameId(Long id) {
        return  this.id.equals(id);
    }
//    상품이름이 포함되어있는지
    public boolean containName(String name){
        return   this.name.contains(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
