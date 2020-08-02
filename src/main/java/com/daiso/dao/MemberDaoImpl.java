package com.daiso.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.daiso.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public MemberVO getUserByUserid(String username) {
		String sql = "SELECT * FROM membertable WHERE m_userid = ?";
		return this.jdbcTemplate.queryForObject(sql, new String[] { username }, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO member = new MemberVO();
				member.setM_userid(rs.getString("m_userid"));
				member.setM_password(rs.getString("m_password"));
				member.setM_nickname(rs.getString("m_nickname"));
				member.setM_email(rs.getString("m_email"));
				member.setM_role(rs.getString("m_role"));

				return member; 
			}
		});
	}

	@Override
	public int create(MemberVO member) {
		String sql = "INSERT INTO membertable(m_userid,m_password, m_nickname,m_email, m_role) VALUES(?,?,?,?,?)";
		return this.jdbcTemplate.update(sql, member.getM_userid(), member.getM_password(), member.getM_nickname(),
				member.getM_email(), "ROLE_USER");
	}

//	@Override
//	public MemberVO select(String userid) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
