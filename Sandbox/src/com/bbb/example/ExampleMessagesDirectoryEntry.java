/*
 * WARNING: This file was generated by BitByBitGenerator.xtend (see
 * generateDirectoryEntryClass()).
 * Do not edit.
 */
package com.bbb.example;

/**
 * TheExampleMessagesDirectoryEntry class defines a directory entry.
 */
public class ExampleMessagesDirectoryEntry {
   private int id;
   private int offset;
   private int length;

   public static int DIRECTORY_ENTRY_SIZE_IN_BYTES = 12;

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
