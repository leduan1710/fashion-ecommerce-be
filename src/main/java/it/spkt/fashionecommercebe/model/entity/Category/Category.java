package it.spkt.fashionecommercebe.model.entity.Category;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.model.entity.Product.Product;
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
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String name;
    @Column(nullable = false)
    private String image;
    @Column(nullable = true)
    private int Previous;

    @JsonManagedReference
    @OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Brand> brandList;

    @JsonManagedReference
    @OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Material> materialList;

    @JsonManagedReference
    @OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Style> styleList;

    @JsonManagedReference
    @OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> productList;
}
