package com.obamaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderIncludesMenu {

    @Id
    @GeneratedValue
    private long orderMenuId;

    @Column(nullable = false)
    private int quantity;

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-dd-MM")
    private Date date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private OrderDetails orderDetails;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "menu_id")
    private MenuItems menuItems;
}
