package com.zxhd.log.dbcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBUtil {
	private static final Logger log = LoggerFactory.getLogger("dbUtil");

	public static void insertData(String[] sql) {
		Connection conn = PoolManager.getConnection();
		try {
			Statement st = conn.createStatement();
			for(int i = 0; i < sql.length; i++){
				st.addBatch(sql[i]);
			}
			st.executeBatch();
//			PreparedStatement pst = conn.prepareStatement(sql[0]);
//			pst.execute();
//			pst.close();
		} catch (SQLException e) {
			log.error("执行失败sql:\t" + sql);
			log.error(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
			}
		}

	}

	public static void createTables(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					fileName)));
			String sql = null;
			List<String> sqlList = new ArrayList<String>();
			while ((sql = br.readLine()) != null) {
				sqlList.add(sql);
			}
			insertData(sqlList.toArray(new String[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
