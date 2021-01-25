package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBoImpl;
import lk.ijse.pos.bo.custom.impl.ItemBOImpl;

public class BoFactory {
   
    private static BoFactory boFactory;

    
    private BoFactory() {
    }

    
    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);
    }

    
    public enum BOType {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL
    }

    
    public <T extends SuperBo> T getBo(BOType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            default:
                return null;
        }
    }

}
