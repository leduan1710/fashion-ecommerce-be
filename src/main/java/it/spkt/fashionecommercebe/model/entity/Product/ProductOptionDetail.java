package it.spkt.fashionecommercebe.model.entity.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductOptionDetail")
public class ProductOptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition ="nvarchar(100)")
    private String name;
    @Column(nullable = false)
    private String image;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productOptionId",nullable = false)
    private ProductOption productOption;

    @ManyToMany(mappedBy = "productOptionDetailList", fetch = FetchType.LAZY)
    private List<ProductDetail> productDetailList;
}
