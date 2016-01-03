
/**
 * XYIncExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */

package com.zup.clientTest.ws;

public class XYIncExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1451730336209L;
    
    private com.zup.clientTest.ws.XYIncStub.XYIncException faultMessage;

    
        public XYIncExceptionException() {
            super("XYIncExceptionException");
        }

        public XYIncExceptionException(java.lang.String s) {
           super(s);
        }

        public XYIncExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public XYIncExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.zup.clientTest.ws.XYIncStub.XYIncException msg){
       faultMessage = msg;
    }
    
    public com.zup.clientTest.ws.XYIncStub.XYIncException getFaultMessage(){
       return faultMessage;
    }
}
    