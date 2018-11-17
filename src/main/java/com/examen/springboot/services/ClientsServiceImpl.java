package com.examen.springboot.services;

import com.examen.springboot.domain.Clients;
import com.examen.springboot.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;

import java.io.IOException;

@Service
public class ClientsServiceImpl implements ClientsService{

    private ClientsRepository clientsRepository;
    final String CLIENTS_URL = "http://www.mocky.io/v2/5808862710000087232b75ac";

    @Autowired
    public void setClientsRepository(ClientsRepository clientsRepository){
        this.clientsRepository = clientsRepository;
    }

    @Override
    public Clients saveClient(Clients client) {
        return clientsRepository.save(client);
    }


    public Clients convertJsonToObject(String jsonString, Class<Clients> clients) {
        ObjectMapper mapper = new ObjectMapper();

        Clients convertedClients = null;
        try {
            convertedClients = mapper.readValue(jsonString, Clients.class);
            // System.out.println("convertedCustomer info: " + convertedClients.toString());
            return convertedClients;
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return convertedClients;
    }


    public ResponseEntity<String> getClientsData(){
        RestTemplate restTemplate = new RestTemplate();
        String clientsUrl
                = CLIENTS_URL;
        ResponseEntity<String> response
                = restTemplate.getForEntity(clientsUrl + "/1", String.class);
        return response;
    }


}
