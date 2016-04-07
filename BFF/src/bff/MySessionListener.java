/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpSessionEvent
 *  javax.servlet.http.HttpSessionListener
 */
package bff;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener
implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("     A session is being created");
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("     A session is being destroyed");
    }
}
