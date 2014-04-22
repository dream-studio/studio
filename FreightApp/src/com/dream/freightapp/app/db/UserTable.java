package com.dream.freightapp.app.db;

import android.content.ContentValues;

public class UserTable extends Table {

	public final static String FIELD_PREMARY_KEY_ID = "ID";
	public final static String FIELD_ACCOUNT = "ACCOUNT";
	public final static String FIELD_PASSWORD = "PASSWORD";
	public final static String FIELD_PHONE = "PHONE";

	private final static String TABLE_NAME = "TABLE_USER";
	private final static String COLUMNS_NAME[] = { FIELD_ACCOUNT,
			FIELD_PASSWORD, FIELD_PHONE };
	private final static String COLUMNS_TYPE[] = { Table.COLUMN_TYPE_TEXT,
			Table.COLUMN_TYPE_TEXT, Table.COLUMN_TYPE_TEXT };

	public UserTable() {
		// TODO Auto-generated constructor stub
		super(new IDataBase() {

			@Override
			public String tableName() {
				// TODO Auto-generated method stub
				return TABLE_NAME;
			}

			@Override
			public String[] columnsName() {
				// TODO Auto-generated method stub
				return COLUMNS_NAME;
			}

			@Override
			public String[] columnsType() {
				// TODO Auto-generated method stub
				return COLUMNS_TYPE;
			}

			@Override
			public String primaryKey() {
				// TODO Auto-generated method stub
				return FIELD_PREMARY_KEY_ID;
			}
		});
	}
	
	public static void main(String[] args) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(UserTable.FIELD_ACCOUNT, "goffee");
		contentValues.put(UserTable.FIELD_PASSWORD, "123");
		contentValues.put(UserTable.FIELD_PHONE, "12345679");

		UserTable userTable = new UserTable();
		userTable.open();
		userTable.create(contentValues);
		userTable.close();
	}
}
