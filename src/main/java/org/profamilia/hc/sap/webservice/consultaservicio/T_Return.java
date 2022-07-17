 /**
  * T_Return.java
  *
  * This file was auto-generated from WSDL
  * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
  */

  package org.profamilia.hc.sap.webservice.consultaservicio;

 public class T_Return  implements java.io.Serializable {
     private java.lang.String id;

     private java.lang.String tipo;

     private java.lang.String mensaje;

     public T_Return() {
     }

     public T_Return(
            java.lang.String id,
            java.lang.String tipo,
            java.lang.String mensaje) {
            this.id = id;
            this.tipo = tipo;
            this.mensaje = mensaje;
     }


     /**
      * Gets the id value for this T_Return.
      * 
      * @return id
      */
     public java.lang.String getId() {
         return id;
     }


     /**
      * Sets the id value for this T_Return.
      * 
      * @param id
      */
     public void setId(java.lang.String id) {
         this.id = id;
     }


     /**
      * Gets the tipo value for this T_Return.
      * 
      * @return tipo
      */
     public java.lang.String getTipo() {
         return tipo;
     }


     /**
      * Sets the tipo value for this T_Return.
      * 
      * @param tipo
      */
     public void setTipo(java.lang.String tipo) {
         this.tipo = tipo;
     }


     /**
      * Gets the mensaje value for this T_Return.
      * 
      * @return mensaje
      */
     public java.lang.String getMensaje() {
         return mensaje;
     }


     /**
      * Sets the mensaje value for this T_Return.
      * 
      * @param mensaje
      */
     public void setMensaje(java.lang.String mensaje) {
         this.mensaje = mensaje;
     }

     private java.lang.Object __equalsCalc = null;
     public synchronized boolean equals(java.lang.Object obj) {
         if (!(obj instanceof T_Return)) return false;
         T_Return other = (T_Return) obj;
         if (obj == null) return false;
         if (this == obj) return true;
         if (__equalsCalc != null) {
             return (__equalsCalc == obj);
         }
         __equalsCalc = obj;
         boolean _equals;
         _equals = true && 
             ((this.id==null && other.getId()==null) || 
              (this.id!=null &&
               this.id.equals(other.getId()))) &&
             ((this.tipo==null && other.getTipo()==null) || 
              (this.tipo!=null &&
               this.tipo.equals(other.getTipo()))) &&
             ((this.mensaje==null && other.getMensaje()==null) || 
              (this.mensaje!=null &&
               this.mensaje.equals(other.getMensaje())));
         __equalsCalc = null;
         return _equals;
     }

     private boolean __hashCodeCalc = false;
     public synchronized int hashCode() {
         if (__hashCodeCalc) {
             return 0;
         }
         __hashCodeCalc = true;
         int _hashCode = 1;
         if (getId() != null) {
             _hashCode += getId().hashCode();
         }
         if (getTipo() != null) {
             _hashCode += getTipo().hashCode();
         }
         if (getMensaje() != null) {
             _hashCode += getMensaje().hashCode();
         }
         __hashCodeCalc = false;
         return _hashCode;
     }

     // Type metadata
     private static org.apache.axis.description.TypeDesc typeDesc =
         new org.apache.axis.description.TypeDesc(T_Return.class, true);

     static {
         typeDesc.setXmlType(new javax.xml.namespace.QName("urn:listaprecios:clinico:sap", "T_Return"));
         org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
         elemField.setFieldName("id");
         elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
         elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
         elemField.setMinOccurs(0);
         elemField.setNillable(false);
         typeDesc.addFieldDesc(elemField);
         elemField = new org.apache.axis.description.ElementDesc();
         elemField.setFieldName("tipo");
         elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
         elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
         elemField.setMinOccurs(0);
         elemField.setNillable(false);
         typeDesc.addFieldDesc(elemField);
         elemField = new org.apache.axis.description.ElementDesc();
         elemField.setFieldName("mensaje");
         elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
         elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
         elemField.setMinOccurs(0);
         elemField.setNillable(false);
         typeDesc.addFieldDesc(elemField);
     }

     /**
      * Return type metadata object
      */
     public static org.apache.axis.description.TypeDesc getTypeDesc() {
         return typeDesc;
     }

     /**
      * Get Custom Serializer
      */
     public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType, 
            java.lang.Class _javaType,  
            javax.xml.namespace.QName _xmlType) {
         return 
           new  org.apache.axis.encoding.ser.BeanSerializer(
             _javaType, _xmlType, typeDesc);
     }

     /**
      * Get Custom Deserializer
      */
     public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType, 
            java.lang.Class _javaType,  
            javax.xml.namespace.QName _xmlType) {
         return 
           new  org.apache.axis.encoding.ser.BeanDeserializer(
             _javaType, _xmlType, typeDesc);
     }

 }
