package it.spkt.fashionecommercebe.model.entity.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.spkt.fashionecommercebe.model.entity.Category.Brand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ImageProduct")
public class ImageProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String image;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;
}
