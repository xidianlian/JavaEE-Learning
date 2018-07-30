package com.webrelax.waper;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**   
 * @ClassName:  MyConnectionWarper   
 * @TODO(适配器模式)   
 * @author: xidian_lian 
 * @date:   2018年7月30日 下午3:35:23       
 */
//1、编写一个类，实现与被包装类相同的接口。（具备相同的行为）
//2、定义一个被包装类类型的变量。
//3、定义构造方法，把被包装类的对象注入，给被包装类变量赋值。
//4、对于不需要改写的方法，调用原有的方法。
//说白了，就是把Connection(接口)复制下来,
//然后，MyConnection再继承这个适配器，使得MyConnection代码简洁
//适配器的好处，其他类需要重写Connection中的方法，只需先继承适配器就行了，使得代码复用
public class MyConnectionWarper implements Connection{
	private Connection oldConnection;
	public MyConnectionWarper(Connection oldConnection) {
		this.oldConnection=oldConnection;
	}
	/** 
	 * @throws SQLException
	 * @see java.sql.Connection#close()
	 **/
	@Override
	public void close() throws SQLException {
		
		
	}
	/** 
	 * @param iface
	 * @return
	 * @throws SQLException
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 **/
	    
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.unwrap(iface);
	}
	
	/** 
	 * @param iface
	 * @return
	 * @throws SQLException
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 **/
	    
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.isWrapperFor(iface);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createStatement()
	 **/
	    
	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createStatement();
	}
	
	/** 
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareStatement(java.lang.String)
	 **/
	    
	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareStatement(sql);
	}
	
	/** 
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareCall(java.lang.String)
	 **/
	    
	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareCall(sql);
	}
	
	/** 
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#nativeSQL(java.lang.String)
	 **/
	    
	@Override
	public String nativeSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.nativeSQL(sql);
	}
	
	/** 
	 * @param autoCommit
	 * @throws SQLException
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 **/
	    
	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.setAutoCommit(autoCommit);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getAutoCommit()
	 **/
	    
	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getAutoCommit();
	}
	
	/** 
	 * @throws SQLException
	 * @see java.sql.Connection#commit()
	 **/
	    
	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.commit();
	}
	
	/** 
	 * @throws SQLException
	 * @see java.sql.Connection#rollback()
	 **/
	    
	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.rollback();
	}
	
	
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#isClosed()
	 **/
	    
	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.isClosed();
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getMetaData()
	 **/
	    
	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getMetaData();
	}
	
	/** 
	 * @param readOnly
	 * @throws SQLException
	 * @see java.sql.Connection#setReadOnly(boolean)
	 **/
	    
	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.setReadOnly(readOnly);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#isReadOnly()
	 **/
	    
	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.isReadOnly();
	}
	
	/** 
	 * @param catalog
	 * @throws SQLException
	 * @see java.sql.Connection#setCatalog(java.lang.String)
	 **/
	    
	@Override
	public void setCatalog(String catalog) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.setCatalog(catalog);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getCatalog()
	 **/
	    
	@Override
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getCatalog();
	}
	
	/** 
	 * @param level
	 * @throws SQLException
	 * @see java.sql.Connection#setTransactionIsolation(int)
	 **/
	    
	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.setTransactionIsolation(level);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getTransactionIsolation()
	 **/
	    
	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getTransactionIsolation();
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getWarnings()
	 **/
	    
	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getWarnings();
	}
	
	/** 
	 * @throws SQLException
	 * @see java.sql.Connection#clearWarnings()
	 **/
	    
	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.clearWarnings();
	}
	
	/** 
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createStatement(int, int)
	 **/
	    
	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createStatement(resultSetType, resultSetConcurrency);
	}
	
	/** 
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
	 **/
	    
	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}
	
	/** 
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
	 **/
	    
	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareCall(sql, resultSetType, resultSetConcurrency);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getTypeMap()
	 **/
	    
	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getTypeMap();
	}
	
	/** 
	 * @param map
	 * @throws SQLException
	 * @see java.sql.Connection#setTypeMap(java.util.Map)
	 **/
	    
	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.setTypeMap(map);
	}
	
	/** 
	 * @param holdability
	 * @throws SQLException
	 * @see java.sql.Connection#setHoldability(int)
	 **/
	    
	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.setHoldability(holdability);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getHoldability()
	 **/
	    
	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getHoldability();
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#setSavepoint()
	 **/
	    
	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.setSavepoint();
	}
	
	/** 
	 * @param name
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#setSavepoint(java.lang.String)
	 **/
	    
	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.setSavepoint(name);
	}
	
	/** 
	 * @param savepoint
	 * @throws SQLException
	 * @see java.sql.Connection#rollback(java.sql.Savepoint)
	 **/
	    
	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.rollback(savepoint);
	}
	
	/** 
	 * @param savepoint
	 * @throws SQLException
	 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
	 **/
	    
	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.releaseSavepoint(savepoint);
	}
	
	/** 
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @param resultSetHoldability
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createStatement(int, int, int)
	 **/
	    
	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
	}
	
	/** 
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @param resultSetHoldability
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
	 **/
	    
	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}
	
	/** 
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @param resultSetHoldability
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
	 **/
	    
	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}
	
	/** 
	 * @param sql
	 * @param autoGeneratedKeys
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
	 **/
	    
	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareStatement(sql, autoGeneratedKeys);
	}
	
	/** 
	 * @param sql
	 * @param columnIndexes
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
	 **/
	    
	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareStatement(sql, columnIndexes);
	}
	
	/** 
	 * @param sql
	 * @param columnNames
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 **/
	    
	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.prepareStatement(sql, columnNames);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createClob()
	 **/
	    
	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createClob();
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createBlob()
	 **/
	    
	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createBlob();
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createNClob()
	 **/
	    
	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createNClob();
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createSQLXML()
	 **/
	    
	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createSQLXML();
	}
	
	/** 
	 * @param timeout
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#isValid(int)
	 **/
	    
	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.isValid(timeout);
	}
	
	/** 
	 * @param name
	 * @param value
	 * @throws SQLClientInfoException
	 * @see java.sql.Connection#setClientInfo(java.lang.String, java.lang.String)
	 **/
	    
	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		oldConnection.setClientInfo(name, value);
	}
	
	/** 
	 * @param properties
	 * @throws SQLClientInfoException
	 * @see java.sql.Connection#setClientInfo(java.util.Properties)
	 **/
	    
	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		oldConnection.setClientInfo(properties);
	}
	
	/** 
	 * @param name
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getClientInfo(java.lang.String)
	 **/
	    
	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getClientInfo(name);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getClientInfo()
	 **/
	    
	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getClientInfo();
	}
	
	/** 
	 * @param typeName
	 * @param elements
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createArrayOf(java.lang.String, java.lang.Object[])
	 **/
	    
	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createArrayOf(typeName, elements);
	}
	
	/** 
	 * @param typeName
	 * @param attributes
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
	 **/
	    
	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.createStruct(typeName, attributes);
	}
	
	/** 
	 * @param schema
	 * @throws SQLException
	 * @see java.sql.Connection#setSchema(java.lang.String)
	 **/
	    
	@Override
	public void setSchema(String schema) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getSchema()
	 **/
	    
	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getSchema();
	}
	
	/** 
	 * @param executor
	 * @throws SQLException
	 * @see java.sql.Connection#abort(java.util.concurrent.Executor)
	 **/
	    
	@Override
	public void abort(Executor executor) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.abort(executor);
	}
	
	/** 
	 * @param executor
	 * @param milliseconds
	 * @throws SQLException
	 * @see java.sql.Connection#setNetworkTimeout(java.util.concurrent.Executor, int)
	 **/
	    
	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		// TODO Auto-generated method stub
		oldConnection.setNetworkTimeout(executor, milliseconds);
	}
	
	/** 
	 * @return
	 * @throws SQLException
	 * @see java.sql.Connection#getNetworkTimeout()
	 **/
	    
	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return oldConnection.getNetworkTimeout();
	}
}
