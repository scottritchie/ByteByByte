/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateRootClassEnumFile()).
 * Do not edit.
 */
package com.bbb.example;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * The ExampleMessagesEnum class is an enumeration of the root class of the
 * messaging system defined by the Example grammar.
 */
public enum ExampleMessagesEnum {
   HELLO_WORLD(0, "HelloWorld"),
   LOG_MON_MESSAGE(1, "LogMonMessage"),
   DETAILS(2, "Details");

   private final int id;
   private final String name;

   private static final Map<Integer, ExampleMessagesEnum> lookup = new HashMap<Integer, ExampleMessagesEnum>();

   static {
      for (ExampleMessagesEnum enumType : EnumSet.allOf(ExampleMessagesEnum.class)) {
         lookup.put(enumType.getId(), enumType);
      }
   }

   ExampleMessagesEnum(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public ExampleMessagesEnum getId(String name) {
      for (ExampleMessagesEnum e : ExampleMessagesEnum.values()) {
         if (e.getName().equals(name)) {
            return e;
         }
      }

      return null;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public static ExampleMessagesEnum toEnum(int id) {
      return lookup.get(id);
   }

   public static ExampleMessagesEnum toEnum(String name) {
      for (ExampleMessagesEnum e : ExampleMessagesEnum.values()) {
         if (e.getName().equals(name)) {
            return e;
         }
      }

      return null;
   }
}