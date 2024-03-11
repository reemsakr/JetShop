package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Controllers.Listeners.EntityFactoryListener;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.persistence.EntityManager;

public class CustomerRepo extends GenericRepo<Customer,Integer>{
    EntityManager entityManager;
    public CustomerRepo( EntityManager entityManager) {
        super(Customer.class , entityManager);
        this.entityManager = entityManager;
    }

//    private final static EntityManager entityManager;
//    private static final ThreadLocal<EntityManager> entityManagerInstance = new ThreadLocal<>();
//
//    static {
//        entityManager = EntityFactoryListener.getInstance().createEntityManager();
//        entityManagerInstance.set(entityManager);
//
//    }



//    private static volatile CustomerRepo instance = null;
//    private CustomerRepo() {
//        super(Customer.class,entityManagerInstance.get());
//        if (instance != null)
//            throw new RuntimeException("Use getInstance(), reflection is not allowed");
//    }
//
//    public static CustomerRepo getInstance() {
//        if (instance == null) {
//            synchronized (CustomerRepo.class) {
//                if (instance == null) {
//                    instance = new CustomerRepo();
//                }
//            }
//        }
//        return instance;
//    }
}
