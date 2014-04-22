package com.dream.freightapp.app.db;

import java.util.Arrays;
import java.util.Map.Entry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dream.freightapp.app.FreightApplication;

public class Table {

	private static final String tag = "Table";

	private static final String DB_NAME = "Freight.db";
	private static final int DB_VERSION = 1;
	private Context mContext = FreightApplication.getInstance()
			.getApplicationContext();

	private static String DB_CREATE;
	private SQLiteDatabase mSQLiteDatabase = null;// 执行open（）打开数据库时，保存返回的数据库对象
	private DatabaseHelper mDatabaseHelper = null;// 由SQLiteOpenHelper继承过来

	/**
	 * DEFAULT
	 */
	private final static String PRIMARY_KEY = "PRIMARY KEY";
	private final static String CREATE_TABLE = "CREATE TABLE";

	/**
	 * DB TYPE
	 */
	public final static String COLUMN_TYPE_NULL = "NULL";// NULL 值是一个 NULL 值。
	public final static String COLUMN_TYPE_INTEGER = "INTEGER";// INTEGER
																// 值是一个带符号的整数，根据值的大小存储在
																// 1、2、3、4、6 或 8
																// 字节中。
	public final static String COLUMN_TYPE_TEXT = "TEXT";// TEXT
															// 值是一个文本字符串，使用数据库编码（UTF-8、UTF-16BE
															// 或 UTF-16LE）存储。
	public final static String COLUMN_TYPE_REAL = "REAL";// REAL 值是一个浮点值，存储为 8
															// 字节的 IEEE 浮点数字。
	public final static String COLUMN_TYPE_BLOB = "BLOB";// BLOB 值是一个 blob
															// 数据，完全根据它的输入存储。
	IDataBase iDataBase;

	public Table(IDataBase iDataBase) {
		this.iDataBase = iDataBase;
		getCreateTableSQL();
	}

	private String getColumnsNameIndex(int index) {
		return iDataBase.columnsName()[index];
	}

	private String getColumnsTypeIndex(int index) {
		return iDataBase.columnsType()[index];
	}

	private int getColumnsNameCount() {
		return iDataBase.columnsName().length;
	}

	private int getColumnsTypeCount() {
		return iDataBase.columnsType().length;
	}

	/**
	 * Create Table SQL
	 */
	private void getCreateTableSQL() {
		DB_CREATE = CREATE_TABLE + " " + iDataBase.tableName();
		String columns = "";
		for (int i = 0; i < getColumnsNameCount(); i++) {
			columns += getColumnsNameIndex(i) + " " + getColumnsTypeIndex(i);
			if (i != getColumnsNameCount() - 1) {
				columns += ",";
			}
		}
		DB_CREATE += "(" + iDataBase.primaryKey() + " " + COLUMN_TYPE_INTEGER
				+ " " + PRIMARY_KEY + "," + columns + ")";
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {

		/* 构造函数-创建一个数据库 */
		DatabaseHelper(Context context) {

			// 当调用getWritableDatabase()
			// 或 getReadableDatabase()方法时
			// 则创建一个数据库
			super(context, DB_NAME, null, DB_VERSION);
		}

		/* 创建一个表 */
		@Override
		public void onCreate(SQLiteDatabase db) {

			// 数据库没有表时创建一个
			db.execSQL(DB_CREATE);
		}

		/* 升级数据库 */
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			db.execSQL("DROP TABLE IF EXISTS notes");
			onCreate(db);
		}
	}

	// 打开数据库，返回数据库对象
	public void open() throws SQLException {
		mDatabaseHelper = new DatabaseHelper(mContext);
		mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
	}

	// 关闭数据库
	public void close() {
		mDatabaseHelper.close();
	}

	/**
	 * 删除一条数据
	 * 
	 * @param rowId
	 * @return {@link Boolean}
	 */
	public boolean delete(long rowId) {
		return mSQLiteDatabase.delete(iDataBase.tableName(),
				iDataBase.primaryKey() + "=" + rowId, null) > 0;
	}

	/**
	 * 通过Cursor查询所有数据
	 * 
	 * @return {@link Cursor}
	 */
	public Cursor fetchAll() {
		return mSQLiteDatabase.query(iDataBase.tableName(),
				iDataBase.columnsName(), null, null, null, null, null);
	}

	/**
	 * 查询指定数据
	 * 
	 * @param rowId
	 * @return {@link Cursor}
	 * @throws SQLException
	 */
	public Cursor fetchById(long rowId) throws SQLException {
		Cursor mCursor = mSQLiteDatabase.query(true, iDataBase.tableName(),
				iDataBase.columnsName(), iDataBase.primaryKey() + "=" + rowId,
				null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public Cursor fetch(ContentValues contentValues) {
		Cursor mCursor = null;
		if (contentValues.size() > 0) {
			String conditions = "";
			for (Entry<String, Object> entry : contentValues.valueSet()) {
				conditions += entry.getKey() + " = '" + entry.getValue()
						+ "' AND ";
			}

			if (conditions != "") {
				conditions = conditions.substring(0, conditions.length()
						- " AND ".length());
			}

			String[] fields = addStr(iDataBase.columnsName(),
					iDataBase.primaryKey());
			mCursor = mSQLiteDatabase.query(true, iDataBase.tableName(),
					fields, conditions, null, null, null, null, null);
			if (mCursor != null) {
				mCursor.moveToFirst();
			}
		}

		return mCursor;
	}

	/**
	 * 插入一条数据
	 * 
	 * @param initialValues
	 * @return {@link Integer}
	 */
	public long create(ContentValues contentValues) {
		long result = mSQLiteDatabase.insert(iDataBase.tableName(),
				iDataBase.primaryKey(), contentValues);
		Log.i(tag, "Create result: " + result);
		return result;
	}

	/**
	 * 更新一条数据
	 * 
	 * @param rowId
	 * @return {@link Boolean}
	 */
	public boolean edit(long rowId, ContentValues contentValues) {
		return mSQLiteDatabase.update(iDataBase.tableName(), contentValues,
				iDataBase.primaryKey() + "=" + rowId, null) > 0;
	}

	/**
	 * 执行SQL，但无返回
	 * 
	 * @param SQL
	 */
	public void query(String SQL) {
		mSQLiteDatabase.execSQL(SQL);
	}

	private String[] addStr(String[] strArray, String val) {
		strArray = Arrays.copyOf(strArray, strArray.length + 1);
		strArray[strArray.length - 1] = val;
		return strArray;
	}

}
