/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateInstantiationFile()). 
 * Do not edit.
 */
package com.viacron.greenball.app.bbb;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.viacron.utils.StringMessageBuffer.parser.AbstractAttribute;
import com.viacron.utils.StringMessageBuffer.parser.Element;
import com.viacron.utils.StringMessageBuffer.parser.KeyValuePair;

public class InstantiateATestMessage {
   private static Logger log4j = Logger.getLogger(InstantiateATestMessage.class);

   /*
    * The isUpdated flags. If an attribute is required by the grammar then a value
    * must be provided, and the isUpdated flag will be set when the value is
    * obtained during unpacking. After the object is constructed during unpacking, 
    * validation will be performed to make sure a value was provided for all attributes
    * that are not optional. 
    * See buildFlags() in JBitByBitGenerator.java.
    */
   private boolean isABooleanUpdated = false;
   private boolean isAByteUpdated = false;
   private boolean isACharUpdated = false;
   private boolean isACalendarUpdated = false;
   private boolean isADoubleUpdated = false;
   private boolean isAnIntUpdated = false;
   private boolean isALongUpdated = false;
   private boolean isAShortUpdated = false;
   private boolean isAStringUpdated = false;
   private boolean isSomeBooleansUpdated = false;
   private boolean isSomeBytesUpdated = false;
   private boolean isSomeCharsUpdated = false;
   private boolean isSomeCalendarsUpdated = false;
   private boolean isSomeDoublesUpdated = false;
   private boolean isSomeFloatsUpdated = false;
   private boolean isSomeIntsUpdated = false;
   private boolean isSomeLongsUpdated = false;
   private boolean isSomeShortsUpdated = false;
   private boolean isSomeStringsUpdated = false;
   private boolean isActionUpdated = false;
   private boolean isAppStateUpdated = false;
   private boolean isATenBitEnumUpdated = false;
   private boolean isUserStatusUpdated = false;
   private boolean isZBigOneUpdated = false;

   private Element element;
   private ATestMessage aTestMessage;

   /**
    * The InstantiateATestMessage class instantiates the ATestMessage object.
    *
    * @param element The root element returned by the parser after parsing the string
    *                representing the ATestMessage.
    */
   public InstantiateATestMessage(Element element) {
      this.element = element;   
      this.aTestMessage = new ATestMessage();
   }

   /**
    * This method instantiates the ATestMessage.
    *
    * @return The ATestMessage.
    */
   public ATestMessage instantiate() {
      final String METHOD = "instantiate()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("ATestMessage: " + element.getName());
      log4j.debug("# of attributes: " + element.getAbstractAttributes().size());

      instantiateATestMessageAttributes(element);

      for (AbstractAttribute abstractAttribute : element
            .getAbstractAttributes()) {
         for (Element e : abstractAttribute.getElements()) {
            log4j.debug("element name: " + e.getName());
      instantiateATestMessageSubTypeRefs(e);
      }
      }

      log4j.debug("Leaving " + METHOD);
      return aTestMessage;
      }

      /*
       * This method instantiates the ATestMessage attributes.
       * 
       * @param Element element
       */
      private void instantiateATestMessageAttributes(Element element) {
      final String METHOD = "instantiateATestMessageAttributes()";
      log4j.debug("Entered " + METHOD);

      log4j.debug("element name: " + element.getName());
      for (AbstractAttribute attr : element.getAbstractAttributes()) {
         for (KeyValuePair kvp : attr.getKeyValuePairs()) {
            log4j.debug("key: " + kvp.getKey());
            log4j.debug("value: " + kvp.getValue());
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aBoolean")) {
               log4j.debug("setting value of \"aBoolean\" to: " + kvp.getValue());
               this.isABooleanUpdated = true;
               aTestMessage.setABoolean(kvp.getValue().equals("true"));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aByte")) {
               log4j.debug("setting value of \"aByte\" to: " + kvp.getValue());
               this.isAByteUpdated = true;
               aTestMessage.setAByte(Byte.parseByte(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aChar")) {
               log4j.debug("setting value of \"aChar\" to: " + kvp.getValue());
               this.isACharUpdated = true;
               aTestMessage.setAChar(kvp.getValue().charAt(0));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aCalendar")) {
               log4j.debug("setting value of \"aCalendar\" to: " + kvp.getValue());
               this.isACalendarUpdated = true;
               Date date;
               try {
                  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                  date = formatter.parse(kvp.getValue());
                  Calendar cal = Calendar.getInstance();
                  cal.setTime(date);
               aTestMessage.setACalendar(cal);
               } catch (ParseException ex) {
                  log4j.error("Invalid date format: " + kvp.getValue());
               }
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aDouble")) {
               log4j.debug("setting value of \"aDouble\" to: " + kvp.getValue());
               this.isADoubleUpdated = true;
               aTestMessage.setADouble(Double.parseDouble(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aFloat")) {
               log4j.debug("setting value of \"aFloat\" to: " + kvp.getValue());
               aTestMessage.setAFloat(Float.parseFloat(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("anInt")) {
               log4j.debug("setting value of \"anInt\" to: " + kvp.getValue());
               this.isAnIntUpdated = true;
               aTestMessage.setAnInt(Integer.parseInt(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aLong")) {
               log4j.debug("setting value of \"aLong\" to: " + kvp.getValue());
               this.isALongUpdated = true;
               aTestMessage.setALong(Long.parseLong(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aShort")) {
               log4j.debug("setting value of \"aShort\" to: " + kvp.getValue());
               this.isAShortUpdated = true;
               aTestMessage.setAShort(Short.parseShort(kvp.getValue()));
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttribute()
            if (kvp.getKey().equals("aString")) {
               log4j.debug("setting value of \"aString\" to: " + kvp.getValue());
               this.isAStringUpdated = true;
               aTestMessage.setAString(kvp.getValue());
            }
            // Leaving instantiateMsgAttribute()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someBooleans[")) {
               this.isSomeBooleansUpdated = true;
               if(aTestMessage.getSomeBooleans() == null) {
               aTestMessage.setSomeBooleans(new ArrayList<Boolean>());
               }
               aTestMessage.getSomeBooleans().add(kvp.getValue().equals("true"));
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someBytes[")) {
               this.isSomeBytesUpdated = true;
               if(aTestMessage.getSomeBytes() == null) {
               aTestMessage.setSomeBytes(new ArrayList<Byte>());
               }
               aTestMessage.getSomeBytes().add(Byte.parseByte(kvp.getValue()));
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someChars[")) {
               this.isSomeCharsUpdated = true;
               if(aTestMessage.getSomeChars() == null) {
               aTestMessage.setSomeChars(new ArrayList<Character>());
               }
               aTestMessage.getSomeChars().add(kvp.getValue().toCharArray()[0]);
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someCalendars[")) {
               this.isSomeCalendarsUpdated = true;
               if(aTestMessage.getSomeCalendars() == null) {
               aTestMessage.setSomeCalendars(new ArrayList<Calendar>());
               }
               Date date;
               try {
                  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                  date = formatter.parse(kvp.getValue());
                  Calendar cal = Calendar.getInstance();
                  cal.setTime(date);
               aTestMessage.getSomeCalendars().add(cal);
               } catch (ParseException ex) {
                  log4j.error("Invalid date format: " + kvp.getValue());
               }
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someDoubles[")) {
               this.isSomeDoublesUpdated = true;
               if(aTestMessage.getSomeDoubles() == null) {
               aTestMessage.setSomeDoubles(new ArrayList<Double>());
               }
               aTestMessage.getSomeDoubles().add(Double.parseDouble(kvp.getValue()));
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someFloats[")) {
               this.isSomeFloatsUpdated = true;
               if(aTestMessage.getSomeFloats() == null) {
               aTestMessage.setSomeFloats(new ArrayList<Float>());
               }
               aTestMessage.getSomeFloats().add(Float.parseFloat(kvp.getValue()));
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someInts[")) {
               this.isSomeIntsUpdated = true;
               if(aTestMessage.getSomeInts() == null) {
               aTestMessage.setSomeInts(new ArrayList<Integer>());
               }
               aTestMessage.getSomeInts().add(Integer.parseInt(kvp.getValue()));
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someLongs[")) {
               this.isSomeLongsUpdated = true;
               if(aTestMessage.getSomeLongs() == null) {
               aTestMessage.setSomeLongs(new ArrayList<Long>());
               }
               aTestMessage.getSomeLongs().add(Long.parseLong(kvp.getValue()));
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someShorts[")) {
               this.isSomeShortsUpdated = true;
               if(aTestMessage.getSomeShorts() == null) {
               aTestMessage.setSomeShorts(new ArrayList<Short>());
               }
               aTestMessage.getSomeShorts().add(Short.parseShort(kvp.getValue()));
            }
            // Leaving instantiateMsgAttributeList()
            // Entered instantiateMsgAttributeList()
            if (kvp.getKey().startsWith("someStrings[")) {
               this.isSomeStringsUpdated = true;
               if(aTestMessage.getSomeStrings() == null) {
               aTestMessage.setSomeStrings(new ArrayList<String>());
               }
               aTestMessage.getSomeStrings().add(kvp.getValue());
            }
            // Leaving instantiateMsgAttributeList()
                        // Entered instantiatePEnumRef()
            if (kvp.getKey().equals("action")) {
            this.isActionUpdated = true;
            log4j.debug("setting value of \"action\" to: " + kvp.getValue());
            aTestMessage.setAction(ChatAction.valueOf(kvp.getValue()));
            //this.action = ChatAction.valueOf(kvp.getValue());
            }
            // Leaving instantiatePEnumRef()

                        // Entered instantiatePEnumRef()
            else if (kvp.getKey().equals("appState")) {
            this.isAppStateUpdated = true;
            log4j.debug("setting value of \"appState\" to: " + kvp.getValue());
            aTestMessage.setAppState(AppState.valueOf(kvp.getValue()));
            //this.appState = AppState.valueOf(kvp.getValue());
            }
            // Leaving instantiatePEnumRef()

                        // Entered instantiatePEnumRef()
            else if (kvp.getKey().equals("aTenBitEnum")) {
            this.isATenBitEnumUpdated = true;
            log4j.debug("setting value of \"aTenBitEnum\" to: " + kvp.getValue());
            aTestMessage.setATenBitEnum(TenBitEnum.valueOf(kvp.getValue()));
            //this.aTenBitEnum = TenBitEnum.valueOf(kvp.getValue());
            }
            // Leaving instantiatePEnumRef()

                        // Entered instantiatePEnumRef()
            else if (kvp.getKey().equals("userStatus")) {
            this.isUserStatusUpdated = true;
            log4j.debug("setting value of \"userStatus\" to: " + kvp.getValue());
            aTestMessage.setUserStatus(UserStatusEnum.valueOf(kvp.getValue()));
            //this.userStatus = UserStatusEnum.valueOf(kvp.getValue());
            }
            // Leaving instantiatePEnumRef()

                        // Entered instantiatePEnumRef()
            else if (kvp.getKey().equals("zBigOne")) {
            this.isZBigOneUpdated = true;
            log4j.debug("setting value of \"zBigOne\" to: " + kvp.getValue());
            aTestMessage.setZBigOne(ZbigOne.valueOf(kvp.getValue()));
            //this.zBigOne = ZbigOne.valueOf(kvp.getValue());
            }
            // Leaving instantiatePEnumRef()

         }
      }

      log4j.debug("Leaving " + METHOD);
   }

   /*
    * This method instantiates the ATestMessage SubType references.
    * 
    * @param Element element
    */
   private void instantiateATestMessageSubTypeRefs(Element element) {
      final String METHOD = "instantiateATestMessageSubTypeRefs()";
      log4j.debug("Entered " + METHOD);


      log4j.debug("Leaving " + METHOD);
   }


   /**
    * The validate method checks that a value was provided for all required 
    * attributes.
    *
    * @return The error message or null if no error occurred.
    */
   protected String validate() {
      final String METHOD = "validate()";
      log4j.debug("Entered " + METHOD);

      String result = null;

      // Entered buildValidationMethod()
      if (!this.isABooleanUpdated) {
         String msg = "ABoolean is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
      }

      if (!this.isAByteUpdated) {
         String msg = "AByte is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isACharUpdated) {
         String msg = "AChar is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isACalendarUpdated) {
         String msg = "ACalendar is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isADoubleUpdated) {
         String msg = "ADouble is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isAnIntUpdated) {
         String msg = "AnInt is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isALongUpdated) {
         String msg = "ALong is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isAShortUpdated) {
         String msg = "AShort is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isAStringUpdated) {
         String msg = "AString is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeBooleansUpdated) {
         String msg = "SomeBooleans is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeBytesUpdated) {
         String msg = "SomeBytes is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeCharsUpdated) {
         String msg = "SomeChars is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeCalendarsUpdated) {
         String msg = "SomeCalendars is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeDoublesUpdated) {
         String msg = "SomeDoubles is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeFloatsUpdated) {
         String msg = "SomeFloats is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeIntsUpdated) {
         String msg = "SomeInts is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeLongsUpdated) {
         String msg = "SomeLongs is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeShortsUpdated) {
         String msg = "SomeShorts is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }

      if (!this.isSomeStringsUpdated) {
         String msg = "SomeStrings is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }
      if (!this.isActionUpdated) {
         String msg = "Action is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }
      if (!this.isAppStateUpdated) {
         String msg = "AppState is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }
      if (!this.isATenBitEnumUpdated) {
         String msg = "ATenBitEnum is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }
      if (!this.isUserStatusUpdated) {
         String msg = "UserStatus is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }
      if (!this.isZBigOneUpdated) {
         String msg = "ZBigOne is required, but no value was provided.";
         if (result == null) {
            result = msg;
         }
         else {
            result = result.concat("\n" + msg);
         }
      }


      if (result != null) {
         log4j.debug("result: " + result);
      }

      log4j.debug("Leaving " + METHOD);
      return result;
   }
}
