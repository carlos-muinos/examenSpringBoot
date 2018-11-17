package com.examen.springboot.restcontrollers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import java.io.File;

import org.springframework.http.ResponseEntity;

import com.examen.springboot.services.ClientsServiceImpl;
import com.examen.springboot.domain.Clients;

@RestController
@RequestMapping("/insurance")
public class InsuranceRestController {

    private ClientsServiceImpl clientsService;

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @Autowired
    public void setClientsService(ClientsServiceImpl clientsService){
        this.clientsService = clientsService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getUrlData() {
        ResponseEntity<String> clientsResponse = clientsService.getClientsData();
        String jsonClientsList = clientsResponse.getBody();
        Clients clients = (Clients) clientsService.convertJsonToObject(jsonClientsList, Clients.class);




        /*
        ResponseEntity<String> clientsResponse = clientsService.getClientsData();
        String clientsList = clientsResponse.getBody();
        ArrayList<Clients> clients = JSON_MAPPER.readValue(new File(clientsList),
                JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Clients.class));
        for (Clients object: clients) {
            System.out.println(object);
        }
        */
        /*
        ResponseEntity<String> clientsResponse = clientsService.getClientsData();
        String clientsList = clientsResponse.getBody();
        JSONObject jsonClientsList = new JSONObject(clientsList);
        JSONArray values = jsonClientsList.getJSONArray("clients");

        for (int i = 0; i < values.length(); i++) {
            JSONObject client = values.getJSONObject(i);

           // Clients client = modelMapper.map(client, Clients.class);

            System.out.println(client);
            this.saveClient(client);
        }
        */
    }


    public void saveClient(Clients client){
        clientsService.saveClient(client);
    }


}
