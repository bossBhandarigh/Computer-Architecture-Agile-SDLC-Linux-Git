package com.wipro;
import java.sql.*;
public class JdbcDemmo {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		
		//step1  create driver
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		//step2 
		//url,id,pwd
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE","system","rps@123");
		
		System.out.println("connection is success");
		
		
		Statement st = con.createStatement();
//		st.executeUpdate("create table prodsell(id number primary key, name varchar(20), cost number)");
//		st.executeUpdate("insert into prodsell values(101, 'Dog', 2000)");
//		st.executeUpdate("insert into prodsell values(102, 'Cat', 1000)");
//		st.executeUpdate("insert into prodsell values(103, 'Fish', 3000)");
		
		System.out.println("table created and inserted");
		
		st.executeUpdate("delete from prodsell where id=102");
		
		ResultSet rs = st.executeQuery("select * from prodsell");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
		}
		
//		st.executeUpdate("update prodsell set cost=5000 where id=103");
	}

}