package com.example.logger;

import com.harris.htsc.jcss.CmtLog;
import com.harris.htsc.jcss.CmtLog.Code;
import com.harris.htsc.jcss.CmtLog.Facility;

/**
 * The CmtLogger class is a wrapper around the OS/COMET CmtLog utility.
 * 
 * @limitations None
 * 
 * @author S. Ritchie
 * 
 * @history PTR 10802 Apr 25, 2014 sritchie : Initial creation.
 */
public class CmtLogger
{
   /**
    * This method creates a CmtLog.
    * 
    * @param code
    *           The code.
    * @param msg
    *           The log message.
    */
   public static void log(Code code, String msg)
   {
      CmtLog.log(Facility.APP0, code, msg);
   }

   public static void entry(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.ENTRY, "Entered " + msg);
   }

   public static void exit(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.EXIT, "Leaving " + msg);
   }

   public static void debug0(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.DEBUG0, msg);
   }

   public static void debug1(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.DEBUG1, msg);
   }

   public static void debug2(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.DEBUG2, msg);
   }

   public static void debug3(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.DEBUG3, msg);
   }

   public static void error(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.ERROR, msg);
   }

   public static void warn(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.WARN, msg);
   }

   public static void info(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.INFO, msg);
   }

   public static void verify(String msg)
   {
      CmtLog.log(Facility.APP0, CmtLog.Code.VERIFY, msg);
   }
}