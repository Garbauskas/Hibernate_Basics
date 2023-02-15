package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSONService {
    public List<Customer> loadDataToList() throws IOException {
        String file = "src/main/resources/DataProvider";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customersFromFile = mapper.readValue(json, new TypeReference<>() {});
        return customersFromFile;


    }
    public Customer importNewCustomer () throws IOException {
        String file = "src/main/resources/importNewCustomer.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> newCustomer = mapper.readValue(json, new TypeReference<>(){});
        return newCustomer.get(0);

    }
}
