package Audintel.dao;


import jakarta.persistence.*;

@Entity
public class Store {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Column(name = "store_name", length = 40)
    private String storeName;


}
