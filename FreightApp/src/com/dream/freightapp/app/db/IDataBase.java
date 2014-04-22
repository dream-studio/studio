package com.dream.freightapp.app.db;

public interface IDataBase {
	public String tableName();

	public String[] columnsName();

	public String[] columnsType();

	public String primaryKey();
}
