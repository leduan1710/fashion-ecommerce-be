package it.spkt.fashionecommercebe.model.entity.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.model.entity.product.Product;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JoinColumn(name = "categoryId")
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy="brand",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> productList;
}
