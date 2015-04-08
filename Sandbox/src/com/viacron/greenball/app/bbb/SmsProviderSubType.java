/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateClassFile()). 
 * Do not edit.
 */
package com.viacron.greenball.app.bbb;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * The SmsProviderSubType class is a SubType referenced by message objects defined
 * by the GreenballMessages grammar.
 */
public class SmsProviderSubType {
   private static final int ID = GreenballMessagesEnum.SMS_PROVIDER_SUB_TYPE.getId();

   /**
    * The number of bits required to represent the SmsProviderSubTypeEnum IDs.
    * # of attributes: 3
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 2;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 0;

   private static Logger log4j = Logger.getLogger(SmsProviderSubType.class);

   // Entered buildClassEnum()
   private enum SmsProviderSubTypeEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      CARRIER(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      REGION(1, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      MAIL_TO_SMS_GATEWAY(2, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      SmsProviderSubTypeEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
         this.id = id;
         this.offsetInBits = offsetInBits;
         this.length = length;
         this.isDirectoryEntry = isDirectoryEntry;
      }

      public int getId() {
         return this.id;
      }

      public int getOffsetInBits() {
         return this.offsetInBits;
      }

      public int getLength() {
         return this.length;
      }

      public void setLength(int length) {
         this.length = length;
      }
   } // Leaving buildClassEnum()

   /*
    * The instance variables.
    * See buildInstanceVariables() in JBitByBitGenerator.java.
    */
   private String carrier;
   private String region;
   private String mailToSmsGateway;

   private String theErrorMsg;

   /**
    * The SmsProviderSubType no-arg constructor.
    */
   public SmsProviderSubType() {}

   /**
    * The SmsProviderSubType constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param carrier The carrier message attribute.
    * @param region The region message attribute.
    * @param mailToSmsGateway The mailToSmsGateway message attribute.
    */
   public SmsProviderSubType(String carrier,
                             String region,
                             String mailToSmsGateway) {
      // Entered buildParameterAssignments()
      this.setCarrier(carrier);
      this.setRegion(region);
      this.setMailToSmsGateway(mailToSmsGateway);
      // Leaving buildParameterAssignments()
   }

   /**
    * The SmsProviderSubType copy constructor.
    */
   public SmsProviderSubType(SmsProviderSubType smsProviderSubType) {
      // Entered buildCopyConstructorParameterAssignments()
      this.setCarrier(smsProviderSubType.getCarrier());
      this.setRegion(smsProviderSubType.getRegion());
      this.setMailToSmsGateway(smsProviderSubType.getMailToSmsGateway());
      // Leaving buildCopyConstructorParameterAssignments()
   }

   // Entered buildSetErrorMsgMethod()
   private void setErrorMsg(String errorMsg) {
      theErrorMsg = errorMsg;
   }
   // Leaving buildSetErrorMsgMethod()

   // Entered buildGetErrorMsgMethod()
   /**
    * This method returns the error message or null if no error
    * occurred.
    */
   public String getErrorMsg() {
      return theErrorMsg;
   }
   // Leaving buildGetErrorMsgMethod()

   // Entered buildPackMethod()
   /**
    * This method packs a SmsProviderSubType object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a SmsProviderSubType message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getSmsProviderSubTypeSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;


      SmsProviderSubTypeEnum.CARRIER.setLength(this.getCarrier() != null ? this.getCarrier().length() : 0);
      SmsProviderSubTypeEnum.REGION.setLength(this.getRegion() != null ? this.getRegion().length() : 0);
      SmsProviderSubTypeEnum.MAIL_TO_SMS_GATEWAY.setLength(this.getMailToSmsGateway() != null ? this.getMailToSmsGateway().length() : 0);

      int directorySize = getSmsProviderSubTypeDirectorySize();
      if (directorySize != 0) {
         // Create the directory
         theDirectory = new GreenballMessagesDirectoryEntry[directorySize];
         for (int i = 0; i < directorySize; i++) {
            theDirectory[i] = new GreenballMessagesDirectoryEntry();
         }

         // Fill the directory
         int index = 0;
         offset = DIRECTORY_OFFSET
               + GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES
               * theDirectory.length;

         for (SmsProviderSubTypeEnum smsProviderSubTypeEnum : SmsProviderSubTypeEnum.values()) {
            if (smsProviderSubTypeEnum.isDirectoryEntry == true) {
               int id = smsProviderSubTypeEnum.getId();
               int length = smsProviderSubTypeEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == SmsProviderSubTypeEnum.CARRIER.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "carrier", offset));
                  if (getCarrier() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getCarrier());
                     offset += length * 1;
                  }
               }
               else if (id == SmsProviderSubTypeEnum.REGION.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "region", offset));
                  if (getRegion() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getRegion());
                     offset += length * 1;
                  }
               }
               else if (id == SmsProviderSubTypeEnum.MAIL_TO_SMS_GATEWAY.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "mailToSmsGateway", offset));
                  if (getMailToSmsGateway() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getMailToSmsGateway());
                     offset += length * 1;
                  }
               }
               index++;
            }
         }

         // Insert the directory
         log4j.debug(String.format("inserting the directory at offset %d", DIRECTORY_OFFSET));
         offset = DIRECTORY_OFFSET;
         index = 0;
         for (GreenballMessagesDirectoryEntry directoryEntry : theDirectory) {
            log4j.debug(String.format("index[%d]: ", index));
            log4j.debug(String.format("  ID:     %d", directoryEntry.getId()));
            log4j.debug(String.format("  length: %d", directoryEntry.getLength()));
            log4j.debug(String.format("  offset: %d", directoryEntry.getOffset()));
            bb = GreenballMessagesUtility.insertInteger(bb, offset, directoryEntry.getId());
            bb = GreenballMessagesUtility.insertInteger(bb, offset + 4, directoryEntry.getLength());
            bb = GreenballMessagesUtility.insertInteger(bb, offset + 8, directoryEntry.getOffset());

            offset += GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
            index++;
         }

      }
      log4j.debug("Leaving " + METHOD);
      return bb;
   }
   // Leaving buildPackMethod()

   // Entered buildUnpackMethod()
   /**
    * This method unpacks a byte array containing a SmsProviderSubType object.
    *
    * @return The byte array as a SmsProviderSubType message object.
    */
   public SmsProviderSubType unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      SmsProviderSubType smsProviderSubType = new SmsProviderSubType();


      // Get the directory
      int directorySize = getSmsProviderSubTypeDirectorySize();
      theDirectory = new GreenballMessagesDirectoryEntry[directorySize];
      int dirOffset = DIRECTORY_OFFSET;

      for (int entry = 0 ; entry < directorySize; entry++) {
         GreenballMessagesDirectoryEntry directoryEntry = new GreenballMessagesDirectoryEntry();

         int id = GreenballMessagesUtility.getInteger(ba, dirOffset * 8);
         directoryEntry.setId(id);
         int length = GreenballMessagesUtility.getInteger(ba, (dirOffset + 4) * 8);
         directoryEntry.setLength(length);
         int offset = GreenballMessagesUtility.getInteger(ba, (dirOffset + 8) * 8);
         directoryEntry.setOffset(offset);

         theDirectory[entry] = directoryEntry;

         dirOffset += GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      }

      for (GreenballMessagesDirectoryEntry directoryEntry : theDirectory) {
         int id = directoryEntry.getId();
         int offset = directoryEntry.getOffset();
         int length = directoryEntry.getLength();

         if (id == SmsProviderSubTypeEnum.CARRIER.getId()) {
            smsProviderSubType.setCarrier(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == SmsProviderSubTypeEnum.REGION.getId()) {
            smsProviderSubType.setRegion(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == SmsProviderSubTypeEnum.MAIL_TO_SMS_GATEWAY.getId()) {
            smsProviderSubType.setMailToSmsGateway(GreenballMessagesUtility.getString(ba, offset, length));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return smsProviderSubType;
   }
   // Leaving buildUnpackMethod()

   /**
    * This method sets the carrier attribute. Setting of this value is required.
    * @param carrier The carrier attribute.
    */
   public void setCarrier(String carrier) {
      this.carrier = carrier;
   }

   /**
    * This method sets the region attribute. Setting of this value is required.
    * @param region The region attribute.
    */
   public void setRegion(String region) {
      this.region = region;
   }

   /**
    * This method sets the mailToSmsGateway attribute. Setting of this value is required.
    * @param mailToSmsGateway The mailToSmsGateway attribute.
    */
   public void setMailToSmsGateway(String mailToSmsGateway) {
      this.mailToSmsGateway = mailToSmsGateway;
   }

   /**
    * This method gets the carrier attribute. The carrier attribute is a required attribute.
    */
   public String getCarrier() {
      return this.carrier;
   }

   /**
    * This method gets the region attribute. The region attribute is a required attribute.
    */
   public String getRegion() {
      return this.region;
   }

   /**
    * This method gets the mailToSmsGateway attribute. The mailToSmsGateway attribute is a required attribute.
    */
   public String getMailToSmsGateway() {
      return this.mailToSmsGateway;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getSmsProviderSubTypeDirectorySize() {
      int directorySize = 0;

      // carrier
      directorySize++;
      // region
      directorySize++;
      // mailToSmsGateway
      directorySize++;

      return directorySize;
   }


   /**
    * This method gets the size of the SmsProviderSubType object.
    * @return The size in bytes.
    */
   public int getSmsProviderSubTypeSize() {
      int size = 0;

      int directorySize = getSmsProviderSubTypeDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add size of carrier
      size += (getCarrier() != null ? getCarrier().length() : 0);
      // Add size of region
      size += (getRegion() != null ? getRegion().length() : 0);
      // Add size of mailToSmsGateway
      size += (getMailToSmsGateway() != null ? getMailToSmsGateway().length() : 0);

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" carrier: " + carrier + NEW_LINE);
      result.append(" region: " + region + NEW_LINE);
      result.append(" mailToSmsGateway: " + mailToSmsGateway + NEW_LINE);

      result.append("} ");

      return result.toString();
   }

   /**
    * The hashCode method returns this object's hashCode.
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
         + ((String) carrier).hashCode();
      result = prime * result
         + ((String) region).hashCode();
      result = prime * result
         + ((String) mailToSmsGateway).hashCode();
      return result;
   }

   /**
    * The equals method checks for equality. 
    */
   public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;

      SmsProviderSubType smsProviderSubType = (SmsProviderSubType) obj;
      if (!smsProviderSubType.getCarrier().equals(this.getCarrier())) {
         return false;
      }

      if (!smsProviderSubType.getRegion().equals(this.getRegion())) {
         return false;
      }

      if (!smsProviderSubType.getMailToSmsGateway().equals(this.getMailToSmsGateway())) {
         return false;
      }

      return true;
   }
}