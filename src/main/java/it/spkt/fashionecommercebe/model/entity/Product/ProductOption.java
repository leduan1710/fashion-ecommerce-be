package it.spkt.fashionecommercebe.model.entity.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "ProductOption")
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String name;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;

    @JsonManagedReference
    @OneToMany(mappedBy="productOption",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProductOptionDetail> productOptionDetailList;
}
