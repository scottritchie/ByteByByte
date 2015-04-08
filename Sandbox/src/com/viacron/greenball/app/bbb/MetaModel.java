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
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;
import com.viacron.utils.StringMessageBuffer.parser.Element;
import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;
import com.viacron.utils.StringMessageBuffer.parser.SMBGLexer;
import com.viacron.utils.StringMessageBuffer.parser.SMBGParser;

/**
 * The MetaModel class defines a message of the messaging system defined
 * by the GreenballMessages grammar. It provides methods for packing a MetaModel object
 * into a byte array or string, and for unpacking a byte array or string
 * back into a MetaModel object.
 */
public class MetaModel {
   private static final int ID = GreenballMessagesEnum.META_MODEL.getId();

   /**
    * The number of bits required to represent the MetaModelEnum IDs.
    * # of attributes: 2
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 1;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 2;

   private static Logger log4j = Logger.getLogger(MetaModel.class);

   // Entered buildClassEnum()
   private enum MetaModelEnum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      ID(0, -1, 0, true),

      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      PCKG(1, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      MetaModelEnum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private String id;
   private List<PackageSubType> pckg;

   private String theErrorMsg;

   /**
    * The MetaModel no-arg constructor.
    */
   public MetaModel() {}

   /**
    * The MetaModel constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param id The id message attribute.
    * @param pckg The pckg message attribute.
    */
   public MetaModel(String id, List<PackageSubType> pckg) {
      // Entered buildParameterAssignments()
      this.setId(id);
      this.setPckg(pckg);
      // Leaving buildParameterAssignments()
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
    * This method packs a MetaModel object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a MetaModel message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getMetaModelSize();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      bb = GreenballMessagesUtility.insertShort(bb, offset, (short) ID);
      offset += 2;


      MetaModelEnum.ID.setLength(this.getId() != null ? this.getId().length() : 0);
      MetaModelEnum.PCKG.setLength(this.getPckg().size());

      int directorySize = getMetaModelDirectorySize();
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

         for (MetaModelEnum metaModelEnum : MetaModelEnum.values()) {
            if (metaModelEnum.isDirectoryEntry == true) {
               int id = metaModelEnum.getId();
               int length = metaModelEnum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == MetaModelEnum.ID.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "id", offset));
                  if (getId() != null) {
                     bb = GreenballMessagesUtility.insertString(bb, offset, getId());
                     offset += length * 1;
                  }
               }
               else if (id == MetaModelEnum.PCKG.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "pckg", offset));
                  for (PackageSubType packageSubType : this.pckg) {
                     byte[] bytes = packageSubType.pack();
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

         // Calculate and insert the checksum
         long checksum = GreenballMessagesUtility.getChecksum(bb, bb.length - 8);
         bb = GreenballMessagesUtility.insertLong(bb, bb.length - 8, checksum);
      }
      log4j.debug("Leaving " + METHOD);
      return bb;
   }
   // Leaving buildPackMethod()

   // Entered buildUnpackMethod()
   /**
    * This method unpacks a byte array containing a MetaModel object.
    *
    * @return The byte array as a MetaModel message object.
    */
   public MetaModel unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      MetaModel metaModel = new MetaModel();


      // Get the directory
      int directorySize = getMetaModelDirectorySize();
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

         if (id == MetaModelEnum.ID.getId()) {
            metaModel.setId(GreenballMessagesUtility.getString(ba, offset, length));
         }
         else if (id == MetaModelEnum.PCKG.getId()) {
            byte[] bytes = new byte[length];
            for (int index = 0; index < length; index++) {
               bytes[index] = GreenballMessagesUtility.getByte(ba, (offset + index) * 8);
            }
            metaModel.getPckg().add(new PackageSubType().unpack(bytes));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return metaModel;
   }
   // Leaving buildUnpackMethod()

   // Entered buildPackStrMethod()
   /**
    * This method packs a MetaModel object into a String. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A String which represents a MetaModel message object.
    * @throws MissingAttributeException
    */
   public String packStr() throws MissingAttributeException {
      final String METHOD = "packStr()";
      log4j.debug("Entered " + METHOD);

      String msg = null;
      setErrorMsg(null);
       
      /*
       * Initialize attribute values.
       */
      InitializeMetaModel initializeMetaModel = new InitializeMetaModel(this);
      Element element = initializeMetaModel.initialize();

      if (getErrorMsg() == null) {
         /*
          * Convert object to String.
          * See convertObjectToString() in JBitByBitGenerator.java.
          */
         msg = "{" + element.getName();
         for (AbstractAttribute attr : element.getAbstractAttributes()) {
            msg = buildString(attr, msg);
         }
         msg = msg.concat("}");

         log4j.debug("msg: " + msg);
      }

      log4j.debug("Leaving " + METHOD);
      return msg;
   }
   // Leaving buildPackStrMethod()

   // Entered buildUnpackStrMethod()
   /**
    * The unpack() method unpacks a String into an object. The String must conform to the
    * SMBG grammar.
    *
     * @return The message string as an object.
    */
   public MetaModel unpack(String buffer) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      setErrorMsg(null);

      // Create the lexer
      log4j.debug("lexing...");
      SMBGLexer lexer = new SMBGLexer(new ANTLRStringStream(buffer));

      int nbrOfSyntaxErrors = lexer.getNumberOfSyntaxErrors();
      log4j.debug("# of lexer errors: " + nbrOfSyntaxErrors);

      // Check for errors
      if (nbrOfSyntaxErrors != 0) {
         for (String error : lexer.getErrors()) {
            log4j.error(error);
         }

         return null;
      }

      // Wrap a token-stream around the lexer
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      // Create the parser
      log4j.debug("parsing...");
      SMBGParser parser = new SMBGParser(tokenStream);

      // Check for errors
      nbrOfSyntaxErrors = parser.getNumberOfSyntaxErrors();
      log4j.debug("# of parse errors: " + nbrOfSyntaxErrors);

      if (nbrOfSyntaxErrors != 0) {
         for (String error : parser.getErrors()) {
               log4j.error(error);
         }

         return null;
      }

      // Unpack the string into objects
      log4j.debug("unpacking...");
      try {
         parser.unpack();
      } catch (RecognitionException e) {
         log4j.error("Error: " + e.getMessage());
         setErrorMsg(e.getMessage());
         return null;
      }
      
      Element element = parser.getElement();
      element.dump();

      /*
       * Instantiate the MetaModel object.
       */
       InstantiateMetaModel instantiateMetaModel = new InstantiateMetaModel(element);
       MetaModel metaModel = instantiateMetaModel.instantiate();

      /*
       * Verify that a value was provided for all mandatory attributes.
       */
      String result = instantiateMetaModel.validate();
      if (result != null) {
         log4j.error("Error: " + result);
         setErrorMsg(result);
         return null;
      }

      log4j.debug("Leaving " + METHOD);
      return metaModel;
   }
   // Leaving buildUnpackStrMethod()

   private String buildString(AbstractAttribute attr, String msg) {
      for (KeyValuePair kvp : attr.getKeyValuePairs()) {
         msg = msg.concat(" " + kvp.getKey() + ":" + kvp.getValue());
      }

      for (Element element : attr.getElements()) {
         msg = msg.concat(" {" + element.getName());
         for (AbstractAttribute abstractAttribute : element.getAbstractAttributes()) {
            msg = buildString(abstractAttribute, msg);
         }
         msg = msg.concat("}");
      }

      return msg;
   }

   /**
    * This method sets the id attribute. Setting of this value is required.
    * @param id The id attribute.
    */
   public void setId(String id) {
      this.id = id;
   }

   /**
    * This method gets the id attribute. The id attribute is a required attribute.
    */
   public String getId() {
      return this.id;
   }

   /**
    * This method sets the pckg attribute. Setting of this value is required.
    * @param pckg The pckg.
    */
   public void setPckg(List<PackageSubType> pckg) {
      this.pckg = pckg;
   }

   /**
    * This method gets the pckg attribute. The pckg attribute is a required attribute.
    */
   public List<PackageSubType> getPckg() {
      if (this.pckg == null) {
         this.pckg = new ArrayList<PackageSubType>();
      }
      return this.pckg;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getMetaModelDirectorySize() {
      int directorySize = 0;

      // id
      directorySize++;
      // pckg
      directorySize += getPckg().size();

      return directorySize;
   }


   /**
    * This method gets the size of the MetaModel object.
    * @return The size in bytes.
    */
   public int getMetaModelSize() {
      int size = 0;

      int directorySize = getMetaModelDirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add two bytes for the ID
      size += 2;
      // Add eight bytes for the CRC
      size += 8;
      // Add size of id
      size += (getId() != null ? getId().length() : 0);
      // Add size of pckg
      for (PackageSubType packageSubType: getPckg()) {
         size += packageSubType.getPackageSubTypeSize();
      }

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);
      result.append(" id: " + id + NEW_LINE);

      if (pckg != null) {
         for (PackageSubType pckgPackageSubType : pckg) {
            result.append(pckgPackageSubType.toString());
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
         + ((String) id).hashCode();
      return result;
   }

   /**
    * The equals method checks for equality. 
    */
   public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;

      MetaModel metaModel = (MetaModel) obj;
      if (!metaModel.getId().equals(this.getId())) {
         return false;
      }

      return true;
   }
}