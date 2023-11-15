package com.ecommerce.services.WishList.Modals;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "favourite_collection")
public class FavouriteModal {

    @Id
    private String favourite_id;
    private String user_id;
    private List<String> favouriteProductList;

}
