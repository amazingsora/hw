package com.demo.common.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.common.util.JdbcUtil;

public class BaseDao {

	public void executeSql(String sql, Object... objs) {

		PreparedStatement ps = null;
		try {
			ps = JdbcUtil.getConnection().prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]);
			}
			ps.execute();
			System.out.println("SQL ::" + sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Map<String, Object>> executeSql_List(String sql, List<String> parms) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = JdbcUtil.getConnection().prepareStatement(sql);
			for (int i = 0; i < parms.size(); i++) {
				pstmt.setObject(i + 1, parms.get(i));
			}
			System.out.println("SQL ::" + sql);

			pstmt.execute();
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			Map<String, Object> map = null;
			while (rs.next()) {
				map = new HashMap<String, Object>();
				for (int i = 1; i <= count; i++) {
					map.put(rsmd.getColumnName(i).toLowerCase(), String.valueOf(rs.getObject(i)).trim());
				}
				list.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

}
