package com.example.demo.model;

import java.util.UUID;

public class UserContext {

	private String host;
	private String origin;
	
	final private UUID uuid = UUID.randomUUID();

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		return "UserContext [host=" + host + ", origin=" + origin + ", uuid=" + uuid + "]";
	}
}
