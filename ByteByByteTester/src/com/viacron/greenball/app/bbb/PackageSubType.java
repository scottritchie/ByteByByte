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
 * The PackageSubType class is a SubType referenced by message objects defined
 * by the GreenballMessages grammar.
 */
public class PackageSubType {
   private static final int ID = GreenballMessagesEnum.PACKAGE_SUB_TYPE.getId();

   /**
    * The number of bits required to represent the PackageSubTypeEnum IDs.
    * # of attributes: 4
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 2;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 0;

   private static Logger log4j = Logger.getLogger(PackageSubType.class);

   // Entered buildClassEnum()
   private enum PackageSubTypeEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      NAME(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      DATA_TYPE(1, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      IMPRT(2, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ELEMENT(3, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      PackageSubTypeEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private String name;
   private List<Datatype> dataType;
   private List<ImportSubType> imprt;
   private List<MetaModelElement> element;

   private String theErrorMsg;

   /**
    * The PackageSubType no-arg constructor.
    */
   public PackageSubType() {}

   /**
    * The PackageSubType constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param name The name message attribute.
    * @param dataType The dataType message attribute.
    * @param imprt The imprt message attribute.
    * @param element The element message attribute.
    */
   public PackageSubType(String name, List<Datatype> dataType, List<ImportSubType> imprt, List<MetaModelElement> element) {
      // Entered buildParameterAssignments()
      this.setName(name);
      this.setDataType(dataType);
      this.setImprt(imprt);
      this.setElement(element);
      // Leaving buildParameterAssignments()
   }

   /**
    * The PackageSubType copy constructor.
    */
   public PackageSubType(PackageSubType packageSubType) {
      // Entered buildCopyConstructorParameterAssignments()
      this.setName(packageSubType.getName());
      for(Datatype tmpDatatype : packageSubType.getDataType()) {
         this.getDataType().add(new Datatype(tmpDatatype));
      }
      for(ImportSubType tmpImportSubType : packageSubType.getImprt()) {
         this.getImprt().add(new ImportSubType(tmpImportSubType));
      }
      for(MetaModelElement tmpMetaModelElement : packageSubType.getElement()) {
         this.getElement().add(new MetaModelElement(tmpMetaModelElement));
      }
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
    * This method packs a PackageSubType object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a PackageSubType message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getPackageSubTypeSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;


      PackageSubTypeEnum.NAME.setLength(this.getName().length());
      PackageSubTypeEnum.DATA_TYPE.setLength(this.getDataType().size());
      PackageSubTypeEnum.IMPRT.setLength(this.getImprt().size());
      PackageSubTypeEnum.ELEMENT.setLength(this.getElement().size());

      int directorySize = getPackageSubTypeDirectorySize();
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

         for (PackageSubTypeEnum packageSubTypeEnum : PackageSubTypeEnum.values()) {
            if (packageSubTypeEnum.isDirectoryEntry == true) {
               int id = packageSubTypeEnum.getId();
               int length = packageSubTypeEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == PackageSubTypeEnum.NAME.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "name", offset));
                  bb = GreenballMessagesUtility.insertString(bb, offset, getName());
                  offset += length * 1;
               }
               else if (id == PackageSubTypeEnum.DATA_TYPE.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "dataType", offset));
                  for (Datatype datatype : this.dataType) {
                     byte[] bytes = datatype.pack();
                     bb = GreenballMessagesUtility.insertBytes(bb, offset, bytes);

                     theDirectory[index].setId(id);
                     theDirectory[index].setLength(bytes.length);
                     theDirectory[index].setOffset(offset);

                     offset += bytes.length;
                     index++;
                  }
               }
               else if (id == PackageSubTypeEnum.IMPRT.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "imprt", offset));
                  for (ImportSubType importSubType : this.imprt) {
                     byte[] bytes = importSubType.pack();
                     bb = GreenballMessagesUtility.insertBytes(bb, offset, bytes);

                     theDirectory[index].setId(id);
                     theDirectory[index].setLength(bytes.length);
                     theDirectory[index].setOffset(offset);

                     offset += bytes.length;
                     index++;
                  }
               }
               else if (id == PackageSubTypeEnum.ELEMENT.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "element", offset));
                  for (MetaModelElement metaModelElement : this.element) {
                     byte[] bytes = metaModelElement.pack();
                     bb = GreenballMessagesUtility.insertBytes(bb, offset, bytes);

                     theDirectory[index].setId(id);
                     theDirectory[index].setLength(bytes.length);
                     theDirectory[index].setOffset(offset);

                     offset += bytes.length;
                     index++;
                  }
               }
               index++;
            }
         }

         // Insert the directory
         offset = DIRECTORY_OFFSET;
         for (GreenballMessagesDirectoryEntry directoryEntry : theDirectory) {
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
    * This method unpacks a byte array containing a PackageSubType object.
    *
    * @return The byte array as a PackageSubType message object.
    */
   public PackageSubType unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      PackageSubType packageSubType = new PackageSubType();


      // Get the directory
      int directorySize = getPackageSubTypeDirectorySize();
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

         if (id == PackageSubTypeEnum.NAME.getId()) {
            packageSubType.setName(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == PackageSubTypeEnum.DATA_TYPE.getId()) {
            byte[] bytes = new byte[length];
            for (int index = 0; index < length; index++) {
               bytes[index] = GreenballMessagesUtility.getByte(ba, (offset + index) * 8);
            }
            packageSubType.getDataType().add(new Datatype().unpack(bytes));
         }
         else if (id == PackageSubTypeEnum.IMPRT.getId()) {
            byte[] bytes = new byte[length];
            for (int index = 0; index < length; index++) {
               bytes[index] = GreenballMessagesUtility.getByte(ba, (offset + index) * 8);
            }
            packageSubType.getImprt().add(new ImportSubType().unpack(bytes));
         }
         else if (id == PackageSubTypeEnum.ELEMENT.getId()) {
            byte[] bytes = new byte[length];
            for (int index = 0; index < length; index++) {
               bytes[index] = GreenballMessagesUtility.getByte(ba, (offset + index) * 8);
            }
            packageSubType.getElement().add(new MetaModelElement().unpack(bytes));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return packageSubType;
   }
   // Leaving buildUnpackMethod()

   /**
    * This method sets the name attribute. Setting of this value is required.
    * @param name The name attribute.
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * This method gets the name attribute. The name attribute is a required attribute.
    */
   public String getName() {
      return this.name;
   }

   /**
    * This method sets the dataType attribute. Setting of this value is required.
    * @param dataType The dataType.
    */
   public void setDataType(List<Datatype> dataType) {
      this.dataType = dataType;
   }

   /**
    * This method sets the imprt attribute. Setting of this value is required.
    * @param imprt The imprt.
    */
   public void setImprt(List<ImportSubType> imprt) {
      this.imprt = imprt;
   }

   /**
    * This method sets the element attribute. Setting of this value is required.
    * @param element The element.
    */
   public void setElement(List<MetaModelElement> element) {
      this.element = element;
   }

   /**
    * This method gets the dataType attribute. The dataType attribute is a required attribute.
    */
   public List<Datatype> getDataType() {
      if (this.dataType == null) {
         this.dataType = new ArrayList<Datatype>();
      }
      return this.dataType;
   }

   /**
    * This method gets the imprt attribute. The imprt attribute is a required attribute.
    */
   public List<ImportSubType> getImprt() {
      if (this.imprt == null) {
         this.imprt = new ArrayList<ImportSubType>();
      }
      return this.imprt;
   }

   /**
    * This method gets the element attribute. The element attribute is a required attribute.
    */
   public List<MetaModelElement> getElement() {
      if (this.element == null) {
         this.element = new ArrayList<MetaModelElement>();
      }
      return this.element;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getPackageSubTypeDirectorySize() {
      int directorySize = 0;

      // name
      directorySize++;
      // dataType
      directorySize += getDataType().size();
      // imprt
      directorySize += getImprt().size();
      // element
      directorySize += getElement().size();

      return directorySize;
   }


   /**
    * This method gets the size of the PackageSubType object.
    * @return The size in bytes.
    */
   public int getPackageSubTypeSize() {
      int size = 0;

      int directorySize = getPackageSubTypeDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add size of name
      size += (getName() != null ? getName().length() : 0);
      // Add size of dataType
      for (Datatype datatype: getDataType()) {
         size += datatype.getDatatypeSize();
      }
      // Add size of imprt
      for (ImportSubType importSubType: getImprt()) {
         size += importSubType.getImportSubTypeSize();
      }
      // Add size of element
      for (MetaModelElement metaModelElement: getElement()) {
         size += metaModelElement.getMetaModelElementSize();
      }

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" name: " + name + NEW_LINE);

      if (dataType != null) {
         for (Datatype dataTypeDatatype : dataType) {
            result.append(dataTypeDatatype.toString());
         }
      }

      if (imprt != null) {
         for (ImportSubType imprtImportSubType : imprt) {
            result.append(imprtImportSubType.toString());
         }
      }

      if (element != null) {
         for (MetaModelElement elementMetaModelElement : element) {
            result.append(elementMetaModelElement.toString());
         }
      }

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
         + ((String) name).hashCode();
      return result;
   }

   /**
    * The equals method checks for equality. 
    */
   public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;

      PackageSubType packageSubType = (PackageSubType) obj;
      if (!packageSubType.getName().equals(this.getName())) {
         return false;
      }

      return true;
   }
}
