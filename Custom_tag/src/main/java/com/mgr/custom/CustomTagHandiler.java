package com.mgr.custom;

import java.io.IOException;
import java.sql.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTagHandiler extends TagSupport{
	
	 private String table;
	    private String displayColumn;
	    private String valueColumn;
	    private Connection dataSource;

	    public void setTable(String table) {
	        this.table = table;
	    }

	    public void setDisplayColumn(String displayColumn) {
	        this.displayColumn = displayColumn;
	    }

	    public void setValueColumn(String valueColumn) {
	        this.valueColumn = valueColumn;
	    }

	    public void setDataSource(Connection dataSource) {
	        this.dataSource = dataSource;
	    }

	    public int doStartTag() throws JspException {
	    	try {
	            // Establish a database connection using the data source
	            Connection connection = dataSource;

	            // Create a SQL statement and execute it to retrieve data from the specified table
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT " + displayColumn + ", " + valueColumn + " FROM " + table);

	            // Process and display the data as needed
	            JspWriter out = pageContext.getOut();
	            while (resultSet.next()) {
	                String displayValue = resultSet.getString(displayColumn);
	                String columnValue = resultSet.getString(valueColumn);

	                // Output the data to the JSP response
	                out.write("Display: " + displayValue + ", Value: " + columnValue + "<br>");
	            }

	            // Close database resources
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            // Handle any database-related exceptions
	            throw new JspException("Error executing SQL query", e);
	        } catch (IOException e) {
	            // Handle any IO exceptions
	            throw new JspException("Error writing to JSP response", e);
	        }

	        return SKIP_BODY; // Skip the body of the custom tag
	    }

	
}

