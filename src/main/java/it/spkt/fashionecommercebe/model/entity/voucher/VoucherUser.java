package it.spkt.fashionecommercebe.model.entity.voucher;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.spkt.fashionecommercebe.model.entity.product.Product;
import it.spkt.fashionecommercebe.model.entity.user.Shop;
import it.spkt.fashionecommercebe.model.entity.user.User;
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
@Table(name = "VoucherUser",uniqueConstraints = @UniqueConstraint(columnNames = {"voucher_id", "user_id"}))
public class VoucherUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private boolean status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "voucherId")
    private Voucher voucher;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
