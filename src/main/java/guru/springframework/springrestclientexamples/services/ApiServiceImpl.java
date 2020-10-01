package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUser(Integer limit) {

        //.getForObject("URL", class) is used to get the JSON/XML from a GET
        // and convert the JSON to object based on the given class (Jackson is doing the binding between JSON and POJO)
        // NB! class and attributes must be the same as the JSON
        UserData userData = restTemplate.getForObject("https://private-anon-1ae822db5f-apifaketory.apiary-mockcom/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }
}
