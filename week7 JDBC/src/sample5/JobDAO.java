package sample5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sample2.ConnectionUtil;
import util.QueryUtil;

public class JobDAO {
	public ArrayList<Job> getJobsBySalary(int salary) throws SQLException {
		String sql = QueryUtil.getSql("getJobsBySalary");
		ArrayList<Job> jobList = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, salary);
			pstmt.setInt(2, salary);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Job job = new Job();
				job.setId(rs.getString("job_id"));
				job.setTitle(rs.getString("job_title"));
				job.setMin(rs.getInt("min_salary"));
				job.setMax(rs.getInt("max_salary"));
				
				jobList.add(job);
			}
			
		} finally {
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (con!=null) con.close();
		}
		return jobList;
	}
	
	
}
