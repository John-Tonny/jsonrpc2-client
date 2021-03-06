package com.thetransactioncompany.jsonrpc2.client;


import java.io.*;

import java.util.*;

import com.thetransactioncompany.jsonrpc2.*;

import com.thetransactioncompany.jsonrpc2.util.*;


/**
 * Test JSON-RPC 2.0 server with cookies.
 *
 * @author Vladimir Dzhuvinov
 */
public class CookieTestServer extends NanoHTTPD {
	
	
	public CookieTestServer(final int port)
		throws IOException {
		
		super(port, null);
	}
	
	
	public NanoHTTPD.Response serve(final String uri, 
			                final String method, 
			                final Properties header, 
			                final Properties parms, 
			                final Properties files) {
		
		System.out.println("Cookie test server: Cookie: " + header.get("cookie"));
		
		JSONRPC2Response json = new JSONRPC2Response("Hello world!", 0);
		
		NanoHTTPD.Response out = new NanoHTTPD.Response(HTTP_OK, "application/json", json.toString());
		
		out.addHeader("Set-Cookie", "sessionid=123");
		
		return out;
	}
}
