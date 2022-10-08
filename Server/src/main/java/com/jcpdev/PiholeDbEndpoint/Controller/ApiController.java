package com.jcpdev.PiholeDbEndpoint.Controller;


import com.jcpdev.PiholeDbEndpoint.Models.Repos.queriesRepo;
import com.jcpdev.PiholeDbEndpoint.Models.queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class ApiController {

    final int BLOCKED = 1;
    @Autowired
    private queriesRepo queriesRepo;


    @GetMapping(value = "/allevents")
    public List<queries> getAllEvents() {
        return queriesRepo.findAll();
    }

    @GetMapping(value = "/blockedevents")
    public List<queries> getBlockedEvents() {
        List<queries> blockedEventList = new ArrayList<>();

        for (queries Event : queriesRepo.findAll()) {
            if (Event.getStatus() == BLOCKED) {
                blockedEventList.add(Event);
            }
        }
        return blockedEventList;
    }

    @GetMapping(value = "/permittedevents")
    public List<queries> getPermittedEvents() {
        List<queries> permittedEventList = new ArrayList<>();

        for (queries Event : queriesRepo.findAll()) {
            if (Event.getStatus() != BLOCKED) {

                permittedEventList.add(Event);
            }
        }
        return permittedEventList;
    }

    @GetMapping(value = "/clients")
    public List getClients() {
        HashSet<String> clients = new HashSet<>();
        for (queries Event : queriesRepo.findAll()) {
            clients.add(Event.getClient());
        }
        return Arrays.asList(clients.toArray());
    }

    @GetMapping(value = "/clients/{client}")
    public List<queries> eventsByClient(@PathVariable String client) {
        List<queries> eventsByClientList = new ArrayList<>();

        for (queries Event : queriesRepo.findAll()) {
            if ((Event.getClient().equalsIgnoreCase(client))) {
                eventsByClientList.add(Event);
            }
        }

        return eventsByClientList;
    }

    @GetMapping(value = "/clients/{client}/blocked")
    public List<queries> blockedByClient(@PathVariable String client) {
        List<queries> blockedByClientList = new ArrayList<>();

        for (queries Event : queriesRepo.findAll()) {
            if ((Event.getClient().equalsIgnoreCase(client) && Event.getStatus() == BLOCKED)) {

                blockedByClientList.add(Event);
            }
        }
        return blockedByClientList;
    }

    @GetMapping(value = "/clients/{client}/permitted")
    public List<queries> permittedByClient(@PathVariable String client) {
        List<queries> permittedByClientList = new ArrayList<>();

        for (queries Event : queriesRepo.findAll()) {
            if ((Event.getClient().equalsIgnoreCase(client) && Event.getStatus() != BLOCKED)) {

                permittedByClientList.add(Event);
            }
        }
        return permittedByClientList;
    }
}
