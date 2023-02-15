package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Address;
import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Project;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DataMapperService {

    public List<Customer> mapsJsonList(@NotNull List<Customer> customers) {
        List<Customer> newList = new ArrayList<>();

        for (Customer customer : customers) {
            for (Project project : customer.getProjects()) {
                project.setCustomer(customer);
                for (Address address : project.getAddresses()) {
                    address.setProject(project);
                }

            }
            newList.add(customer);

        }
        return newList;
    }
}

