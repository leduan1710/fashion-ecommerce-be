package it.spkt.fashionecommercebe.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.spkt.fashionecommercebe.model.entity.product.Product;
import it.spkt.fashionecommercebe.model.entity.product.ProductDetail;
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
@Check(constraints = "percent >= 0")
@Check(constraints = "decrease_discount >= 0")
@Table(name = "Discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String name;
    @Column(nullable = true)
    private Double percent;
    @Column(nullable = true)
    private long decreaseDiscount;
    @Column(nullable = false)
    private Date updateDate;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date expiry;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productDetailId",nullable = false)
    private ProductDetail productDetail;
}
