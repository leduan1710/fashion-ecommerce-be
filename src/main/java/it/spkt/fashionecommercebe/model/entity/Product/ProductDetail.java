package it.spkt.fashionecommercebe.model.entity.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.model.entity.Order.OrderDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Check(constraints = "quantity > 0")
@Check(constraints = "number_sold >= 0")
@Check(constraints = "price > 0")
@Table(name = "ProductDetail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int numberSold;
    @Column(nullable = false)
    private long price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "id_product_detail"),
            inverseJoinColumns = @JoinColumn(name = "id_product_option_detail"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_product_detail", "id_product_option_detail"}))
    private List<ProductOptionDetail> productOptionDetailList;

    @JsonManagedReference
    @OneToMany(mappedBy="productDetail",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
