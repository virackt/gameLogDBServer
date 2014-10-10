package com.zxhd.log.codec;

import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class LogCodecFactory implements ProtocolCodecFactory {
	private ProtocolDecoder decoder;
	private ProtocolEncoder encoder;
	public LogCodecFactory(ProtocolDecoder decoder, ProtocolEncoder encoder){
		this.decoder = decoder;
		this.encoder = encoder;
	}
	

	public LogCodecFactory(LogDecoder decoder2, LogEncoder encoder2) {
		this.decoder = decoder2;
		this.encoder = encoder2;
	}


	@Override
	public ProtocolDecoder getDecoder() throws Exception {
		return this.decoder;
	}

	@Override
	public ProtocolEncoder getEncoder() throws Exception {
		return this.encoder;
	}



}
