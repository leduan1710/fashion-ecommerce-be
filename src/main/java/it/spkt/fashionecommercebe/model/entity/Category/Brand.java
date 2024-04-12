package it.spkt.fashionecommercebe.model.entity.Category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.model.entity.Product.Product;
import it.spkt.fashionecommercebe.model.entity.User.Shop;
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
@Table(name = "Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String name;
    @Column(nullable = false)
    private String logo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy="brand",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> productList;
}
