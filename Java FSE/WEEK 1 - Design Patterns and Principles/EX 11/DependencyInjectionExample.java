interface CustomerRepository {
    Customer findCustomerById(int id);
}
class Customer {
    private int id;
    private String name;
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Customer [ID=" + id + ", Name=" + name + "]";
    }
}
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        if (id == 1) {
            return new Customer(1, "Swetha");
        } else if (id == 2) {
            return new Customer(2, "Abitha");
        } else {
            return null;
        }
    }
}
class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.getCustomerById(1);
        System.out.println("Found customer: " + customer);

        customer = customerService.getCustomerById(2);
        System.out.println("Found customer: " + customer);
    }
}
