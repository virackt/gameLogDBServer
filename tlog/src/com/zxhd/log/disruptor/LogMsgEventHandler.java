package com.zxhd.log.disruptor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.zxhd.log.dbcp.PoolManager;

public class LogMsgEventHandler implements EventHandler<LogMsgEvent> {
	Executor executorService = Executors.newSingleThreadExecutor();
	private static final Logger log = LoggerFactory.getLogger("dbUtil");

	public LogMsgEventHandler() {
	}

	@Override
	public void onEvent(LogMsgEvent event, long sequence, boolean flag)
			throws Exception {
			String sql = event.getValue();
			executorService.execute(new SqlExecutor(sql));
	}

	class SqlExecutor implements Runnable {
		private Connection conn;
		private Statement st;
		private String sql;

		public SqlExecutor(String sql) {
			this.sql = sql;
			conn = PoolManager.getConnection();
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				st.execute(sql);
			} catch (SQLException e) {
				log.error(e.getMessage() + "" + sql);
			} finally {
				try {
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}

}
