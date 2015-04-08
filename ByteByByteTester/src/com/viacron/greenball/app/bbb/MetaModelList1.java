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
 * The MetaModelList1 class defines a message of the messaging system defined
 * by the GreenballMessages grammar. It provides methods for packing a MetaModelList1 object
 * into a byte array or string, and for unpacking a byte array or string
 * back into a MetaModelList1 object.
 */
public class MetaModelList1 {
   private static final int ID = GreenballMessagesEnum.META_MODEL_LIST1.getId();

   /**
    * The number of bits required to represent the MetaModelList1Enum IDs.
    * # of attributes: 1
    * # of PEnumRefs: 0
    */
   private static final int ID_BITS = 0;

   private static GreenballMessagesDirectoryEntry[] theDirectory;
   private static final int DIRECTORY_OFFSET = 2;

   private static Logger log4j = Logger.getLogger(MetaModelList1.class);

   // Entered buildClassEnum()
   private enum MetaModelList1Enum {
      // This is a directory item. It's offset and length cannot be determined
      // until runtime.
      META_MODELS(0, -1, 0, true);

      private final int id;
      private final int offsetInBits;
      private int length;
      private boolean isDirectoryEntry;

      MetaModelList1Enum(int id, int offsetInBits, int length, boolean isDirectoryEntry) {
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
   private List<MetaModel1> metaModels;

   private String theErrorMsg;

   /**
    * The MetaModelList1 no-arg constructor.
    */
   public MetaModelList1() {}

   /**
    * The MetaModelList1 constructor.
    * See buildParameterAnnotations() in JBitByBitGenerator.java.
    *
    * @param metaModels The metaModels message attribute.
    */
   public MetaModelList1(List<MetaModel1> metaModels) {
      // Entered buildParameterAssignments()
      this.setMetaModels(metaModels);
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
    * This method packs a MetaModelList1 object into a byte array. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A byte array which represents a MetaModelList1 message object.
    * @throws MissingAttributeException
    */
   public byte[] pack() throws MissingAttributeException {
      final String METHOD = "pack()";
      log4j.debug("Entered " + METHOD);

      int byteArraySize = getMetaModelList1Size();
      log4j.debug("byteArraySize: " + byteArraySize);
      byte[] bb = new byte[byteArraySize];

      /*
       * Convert object to byte array.
       */
      int offset = 0;

      bb = GreenballMessagesUtility.insertShort(bb, offset, (short) ID);
      offset += 2;


      MetaModelList1Enum.META_MODELS.setLength(this.getMetaModels().size());

      int directorySize = getMetaModelList1DirectorySize();
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

         for (MetaModelList1Enum metaModelList1Enum : MetaModelList1Enum.values()) {
            if (metaModelList1Enum.isDirectoryEntry == true) {
               int id = metaModelList1Enum.getId();
               int length = metaModelList1Enum.getLength();

               theDirectory[index].setId(id);
               theDirectory[index].setLength(length);
               theDirectory[index].setOffset(offset);

               // Insert the data
               if (id == MetaModelList1Enum.META_MODELS.getId()) {
                  log4j.debug(String.format("inserting %s at offset %d", "metaModels", offset));
                  for (MetaModel1 metaModel1 : this.metaModels) {
                     byte[] bytes = metaModel1.pack();
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
    * This method unpacks a byte array containing a MetaModelList1 object.
    *
    * @return The byte array as a MetaModelList1 message object.
    */
   public MetaModelList1 unpack(byte[] ba) {
      final String METHOD = "unpack()";
      log4j.debug("Entered " + METHOD);

      MetaModelList1 metaModelList1 = new MetaModelList1();


      // Get the directory
      int directorySize = getMetaModelList1DirectorySize();
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

         if (id == MetaModelList1Enum.META_MODELS.getId()) {
            byte[] bytes = new byte[length];
            for (int index = 0; index < length; index++) {
               bytes[index] = GreenballMessagesUtility.getByte(ba, (offset + index) * 8);
            }
            metaModelList1.getMetaModels().add(new MetaModel1().unpack(bytes));
         }
      }

      log4j.debug("Leaving " + METHOD);
      return metaModelList1;
   }
   // Leaving buildUnpackMethod()

   // Entered buildPackStrMethod()
   /**
    * This method packs a MetaModelList1 object into a String. If a required attribute is not
    * provided an exception will be thrown.
    *
    * @return A String which represents a MetaModelList1 message object.
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
      InitializeMetaModelList1 initializeMetaModelList1 = new InitializeMetaModelList1(this);
      Element element = initializeMetaModelList1.initialize();

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
   public MetaModelList1 unpack(String buffer) {
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
       * Instantiate the MetaModelList1 object.
       */
       InstantiateMetaModelList1 instantiateMetaModelList1 = new InstantiateMetaModelList1(element);
       MetaModelList1 metaModelList1 = instantiateMetaModelList1.instantiate();

      /*
       * Verify that a value was provided for all mandatory attributes.
       */
      String result = instantiateMetaModelList1.validate();
      if (result != null) {
         log4j.error("Error: " + result);
         setErrorMsg(result);
         return null;
      }

      log4j.debug("Leaving " + METHOD);
      return metaModelList1;
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
    * This method sets the metaModels attribute. Setting of this value is required.
    * @param metaModels The metaModels.
    */
   public void setMetaModels(List<MetaModel1> metaModels) {
      this.metaModels = metaModels;
   }

   /**
    * This method gets the metaModels attribute. The metaModels attribute is a required attribute.
    */
   public List<MetaModel1> getMetaModels() {
      if (this.metaModels == null) {
         this.metaModels = new ArrayList<MetaModel1>();
      }
      return this.metaModels;
   }

   /**
    * This method gets the size of the directory.
    */
   private int getMetaModelList1DirectorySize() {
      int directorySize = 0;

      // metaModels
      directorySize += getMetaModels().size();

      return directorySize;
   }


   /**
    * This method gets the size of the MetaModelList1 object.
    * @return The size in bytes.
    */
   public int getMetaModelList1Size() {
      int size = 0;

      int directorySize = getMetaModelList1DirectorySize();
      size += directorySize * GreenballMessagesDirectoryEntry.DIRECTORY_ENTRY_SIZE_IN_BYTES;
      // Add two bytes for the ID
      size += 2;
      // Add eight bytes for the CRC
      size += 8;
      // Add size of metaModels
      for (MetaModel1 metaModel1: getMetaModels()) {
         size += metaModel1.getMetaModel1Size();
      }

      return size;
   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");

      result.append(this.getClass().getSimpleName() + " Object {" + NEW_LINE);

      if (metaModels != null) {
         for (MetaModel1 metaModelsMetaModel1 : metaModels) {
            result.append(metaModelsMetaModel1.toString());
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
      return result;
   }

   /**
    * The equals method checks for equality. 
    */
   public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;

      MetaModelList1 metaModelList1 = (MetaModelList1) obj;
      return true;
   }
}
