<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String url_mysql = "jdbc:mysql://localhost/address?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
 	String id_mysql = "root";
 	String pw_mysql = "kyeongmi7";
    String WhereDefault = "select peopleno, peoplename, (SELECT JSON_ARRAYAGG(phonetel) FROM phone group by people_peopleno having people_peopleno = peopleno) peoplephone, ";
    String WhereDefault1 = "peopleemail, peoplerelation, peoplememo, peopleimage from people peo, phone ph where peo.peopleno = ph.people_peopleno group by peopleno";
    int count = 0;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        Statement stmt_mysql = conn_mysql.createStatement();

        ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault1); // 
%>
		{ 
  			"people_info"  : [ 
<%
        while (rs.next()) {
            if (count == 0) {

            }else{
%>
            , 
<%
            }
%>            
			{
			"no" : "<%=rs.getString(1) %>", 
			"name" : "<%=rs.getString(2) %>",   
			"tel" : <%=rs.getString(3) %>,  
            "email" : "<%=rs.getString(4) %>"
            "relation" : "<%=rs.getString(5) %>"
            "memo" : "<%=rs.getString(6) %>"
            "image" : "<%=rs.getString(7) %>"
			}

<%		
        count++;
        }
%>
		  ] 
		} 
<%		
        conn_mysql.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
	
%>
