package com.realdolmen.tickets.service;

import org.junit.BeforeClass;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by NQRAZ66 on 1/03/2016.
 */
public abstract class AbstractJndiTest {
    protected static Context context;

    @BeforeClass
    public static void setupBeforeClass() throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
        properties.put(Context.SECURITY_PRINCIPAL, "administrator");
        properties.put(Context.SECURITY_CREDENTIALS, "Azerty123!");
        context = new InitialContext(properties);
    }

    protected <T> T lookup(String jndiName) throws NamingException {
        return (T)context.lookup(jndiName);
    }
}
