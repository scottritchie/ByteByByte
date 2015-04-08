/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateEnumFile()). 
 * Do not edit.
 */
package com.bbb.example;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Severity {
    ENTRY(0, "entry"),
    EXIT(1, "exit"),
    DEBUG0(2, "debug0"),
    DEBUG1(3, "debug1"),
    DEBUG2(4, "debug2"),
    DEBUG3(5, "debug3"),
    ERROR(6, "error"),
    WARN(7, "warn"),
    INFO(8, "info"),
    VERIFY(9, "verify"),
    EXCEPTION(10, "exception");

   private static final Map<Integer, Severity> lookup = new HashMap<Integer, Severity>();

   static {
      for (Severity enumType : EnumSet.allOf(Severity.class)) {
         lookup.put(enumType.getId(), enumType);
      }
   }

   private final int id;
   private final String value;

   Severity(int id, String v) {
      this.id = id;
      this.value = v;
   }

   public int getId() {
      return this.id;
   }

   public String value() {
      return this.value;
   }

   public static Severity fromValue(String v) {
      for (Severity severity : Severity.values()) {
         if (severity.value.equals(v)) {
               return severity;
         }
      }
      throw new IllegalArgumentException(v);
   }

   public static Severity toEnum(int id) {
      return lookup.get(id);
   }
}