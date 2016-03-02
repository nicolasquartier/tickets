package com.realdolmen.tickets.service;

import javax.ejb.Remote;
import java.util.concurrent.Future;

@Remote
public interface MatchMakerRemote {
    /**
     * Match a person with another person synchronously
     */
    int match(String a, String b);

    /**
     * * Match a person with another person asynchronously
     */
    Future<Integer> matchAsync(String a, String b);
}
