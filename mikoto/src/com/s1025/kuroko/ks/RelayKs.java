package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Relay;
import com.s1025.kuroko.model.Result;

public interface RelayKs {
	public Result<Relay> addRelay(Relay relay);
	public Result<Relay> delRelay(String name);
	public Result<Relay> getRelay();
}
