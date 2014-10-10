package com.zxhd.log.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool.impl.GenericObjectPool.Config;
import org.apache.mina.common.IoSession;

import com.renren.test.DBClientCacheManagerFactory;
import com.zxhd.log.clientPool.ClientPoolFactory;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.util.AppConfig;
import com.zxhd.log.util.Globals;

public class LogClientUtil {

	private static LogClientUtil instance;
	private ClientPoolFactory poolFactory;
	private ThreadLocal<List<ILogCodec>> logTl = new ThreadLocal<List<ILogCodec>>();
	public static final String confFileName = "../conf.properties";
	private static int logSwitch = 0;

	public static LogClientUtil getInstance() {
		if (instance == null) {
			instance = new LogClientUtil();
		}
		return instance;
	}

	private LogClientUtil() {
		
		AppConfig.init(Globals.getConfigPathUrl(confFileName));
		logSwitch = AppConfig.getIntValue("logSwitch");
		if(logSwitch == 1){
			Config config = new Config();
			config.maxActive = AppConfig.getIntValue("maxActive");
			config.maxIdle = AppConfig.getIntValue("maxIdle");
			poolFactory = new ClientPoolFactory(config, AppConfig.getString("ip"), AppConfig.getIntValue("port"));
		} else if(logSwitch == 2){
			
		} else {
			System.out.println("---------------tlog日志开关是关闭的");
		}
	}
	
	public void addLogInfo(ILogCodec msg){
		if(logSwitch != 0){
			getLogList().add(msg);
		}
	}
	
	public List<ILogCodec> getLogList(){
		List<ILogCodec> logList = logTl.get();
		if(logList == null){
			logList = new ArrayList<ILogCodec>();
			logTl.set(logList);
		}
		return logList;
	}

	public void sendLogInfo() {
		if(logSwitch != 1){
			return;
		}
		IoSession session = null;
		try {
			session = poolFactory.getSession();
			if(!session.isConnected()){
				poolFactory.reset();
				poolFactory = null;
				reConnect();
				session = poolFactory.getSession();
			}
			List<ILogCodec> logList = getLogList();
			for(ILogCodec msg : logList){
				session.write(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null){
				poolFactory.releaseSession(session);
			}
			clear();
		}
	}
	
	public void sendLogInfoToDBServer(){
		if(logSwitch != 2){
			return;
		}
		try {
			List<ILogCodec> logList = getLogList();
			for(ILogCodec msg : logList){
				DBClientCacheManagerFactory.getMemCacheManager().add(msg.getType(),msg.getUpdateSql());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clear();
		}
	}
	
	public void clear(){
		getLogList().clear();
	}
	
	private void reConnect(){
		AppConfig.init(confFileName);
		Config config = new Config();
		config.maxActive = AppConfig.getIntValue("maxActive");
		config.maxIdle = AppConfig.getIntValue("maxIdle");
		poolFactory = new ClientPoolFactory(config, AppConfig.getString("ip"), AppConfig.getIntValue("port"));
	}

}
