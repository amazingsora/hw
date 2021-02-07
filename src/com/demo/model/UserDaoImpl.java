package com.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.demo.common.dao.BaseDao;
import com.demo.common.util.JdbcUtil;

public class UserDaoImpl extends BaseDao implements UserDao {
	Connection con = JdbcUtil.getConnection();

	@Override
	public void Demofind() {
		String sql = "SELECT * FROM EMPYEE ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i < count; i++) {

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}

	@Override
	public UserVO LoginUser(UserVO userVo) {
		UserVO findVo = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer bf = new StringBuffer("SELECT * FROM EMPYEE where account =? and password =? ");
			pstmt = con.prepareStatement(bf.toString());
			pstmt.setObject(1, userVo.getAccount());
			pstmt.setObject(2, userVo.getPassword());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				findVo = new UserVO();

				findVo.setAccount(rs.getString(1));
				findVo.setPassword(rs.getString(2));
				findVo.setStatus(rs.getString(3));
				findVo.setUsername(rs.getString(4));
				findVo.setNote(rs.getString(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return findVo;
	}

	@Override
	public List<Map<String, Object>> findUserList(UserVO userVo) {
		List<String> parms = new LinkedList<String>();
		StringBuffer bf = new StringBuffer("SELECT * FROM EMPYEE where 1=1 and status= 'Y' ");
		if (StringUtils.isNotBlank(userVo.getAccount())) {
			bf.append("and account =? ");
			parms.add(userVo.getAccount());

		}
		if (StringUtils.isNotBlank(userVo.getUsername())) {
			bf.append("and username =? ");
			parms.add(userVo.getUsername());
		}
		return executeSql_List(bf.toString(), parms);
	}

	@Override
	public void changeStatus(String account, String status) {
		String sql = "UPDATE EMPYEE SET status = ? WHERE account = ?";
		executeSql(sql, status, account);
	}

	@Override
	public void insert(UserVO userVO) {
		String sql = "INSERT INTO EMPYEE  (account, password, status, username, note)  " + "VALUES (?, ?, ?, ?, ?)";
		executeSql(sql, userVO.getAccount(), userVO.getPassword(), userVO.getStatus(), userVO.getUsername(),
				userVO.getNote());
	}

	@Override
	public void update(String account, String username) {
		String sql = "UPDATE EMPYEE SET username = ? WHERE account = ?";
		executeSql(sql, username, account);
	}

	@Override
	public List<Map<String, Object>> findUserList(UserVO userVo, String status) {
		List<String> parms = new LinkedList<String>();
		StringBuffer bf = new StringBuffer("SELECT * FROM EMPYEE where 1=1 ");
		if (StringUtils.isNotBlank(status)) {
			bf.append("and status= '" + status + "' ");

		}
		if (StringUtils.isNotBlank(userVo.getAccount())) {
			bf.append("and account =? ");
			parms.add(userVo.getAccount());

		}
		if (StringUtils.isNotBlank(userVo.getUsername())) {
			bf.append("and username =? ");
			parms.add(userVo.getUsername());
		}
		return executeSql_List(bf.toString(), parms);
	}

}
