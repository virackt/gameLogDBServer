package com.zxhd.log.server;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.common.IoAcceptor;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.SocketAcceptor;

import com.zxhd.log.codec.LogCodecFactory;
import com.zxhd.log.codec.LogDecoder;
import com.zxhd.log.codec.LogEncoder;
import com.zxhd.log.core.LogMessageTypeConst;
import com.zxhd.log.dbcp.DBUtil;
import com.zxhd.log.dbcp.PoolManager;
import com.zxhd.log.handler.LogServerHandler;
import com.zxhd.log.util.AppConfig;
import com.zxhd.log.util.PropertyConfig;



public class LogServer {
	private static final String FILE_NAME = "./conf/conf.properties";
	private static final String mapConfigFileName = "./conf/mapConf.ini";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AppConfig.init(FILE_NAME);
		PoolManager.initConf();
		PropertyConfig.init(mapConfigFileName);
		LogMessageTypeConst.init(PropertyConfig.getStringArray("plugin"));
		DBUtil.createTables(AppConfig.getString("createSqlPath"));
		SocketAcceptor acceptor = new SocketAcceptor();
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new LogCodecFactory(new LogDecoder(), new LogEncoder())));
		try {
			String ip = AppConfig.getString("ip");
			int port = AppConfig.getIntValue("port");
			acceptor.bind(new InetSocketAddress(ip, port), new LogServerHandler());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		log.info("server start");
	}
	
	public void init(){
		AppConfig.init(FILE_NAME);
		PoolManager.initConf();
		PropertyConfig.init(mapConfigFileName);
		LogMessageTypeConst.init(PropertyConfig.getStringArray("plugin"));
		DBUtil.createTables(AppConfig.getString("createSqlPath"));
		IoAcceptor acceptor = new SocketAcceptor();
		acceptor.getFilterChain().addLast("logging", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new LogCodecFactory(new LogDecoder(), new LogEncoder())));
		try {
			acceptor.bind(new InetSocketAddress(AppConfig.getString("ip"), AppConfig.getIntValue("port")), new LogServerHandler());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("!!!server started!!!");
	}

}
