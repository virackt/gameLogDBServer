package com.zxhd.log.clientPool;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool.Config;
import org.apache.mina.common.ConnectFuture;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.LoggingFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.SocketConnector;

import com.zxhd.log.codec.LogCodecFactory;
import com.zxhd.log.codec.LogDecoder;
import com.zxhd.log.codec.LogEncoder;
import com.zxhd.log.handler.LogClientHandler;

public class ClientPoolFactory {

	private GenericObjectPool<IoSession> pool;

	public ClientPoolFactory(Config config, String ip, int port) {
		ClientFactory factory = new ClientFactory(ip, port);
		pool = new GenericObjectPool<IoSession>(factory, config);
	}

	public IoSession getSession() throws Exception {
		return pool.borrowObject();
	}

	public void releaseSession(IoSession session) {
		try {
			pool.returnObject(session);
		} catch (Exception e) {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e2) {
				}
			}
		}
	}
	
	public void reset(){
		pool.clear();
		try {
			pool.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class ClientFactory extends BasePoolableObjectFactory<IoSession> {

		private SocketAddress address;

		public ClientFactory(String ip, int port) {
			this.address = new InetSocketAddress(ip, port);
		}

		@Override
		public IoSession makeObject() throws Exception {
			SocketConnector conn = new SocketConnector();
			conn.getFilterChain().addLast("logging", new LoggingFilter());
			conn.getFilterChain().addLast(
					"codec",
					new ProtocolCodecFilter(new LogCodecFactory(
							new LogDecoder(), new LogEncoder())));
			ConnectFuture cf = conn.connect(address, new LogClientHandler());
			conn.setWorkerTimeout(3000);
			if(cf.getSession() == null){
				Thread.sleep(1000);
			}
			return cf.getSession();
		}

		@Override
		public void destroyObject(IoSession obj) throws Exception {
			if (obj != null) {
				obj.close();
			}
			System.out.println("销毁对象");
		}

		@Override
		public boolean validateObject(IoSession obj) {
			System.out.println("验证对象");  
			if (!obj.isConnected()) {
				return false;
			}
			if (obj.isClosing()) {
				return false;
			}
			return false;
		}

	}
}
