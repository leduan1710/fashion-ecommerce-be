package it.spkt.fashionecommercebe.model.entity.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.spkt.fashionecommercebe.model.entity.Product.Product;
import it.spkt.fashionecommercebe.model.entity.Product.ProductDetail;
import it.spkt.fashionecommercebe.model.entity.User.Shop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Check(constraints = "price > 0")
@Check(constraints = "price_ship >= 0")
@Check(constraints = "decrease >= 0")
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private long price;
    @Column(nullable = false)
    private long priceShip;
    @Column(nullable = true)
    private long decrease;
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
