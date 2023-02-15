package hibernate.Sunday_teamwork.service;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import hibernate.Sunday_teamwork.entity.Person;
import hibernate.Sunday_teamwork.entity.Phone;

public class Json {
        public static void toJSON(List<Phone> phones, String person) {
            Gson gson = new Gson();
            String json = gson.toJson(phones);
            try (FileWriter writer = new FileWriter(person)) {
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
