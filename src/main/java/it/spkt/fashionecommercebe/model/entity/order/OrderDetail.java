package it.spkt.fashionecommercebe.model.entity.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.spkt.fashionecommercebe.model.entity.product.ProductDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Check(constraints = "price_decrease >= 0")
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = true)
    private long priceDecrease;
    @Column(nullable = false)
    private int quantity;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ordersId",nullable = false)
    private Orders orders;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productDetailId",nullable = false)
    private ProductDetail productDetail;

}
