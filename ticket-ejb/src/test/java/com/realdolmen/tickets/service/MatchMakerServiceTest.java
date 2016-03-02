package com.realdolmen.tickets.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;

import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class MatchMakerServiceTest extends AbstractJndiTest {
    private MatchMakerRemote matchMakerService;

    @Before
    public void init() throws NamingException {
        matchMakerService = lookup("ticket-ear-1.0/ticket-ejb/MatchMakerService!com.realdolmen.tickets.service.MatchMakerRemote");
    }

    @Test
    public void matchMakerReturns98PercentForJohnAndLisa() throws Exception {
        assertEquals(98, matchMakerService.match("John", "Lisa"));
        System.out.println("Call complete");
    }

    @Test
    public void matchMakerReturns98PercentForJohnAndLisaAsynchronously() throws Exception {
        Future<Integer> future = matchMakerService.matchAsync("John", "Lisa");
        System.out.println("Call complete");
        assertEquals(new Integer(98), future.get());


//        assertEquals(98, future);

    }
}
