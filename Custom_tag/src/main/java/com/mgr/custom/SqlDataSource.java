package com.mgr.custom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SqlDataSource extends TagSupport {

	private String driver;

	private String url;
	private String username;
	private String password;
	private String var;

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int doStartTag() throws JspException {
		try {
			// Establish a database connection using the data source
			Class.forName(driver);
			// Establish a database connection
			Connection connection = DriverManager.getConnection(url, username, password);
			pageContext.setAttribute(var, connection);

		} catch (SQLException e) {
			// Handle any database-related exceptions
			throw new JspException("Error executing SQL query", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SKIP_BODY; // Skip the body of the custom tag
	}

}
