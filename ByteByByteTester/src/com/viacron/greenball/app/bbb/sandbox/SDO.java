package com.viacron.greenball.app.bbb.sandbox;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class SDO {

	private static byte[] theData = new byte[200];
	private static DirectoryEntry[] theDirectory;

	private static final String DEFAULT_DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

	private static int theDirectoryOffset;
	private static final int DIRECTORY_SIZE = 12;
	private static int numberOfDirectoryEntries;

	private static class DirectoryEntry {
		private int id;
		private int offset;
		private int length;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}
	}

	private enum AnEnum {
		VALUE1, VALUE2, VALUE3, VALUE4, VALUE5, VALUE6;
	}

	private static class SomeData {
		private long id;
		private Date tradeDate;
		private String seller;
		private String currency1;
		private double amount1;
		private double exchangeRate;
		private String currency2;
		private double amount2;
		private String buyer;
		private Date settlementDate;
		private AnEnum anEnum;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Date getTradeDate() {
			return tradeDate;
		}

		public void setTradeDate(Date tradeDate) {
			this.tradeDate = tradeDate;
		}

		public String getSeller() {
			return seller;
		}

		public void setSeller(String bySell) {
			this.seller = bySell;
		}

		public String getCurrency1() {
			return currency1;
		}

		public void setCurrency1(String currency1) {
			this.currency1 = currency1;
		}

		public double getAmount1() {
			return amount1;
		}

		public void setAmount1(double amount1) {
			this.amount1 = amount1;
		}

		public double getExchangeRate() {
			return exchangeRate;
		}

		public void setExchangeRate(double exchangeRate) {
			this.exchangeRate = exchangeRate;
		}

		public String getCurrency2() {
			return currency2;
		}

		public void setCurrency2(String currency2) {
			this.currency2 = currency2;
		}

		public double getAmount2() {
			return amount2;
		}

		public void setAmount2(double amount2) {
			this.amount2 = amount2;
		}

		public Date getSettlementDate() {
			return settlementDate;
		}

		public void setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate;
		}

		public String getBuyer() {
			return buyer;
		}

		public void setBuyer(String buyer) {
			this.buyer = buyer;
		}

		public AnEnum getAnEnum() {
			return anEnum;
		}

		public void setAnEnum(AnEnum anEnum) {
			this.anEnum = anEnum;
		}
	}

	/**
	 * The supported data types. Sizes are as follows:
	 * 
	 * byte: 8 bits
	 * 
	 * short: 16 bits
	 * 
	 * int: 32 bits
	 * 
	 * long 64 bits
	 * 
	 * float: 32 bits
	 * 
	 * double 64 bits
	 * 
	 * boolean: 1 bit
	 * 
	 * char: 16 bits
	 * 
	 * @author goesrsr
	 * 
	 */
	public enum DataType {
		BITFIELD, BOOLEAN, CHAR, BYTE, SHORT, DOUBLE, FLOAT, INT, LONG, DATE, STRING
	}

	public enum DataStructure {
		ID(1, "ID", DataType.LONG, 1, 8),

		TRADE_DATE(2, "Trade Date", DataType.DATE, 9, 8),

		SELLER(3, "Seller", DataType.STRING, 0, -1),

		CURRENCY1(4, "Currency1", DataType.STRING, 0, -1),

		AMOUNT1(5, "Amount1", DataType.DOUBLE, 17, 8),

		EXCHANGE_RATE(6, "Exhange Rate", DataType.DOUBLE, 25, 8),

		CURRENCY2(7, "Currency2", DataType.STRING, 0, -1),

		AMOUNT2(8, "Amount2", DataType.DOUBLE, 33, 8),

		BUYER(9, "Buyer", DataType.STRING, 0, -1),

		SETTLEMENT_DATE(10, "Settlement Date", DataType.DATE, 41, 8),

		AN_ENUM(11, "An enum", DataType.BITFIELD, 0,
				log2(AnEnum.values().length));

		private static final Map<Integer, DataStructure> lookup = new HashMap<Integer, DataStructure>();

		static {
			for (DataStructure enumType : EnumSet.allOf(DataStructure.class)) {
				lookup.put(enumType.getId(), enumType);
			}
		}

		private int id;
		private String label;
		private DataType dataType;

		/** The offset in bytes */
		private int offset;

		/**
		 * The length in bytes except for bitfields which is the length in bits.
		 * String have length -1 to indicate it is not know until runtime.
		 */
		private int length;

		DataStructure(int id, String label, DataType dataType, int offset,
				int length) {
			this.setId(id);
			this.setLabel(label);
			this.setDataType(dataType);
			this.setOffset(offset);
			this.setLength(length);
		}

		public static DataStructure toEnum(int id) {
			return lookup.get(id);
		}

		public void setLength(int length) {
			this.length = length;
		}

		public int getLength() {
			return this.length;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public DataType getDataType() {
			return dataType;
		}

		public void setDataType(DataType dataType) {
			this.dataType = dataType;
		}

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();

		long tm = date.getTime();
		long tod_in_secs = tm % 86_400_000L / 1000;

		SimpleDateFormat formatter = new SimpleDateFormat(
				DEFAULT_DATE_TIME_FORMAT);
		System.out.println("date/time: " + formatter.format(date));
		System.out.println("tm: " + tm);
		System.out.println("tm_in_secs: " + tod_in_secs);
		System.out.println("HH: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("MM: " + cal.get(Calendar.MINUTE));
		System.out.println("SS: " + cal.get(Calendar.SECOND));

		System.out.println("tod_in_secs: "
				+ ((cal.get(Calendar.HOUR_OF_DAY) + 5) * 60 * 60
						+ cal.get(Calendar.MINUTE) * 60 + cal
							.get(Calendar.SECOND)));

		SomeData sd = new SomeData();
		sd.setAmount1(100.0);
		sd.setAmount2(200.00);
		sd.setSeller("Me");
		sd.setBuyer("You");
		sd.setCurrency1("USD");
		sd.setCurrency2("YEN");
		sd.setExchangeRate(112);
		sd.setId(12345);
		sd.setSettlementDate(new Date());
		sd.setTradeDate(new Date());
		sd.setAnEnum(AnEnum.VALUE4);

		theDirectoryOffset = getDirectoryOffset();
		System.out.println("theDirectoryOffset: " + theDirectoryOffset);
		numberOfDirectoryEntries = getNumberOfDirectoryEntries();
		System.out.println("numberOfDirectoryEntries: "
				+ numberOfDirectoryEntries);

		theDirectory = new DirectoryEntry[numberOfDirectoryEntries];
		System.out.println("buyer ID: " + DataStructure.BUYER.getId());

		for (int i = 0; i < numberOfDirectoryEntries; i++) {
			theDirectory[i] = new DirectoryEntry();
		}
		theDirectory[0].setId(DataStructure.BUYER.getId());
		theDirectory[0].setOffset(theDirectoryOffset + numberOfDirectoryEntries
				* DIRECTORY_SIZE);
		theDirectory[0].setLength(sd.getBuyer().length());

		theDirectory[1].setId(DataStructure.SELLER.getId());
		theDirectory[1].setOffset(theDirectory[0].getOffset()
				+ theDirectory[0].getLength());
		theDirectory[1].setLength(sd.getSeller().length());

		theDirectory[2].setId(DataStructure.CURRENCY1.getId());
		theDirectory[2].setOffset(theDirectory[1].getOffset()
				+ theDirectory[1].getLength());
		theDirectory[2].setLength(sd.getCurrency1().length());

		theDirectory[3].setId(DataStructure.CURRENCY2.getId());
		theDirectory[3].setOffset(theDirectory[2].getOffset()
				+ theDirectory[2].getLength());
		theDirectory[3].setLength(sd.getCurrency2().length());

		pack(sd);

		for (int i = 0; i < theData.length; i++) {
			System.out.println(String.format("theData[%d]: %d", i, theData[i]));
		}

		SomeData sd1 = unpack();

		System.out.println(String.format("Amount1: %f", sd1.getAmount1()));
		System.out.println(String.format("Amount2: %f", sd1.getAmount2()));
		System.out.println(String.format("Buyer: %s", sd1.getBuyer()));
		System.out.println(String.format("Currency1: %s", sd1.getCurrency1()));
		System.out.println(String.format("Currency2: %s", sd1.getCurrency2()));
		System.out.println(String.format("Exchange rate: %f",
				sd1.getExchangeRate()));
		System.out.println(String.format("ID: %d", sd1.getId()));
		System.out.println(String.format("Seller: %s", sd1.getSeller()));
		System.out.println(String.format("Settlement Date: %s",
				sd1.getSettlementDate()));
		System.out.println(String.format("Trade Date: %s", sd1.getTradeDate()));

		System.out.println("log2(4): " + log2(AnEnum.values().length));
	}

	private static void pack(SomeData sd) {
		for (DataStructure ds : DataStructure.values()) {
			int offset = ds.getOffset();
			int length = ds.getLength();
			String label = ds.getLabel();
			System.out.println("label: " + label);
			System.out.println("offset: " + offset);
			System.out.println("length: " + length);

			if (ds.getId() == DataStructure.AMOUNT1.getId()) {
				insertDouble(offset, sd.getAmount1());
			} else if (ds.getId() == DataStructure.AMOUNT2.getId()) {
				insertDouble(offset, sd.getAmount2());
			} else if (ds.getId() == DataStructure.EXCHANGE_RATE.getId()) {
				insertDouble(offset, sd.getExchangeRate());
			} else if (ds.getId() == DataStructure.ID.getId()) {
				insertLong(offset, sd.getId());
			} else if (ds.getId() == DataStructure.SETTLEMENT_DATE.getId()) {
				insertDate(offset, sd.getSettlementDate());
			} else if (ds.getId() == DataStructure.TRADE_DATE.getId()) {
				insertDate(offset, sd.getTradeDate());
			} else if (ds.getId() == DataStructure.AN_ENUM.getId()) {
				System.out.println("***************************");
				insertBitfield(offset, length, sd.getAnEnum().ordinal());
				System.out.println("***************************");
			}
		}

		/*
		 * Write the directory and strings to the byte array
		 */
		System.out.println("Start writing directory...");
		for (int i = 0; i < numberOfDirectoryEntries; i++) {
			int id = theDirectory[i].getId();
			int offset = theDirectory[i].getOffset();
			insertInt(theDirectoryOffset + (i * DIRECTORY_SIZE), id);
			insertInt(theDirectoryOffset + (i * DIRECTORY_SIZE) + 4, offset);
			insertInt(theDirectoryOffset + (i * DIRECTORY_SIZE) + 8,
					theDirectory[i].getLength());
		}
		System.out.println("Done writing directory");

		/*
		 * Write the directory and strings to the byte array
		 */
		System.out.println("Start writing strings...");
		for (int i = 0; i < numberOfDirectoryEntries; i++) {
			int id = theDirectory[i].getId();
			int offset = theDirectory[i].getOffset();

			if (id == DataStructure.BUYER.getId()) {
				insertString(offset, sd.getBuyer().getBytes());
			} else if (id == DataStructure.CURRENCY1.getId()) {
				insertString(offset, sd.getCurrency1().getBytes());
			} else if (id == DataStructure.CURRENCY2.getId()) {
				insertString(offset, sd.getCurrency2().getBytes());
			} else if (id == DataStructure.SELLER.getId()) {
				insertString(offset, sd.getSeller().getBytes());
			}
		}
		System.out.println("Done writing strings");
	}

	private static SomeData unpack() {
		SomeData sd = new SomeData();

		/*
		 * Get the strings
		 */
		for (int i = 0; i < numberOfDirectoryEntries; i++) {
			int id = getInt(theDirectoryOffset + (i * DIRECTORY_SIZE));
			int offset = getInt(theDirectoryOffset + (i * DIRECTORY_SIZE) + 4);
			int length = getInt(theDirectoryOffset + (i * DIRECTORY_SIZE) + 8);

			System.out.println("id: " + id);
			System.out.println("offset: " + offset);
			System.out.println("length: " + length);

			String result = getString(offset, length);
			System.out.println("result: " + result);

			if (id == DataStructure.BUYER.getId()) {
				sd.setBuyer(result);
			} else if (id == DataStructure.CURRENCY1.getId()) {
				sd.setCurrency1(result);
			} else if (id == DataStructure.CURRENCY2.getId()) {
				sd.setCurrency2(result);
			} else if (id == DataStructure.SELLER.getId()) {
				sd.setSeller(result);
			}
		}

		for (DataStructure ds : DataStructure.values()) {
			int offset = ds.getOffset();

			System.out.println("offset: " + offset);

			if (ds.getId() == DataStructure.AMOUNT1.getId()) {
				sd.setAmount1(getDouble(offset));
				System.out.println(DataStructure.AMOUNT1.getLabel() + ": "
						+ sd.getAmount1());
			} else if (ds.getId() == DataStructure.AMOUNT2.getId()) {
				sd.setAmount2(getDouble(offset));
				System.out.println(DataStructure.AMOUNT2.getLabel() + ": "
						+ sd.getAmount2());
			} else if (ds.getId() == DataStructure.EXCHANGE_RATE.getId()) {
				sd.setExchangeRate(getDouble(offset));
			} else if (ds.getId() == DataStructure.ID.getId()) {
				sd.setId(getLong(offset));

				System.out.println(DataStructure.ID.getLabel() + ": "
						+ sd.getId());
			} else if (ds.getId() == DataStructure.SETTLEMENT_DATE.getId()) {
				sd.setSettlementDate(getDate(offset));
			} else if (ds.getId() == DataStructure.TRADE_DATE.getId()) {
				sd.setTradeDate(getDate(offset));
			}
		}

		return sd;
	}

	private static String getString(int offset, int len) {
		String result = "";

		for (int i = 0; i < len; i++) {
			result += (char) theData[offset + i];
		}
		return result;
	}

	private static int getInt(int offset) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += (int) theData[offset + i] << ((4 - i) * 8);
		}

		return result;
	}

	private static long getLong(int offset) {
		long result = 0; 
		
		for (int i = 0; i < 8; i++) {
			System.out.println(String.format("theData[%d]: %d (%d)",
					offset + i, theData[offset + i],
					(long) theData[offset + i] << ((7 - i) * 8)));
			result |= (long) theData[offset + i] << ((7 - i) * 8);
		}

		return result;
	}

	private static Date getDate(int offset) {
		System.out.println("getDate offset: " + offset);
		long result = 0;
		for (int i = 0; i < 8; i++) {
			System.out.println(String.format("theData[%d]: %d (%d)",
					offset + i, theData[offset + i],
					(long) theData[offset + i] << ((7 - i) * 8)));
			result |= (long) theData[offset + i] << ((7 - i) * 8);
		}

		return new Date(result);
	}

	private static double getDouble(int offset) {
		long result = 0;
		for (int i = 0; i < 8; i++) {
			result |= (long) theData[offset + i] << ((7 - i) * 8);
		}

		return Double.longBitsToDouble(result);
	}

	private static void insertBitfield(int offset, int length, int value) {
		String binaryString = Integer.toBinaryString(value);
		System.out.println("binaryString: " + binaryString);
		String paddedBinaryString = String.format(
				"%0" + (length - binaryString.length()) + "d" + "%s", 0,
				binaryString);
		System.out.println("paddedBinaryString: " + paddedBinaryString);

		int bitCounter = offset;
		for (char c : paddedBinaryString.toCharArray()) {
			int index = bitCounter / 8;
			int shift = 7 - bitCounter % 8;

			System.out.println("index: " + index);
			System.out.println("shift: " + shift);

			if (c == '1') {
				theData[index] |= 1 << shift;
			} else {
				theData[index] &= ~(1 << shift);
			}

			System.out.println("result: "
					+ theData[index]);

			bitCounter++;
		}
	}

	private static void insertDate(int offset, Date date) {
		long lng = date.getTime();
		for (int i = 0; i < 8; i++) {
			setByte(offset + i, (byte) (lng >>> ((7 - i) * 8)));
		}
	}

	private static void insertDouble(int offset, double d) {
		long lng = Double.doubleToLongBits(d);
		for (int i = 0; i < 8; i++) {
			setByte(offset + i, (byte) (lng >>> ((7 - i) * 8)));
		}
	}

	private static void insertLong(int offset, long lng) {

		System.out.println(">>> offset: " + offset);
		System.out.println(">>> lng: " + lng);

		for (int i = 0; i < 8; i++) {
			setByte(offset + i, (byte) (lng >>> ((7 - i) * 8)));

			System.out.println(String.format(">>>theData[%d]: %d", i,
					theData[offset + i]));
		}
	}

	private static void insertInt(int offset, int integer) {
		for (int i = 0; i < 4; i++) {
			setByte(offset + i, (byte) (integer >>> ((4 - i) * 8)));
		}
	}

	private static void insertString(int offset, byte[] bytes) {
		System.out.println("insertString offset: " + offset);
		for (int i = 0; i < bytes.length; i++) {
			setByte(offset + i, bytes[i]);
		}
	}

	private static void setByte(int offset, byte b) {
		System.out.println("setByte: " + offset);
		theData[offset] = b;
	}

	private static int getDirectoryOffset() {
		int directoryOffset = 0;
		for (DataStructure ds : DataStructure.values()) {
			int offsetInBytes = ds.getOffset();
			int sizeInBytes = 0;

			if (ds.getDataType() == DataType.BOOLEAN) {
				sizeInBytes = 1;
			} else if (ds.getDataType() == DataType.BYTE) {
				sizeInBytes = 1;
			} else if (ds.getDataType() == DataType.CHAR) {
				sizeInBytes = 2;
			} else if (ds.getDataType() == DataType.DATE) {
				sizeInBytes = 8;
			} else if (ds.getDataType() == DataType.DOUBLE) {
				sizeInBytes = 8;
			} else if (ds.getDataType() == DataType.FLOAT) {
				sizeInBytes = 8;
			} else if (ds.getDataType() == DataType.INT) {
				sizeInBytes = 4;
			} else if (ds.getDataType() == DataType.LONG) {
				sizeInBytes = 8;
			} else if (ds.getDataType() == DataType.SHORT) {
				sizeInBytes = 2;
			} else if (ds.getDataType() == DataType.STRING) {
				sizeInBytes = 0;
			}

			if (offsetInBytes + sizeInBytes > directoryOffset) {
				directoryOffset = offsetInBytes + sizeInBytes;
			}
		}

		return directoryOffset;
	}

	private static int getNumberOfDirectoryEntries() {
		int nbrOfDirectorEntries = 0;
		for (DataStructure ds : DataStructure.values()) {
			if (ds.getDataType() == DataType.STRING) {
				nbrOfDirectorEntries++;
			}
		}

		return nbrOfDirectorEntries;
	}

	/*
	 * This method returns the number of bits required to represent the given
	 * value.
	 */
	private static int log2(int value) {
		return Integer.SIZE - Integer.numberOfLeadingZeros(value);
	}
}
